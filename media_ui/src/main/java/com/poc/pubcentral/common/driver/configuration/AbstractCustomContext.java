package com.poc.pubcentral.common.driver.configuration;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

/**
 * Created by kiryl_zayets on 6/28/15.
 */
@ContextConfiguration(locations = {"classpath:config/global.xml"})
public class AbstractCustomContext extends AbstractTestNGSpringContextTests {

    @BeforeSuite(alwaysRun = true)
    public void getXMLParams(ITestContext iTestContext) {
        iTestContext.getSuite().getXmlSuite().setParallel(System.getProperty
                ("parallel"));
        iTestContext.getSuite().getXmlSuite().setThreadCount(Integer.valueOf
                (System.getProperty("threadCount")));
    }
}
