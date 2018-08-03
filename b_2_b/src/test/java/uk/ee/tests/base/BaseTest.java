package uk.ee.tests.base;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;
import uk.ee.framework.driver.SpringListener;

/**
 * Created by kiryl_zayets on 4/28/16.
 */
@ContextConfiguration(locations = {"classpath:configuration/driver.xml"})
@TestExecutionListeners(SpringListener.class)
public class BaseTest extends AbstractTestNGSpringContextTests {

    @BeforeSuite(alwaysRun = true)
    public void getXMLParams(ITestContext iTestContext) {
        iTestContext.getSuite().getXmlSuite().setParallel(XmlSuite
                .ParallelMode.CLASSES);
        iTestContext.getSuite().getXmlSuite().setThreadCount(Integer.valueOf
                (System.getProperty("threads")));
    }

}
