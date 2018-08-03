package com.poc.pubcentral.common.driver.configuration;


import com.poc.pubcentral.common.driver.annotations.CustomCapabilities;
import com.nbcuni.test.webdriver.CustomWebDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/**
 * Created by kiryl_zayets on 6/29/15.
 */

@Configuration
public class SeleniumContext {

    @Autowired
    Environment environment;

    @Autowired
    @Value("${sauce.hub}")
    URL sauceHub;

    @CustomCapabilities
    Capabilities capabilities;

    @Value("${wait.element}")
    int waitElementTimeout;

    @Value("${wait.page}")
    int waitPageTimeout;


    @Bean
    public DesiredCapabilities capabilities() {
        return new DesiredCapabilities();
    }

    @Bean(name = "firefox")
    public Capabilities firefox() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("browserName", "firefox");
        return desiredCapabilities;
    }

    @Bean(name = "chrome")
    public Capabilities chrome() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("browserName", "chrome");
        return desiredCapabilities;
    }

    public WebDriver getDriver() {
//        String profile = environment.getActiveProfiles()[0];
        return this.webDriver();
    }

    @Bean
    @Scope("thread")
    public WebDriver webDriver() {
        CustomWebDriver webDriver = new CustomWebDriver(sauceHub, capabilities);
        webDriver.setLogLevel(Level.FINER);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(waitPageTimeout,
                TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(waitElementTimeout,
                TimeUnit.SECONDS);
        return webDriver;
    }

//    @Bean
//    @Profile("custom")
//    @Scope("thread")
//    public WebDriver getCustomDriver() {
//        CustomWebDriver webDriver = new CustomWebDriver(customHub,
// capabilities);
//        webDriver.setLogLevel(Level.FINER);
//        webDriver.manage().window().maximize();
//        webDriver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
//        webDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//        return webDriver;
//    }
}
