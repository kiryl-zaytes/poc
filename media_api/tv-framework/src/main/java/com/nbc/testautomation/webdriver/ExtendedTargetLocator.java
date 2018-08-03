package com.nbc.testautomation.webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Wrapper for {@link org.openqa.selenium.WebDriver.TargetLocator}
 * <p>
 * Goal of this wrapper it to provide easy way of extending base functionality and add custom functions in case of necessity
 *
 * @see org.openqa.selenium.WebDriver.TargetLocator
 */
public class ExtendedTargetLocator implements WebDriver.TargetLocator {

    protected WebDriver.TargetLocator targetLocator = null;

    public ExtendedTargetLocator(WebDriver.TargetLocator targetLocator) {
        this.targetLocator = targetLocator;
    }

    public WebDriver frame(int index) {
        return this.targetLocator.frame(index);
    }

    public WebDriver frame(String nameOrId) {
        return this.targetLocator.frame(nameOrId);
    }

    public WebDriver frame(WebElement frameElement) {
        return this.targetLocator.frame(frameElement);
    }

    public WebDriver parentFrame() {
        return this.targetLocator.parentFrame();
    }

    public WebDriver window(String nameOrHandle) {
        return this.targetLocator.window(nameOrHandle);
    }

    public WebDriver defaultContent() {
        return this.targetLocator.defaultContent();
    }

    public WebElement activeElement() {
        return this.targetLocator.activeElement();
    }

    public Alert alert() {
        return this.targetLocator.alert();
    }
}
