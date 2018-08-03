package com.poc.pubcentral.common.driver.listeners;

import com.poc.pubcentral.common.driver.configuration.SeleniumContext;
import com.saucelabs.saucerest.SauceREST;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TestListeners implements ITestListener {

    private static SeleniumContext context;
    private static SauceREST sauceRest;
    private String build = new SimpleDateFormat("HHmmss").format(new Date());
    private String jobId;

    @Autowired
    public void setContext(SeleniumContext context) {
        TestListeners.context = context;
    }


    @Autowired
    public void setSauceRest(SauceREST sauceRest) {
        TestListeners.sauceRest = sauceRest;
    }

    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult result) {
        jobId = ((RemoteWebDriver) context.getDriver()).getSessionId()
                .toString();
        Map<String, Object> updates = new HashMap<>();
        updates.put("passed", "false");
        sauceRest.updateJobInfo(jobId, updates);
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Map<String, Object> updates = new HashMap<>();
        updates.put("passed", "true");
        sauceRest.updateJobInfo(jobId, updates);
    }

    @Override
    public void onTestStart(ITestResult result) {
        MDC.put("testName", result.getName());
        Map<String, Object> updates = new HashMap<>();
        jobId = ((RemoteWebDriver) context.getDriver()).getSessionId()
                .toString();
        System.out.println(String.format("SauceOnDemandSessionID=%1$s " +
                "job-name=%2$s", jobId, result.getName()));
        Reporter.log(String.format("SauceOnDemandSessionID=%1$s " +
                "job-name=%2$s", jobId, result.getName()));
        updates.put("name", result.getName());
        updates.put("build", build);
        sauceRest.updateJobInfo(jobId, updates);

    }
}
