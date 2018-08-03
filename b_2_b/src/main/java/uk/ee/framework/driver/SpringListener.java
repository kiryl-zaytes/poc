package uk.ee.framework.driver;

import org.openqa.selenium.WebDriver;
import org.springframework.context.support.SimpleThreadScope;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

/**
 * Created by kiryl_zayets on 5/2/16.
 */
public class SpringListener extends AbstractTestExecutionListener {

    @Override
    public void beforeTestClass(TestContext testContext) {
        testContext.getApplicationContext().getBean
                (SimpleThreadScope.class).remove("localExtendedWebDriver");
        testContext.getApplicationContext().getBean
                (SimpleThreadScope.class).remove("perfectosExtendedWebDriver");
        testContext.getApplicationContext().getBean
                (SimpleThreadScope.class).remove("mobileExtendedWebDriver");
    }

    @Override
    public void afterTestClass(TestContext testContext) {
//        testContext.getApplicationContext().getBean(WebDriver.class).close();
        testContext.getApplicationContext().getBean(WebDriver.class).quit();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
