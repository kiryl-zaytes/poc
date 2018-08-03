package com.nbc.testautomation.saucelabs;

import com.saucelabs.saucerest.SauceREST;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * TestNG listener which adds support of SauceLabs in tests
 */
public class SauceLabsTestListener extends TestListenerAdapter {

    /**
     * Updating SauceLabs job. See details here: https://wiki.saucelabs.com/display/DOCS/Job+Methods#JobMethods-UpdateJob.
     * Renaming job to meaningful name from 'unnamed job...' and adding job to build
     *
     * @param result test result
     */
    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart(result);

        SauceREST sauceREST = getSauceREST(result);
        String sessionId = getSessionId(result);

        if (sauceREST != null) {
            Map<String, Object> updatedJobInfo = new HashMap<String, Object>();
            updatedJobInfo.put("name", String.format("%s.%s", result.getInstance().getClass().getSimpleName(), result.getName()));
            updatedJobInfo.put("build", getBuildId());
            sauceREST.updateJobInfo(sessionId, updatedJobInfo);
        }
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);

        SauceREST sauceREST = getSauceREST(tr);
        String sessionId = getSessionId(tr);

        if (sauceREST != null) {
            Map<String, Object> updatedJobInfo = new HashMap<String, Object>();
            updatedJobInfo.put("passed", true);
            sauceREST.updateJobInfo(sessionId, updatedJobInfo);
        }
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);

        SauceREST sauceREST = getSauceREST(tr);
        String sessionId = getSessionId(tr);

        if (sauceREST != null) {
            Map<String, Object> updatedJobInfo = new HashMap<String, Object>();
            updatedJobInfo.put("passed", false);
            sauceREST.updateJobInfo(sessionId, updatedJobInfo);
        }
    }

    protected SauceREST getSauceREST(ITestResult testResult) {
        return ((SauceLabsRestAware) testResult.getInstance()).getSauceREST();
    }

    protected String getSessionId(ITestResult testResult) {
        return ((SauceLabsRestAware) testResult.getInstance()).getSessionId();
    }

    protected String getBuildId() {
        String buildId = System.getProperty("chiller.automation.build.id");

        if (buildId == null) {
            buildId = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
            System.setProperty("chiller.automation.build.id", buildId);
        }

        return buildId;
    }
}
