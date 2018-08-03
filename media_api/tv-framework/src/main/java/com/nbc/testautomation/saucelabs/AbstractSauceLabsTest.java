package com.nbc.testautomation.saucelabs;

import com.saucelabs.saucerest.SauceREST;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Inherit this class and add {@link SauceLabsTestListener} for adding support of SauceLabs in tests
 */
public abstract class AbstractSauceLabsTest extends AbstractTestNGSpringContextTests implements SauceLabsRestAware {

    @Autowired(required = false)
    protected SauceREST sauceREST;

    public String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }

    public SauceREST getSauceREST() {
        return sauceREST;
    }

    public abstract WebDriver getWebDriver();
}
