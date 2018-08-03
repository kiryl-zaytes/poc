package com.nbc.testautomation.webdriver.factory;

import com.nbc.testautomation.webdriver.ExtendedWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.config.AbstractFactoryBean;

import java.net.URL;

/**
 * Factory Bean for {@link ExtendedWebDriver} which encapsulates its custom construction logic
 */
public class ExtendedWebDriverFactoryBean extends AbstractFactoryBean<ExtendedWebDriver> {

    protected DesiredCapabilities desiredCapabilities;

    public DesiredCapabilities getDesiredCapabilities() {
        return desiredCapabilities;
    }

    public void setDesiredCapabilities(DesiredCapabilities desiredCapabilities) {
        this.desiredCapabilities = desiredCapabilities;
    }

    @Override
    public Class<?> getObjectType() {
        return ExtendedWebDriver.class;
    }

    @Override
    protected ExtendedWebDriver createInstance() throws Exception {
        WebDriver webDriver = null;

        if (desiredCapabilities.getCapability("saucelabs.username") != null) {
            String saucelabsUsername = desiredCapabilities.getCapability("saucelabs.username").toString();
            String saucelabsAccessKey = desiredCapabilities.getCapability("saucelabs.access_key").toString();

            String URL = "http://" + saucelabsUsername + ":" + saucelabsAccessKey + "@ondemand.saucelabs.com:80/wd/hub";

            webDriver = new RemoteWebDriver(new URL(URL), desiredCapabilities);
        } else {
            webDriver = new RemoteWebDriver(desiredCapabilities);
        }

        return new ExtendedWebDriver(webDriver);
    }
}
