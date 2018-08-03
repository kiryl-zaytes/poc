package uk.ee.framework.driver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.config.AbstractFactoryBean;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by kiryl_zayets on 4/28/16.
 */
public class WebDriverFactoryBean extends AbstractFactoryBean<WebDriver> {

    protected DesiredCapabilities desiredCapabilities;

    public DesiredCapabilities getDesiredCapabilities() {
        return desiredCapabilities;
    }

    public void setDesiredCapabilities(DesiredCapabilities
            desiredCapabilities) {
        this.desiredCapabilities = desiredCapabilities;
    }

    @Override
    public Class<?> getObjectType() {
        return WebDriver.class;
    }

    @Override
    protected WebDriver createInstance() throws Exception {
        WebDriver webDriver;
        String url = (String) desiredCapabilities.getCapability("url");

        if (desiredCapabilities.getBrowserName().toLowerCase().equals("firefox")){
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            firefoxProfile.setPreference("permissions.default.image", 2);
            firefoxProfile.setPreference("dom.ipc.plugins.enabled.libflashplayer.so", true);
            firefoxProfile.setPreference("browser.cache.disk.enable", true);
            firefoxProfile.setPreference("browser.cache.offline.enable", true);
            firefoxProfile.setPreference("network.http.use-cache", true);
            desiredCapabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
        }
        webDriver = new RemoteWebDriver(new URL(url), desiredCapabilities);      
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return webDriver;
}
}
