package com.nbc.testautomation.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

import java.util.List;
import java.util.Set;

/**
 * Custom implementation of {@link org.openqa.selenium.WebDriver}
 * <p>
 * Goal of this implementation it to provide easy way of extending base functionality and add custom functions in case of necessity
 *
 * @see org.openqa.selenium.WebDriver
 */
public class ExtendedWebDriver implements WebDriver, WrapsDriver {

    protected WebDriver webDriver;

    protected ExtendedOptions options = null;

    protected ExtendedNavigation navigation = null;

    protected ExtendedTargetLocator targetLocator = null;

    public ExtendedWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.options = new ExtendedOptions(webDriver.manage());
        this.navigation = new ExtendedNavigation(webDriver.navigate());
        this.targetLocator = new ExtendedTargetLocator(webDriver.switchTo());
    }

    public void get(String url) {
        getWrappedDriver().get(url);
    }

    public String getCurrentUrl() {
        return getWrappedDriver().getCurrentUrl();
    }

    public String getTitle() {
        return getWrappedDriver().getTitle();
    }

    public List<WebElement> findElements(By by) {
        return getWrappedDriver().findElements(by);
    }

    public WebElement findElement(By by) {
        return getWrappedDriver().findElement(by);
    }

    public String getPageSource() {
        return getWrappedDriver().getPageSource();
    }

    public void close() {
        getWrappedDriver().close();
    }

    public void quit() {
        getWrappedDriver().quit();
    }

    public Set<String> getWindowHandles() {
        return getWrappedDriver().getWindowHandles();
    }

    public String getWindowHandle() {
        return getWrappedDriver().getWindowHandle();
    }

    public TargetLocator switchTo() {
        return this.targetLocator;
    }

    public Navigation navigate() {
        return this.navigation;
    }

    public Options manage() {
        return this.options;
    }

    public WebDriver getWrappedDriver() {
        return webDriver;
    }
}
