package uk.ee.framework.driver;


import org.openqa.selenium.WebDriver;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TestListeners implements ITestListener {

    private String build = new SimpleDateFormat("HHmmss").format(new Date());
    private String jobId;
    private static WebDriver webDriver;

    @Autowired
    public void setWebDriver(WebDriver webDriver) {
        TestListeners.webDriver = webDriver;
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

    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestStart(ITestResult result) {
        MDC.put("testName", result.getInstanceName());
    }
}
