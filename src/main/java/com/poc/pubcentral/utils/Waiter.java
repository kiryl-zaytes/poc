package com.poc.pubcentral.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;

/**
 * Created by kiryl_zayets on 10/14/15.
 */

public class Waiter {

    WebDriver webDriver;
    int waitElementTimeout;

    public Waiter(WebDriver webDriver, int waitTimeout) {
        this.webDriver = webDriver;
        this.waitElementTimeout = waitTimeout;
    }

    public WebElement elementIsPresent(WebElement webElement) {
        new WebDriverWait(webDriver, waitElementTimeout).
                ignoreAll(Arrays.asList(
                        NoSuchElementException.class,
                        StaleElementReferenceException.class,
                        ElementNotVisibleException.class)).
                until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }

    public Boolean isPresent(WebElement webElement) {
        try {
            new WebDriverWait(webDriver, waitElementTimeout).
                    ignoring(NoSuchElementException.class,
                            ElementNotVisibleException.class).
                    until(ExpectedConditions.visibilityOf(webElement));
        } catch (WebDriverException e) {
            return false;
        }

        return true;
    }

    public WebElement elementVisible(WebElement webElement) {
        new WebDriverWait(webDriver, waitElementTimeout).
                ignoring(NoSuchElementException.class,
                        ElementNotVisibleException.class).
                until(ExpectedConditions.visibilityOf(webElement));

        return webElement;
    }


}
