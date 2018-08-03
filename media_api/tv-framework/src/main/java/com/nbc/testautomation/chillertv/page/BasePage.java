package com.nbc.testautomation.chillertv.page;

import com.nbc.testautomation.chillertv.support.configuration.EnvironmentConfiguration;
import com.nbc.testautomation.webdriver.ExtendedWebDriver;
import com.nbc.testautomation.webdriver.decorator.ExtendedHtmlElementDecorator;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Base page class which should be inherited by all page classes. It contains web driver instance which is accessible
 * for all descendants and method for initialization of web element fields
 */
public class BasePage {

    @Autowired
    protected ExtendedWebDriver extendedWebDriver;

    @Autowired
    protected EnvironmentConfiguration environmentConfiguration;

    @PostConstruct
    public void initElements() {
        PageFactory.initElements(new ExtendedHtmlElementDecorator(extendedWebDriver), this);
    }
}
