package com.nbc.testautomation.webdriver;

import org.openqa.selenium.WebDriver;

import java.net.URL;

/**
 * Wrapper for {@link org.openqa.selenium.WebDriver.Navigation}
 * <p>
 * Goal of this wrapper it to provide easy way of extending base functionality and add custom functions in case of necessity
 *
 * @see org.openqa.selenium.WebDriver.Navigation
 */
public class ExtendedNavigation implements WebDriver.Navigation {

    protected WebDriver.Navigation navigation = null;

    public ExtendedNavigation(WebDriver.Navigation navigation) {
        this.navigation = navigation;
    }

    public void back() {
        this.navigation.back();
    }

    public void forward() {
        this.navigation.forward();
    }

    public void to(String url) {
        this.navigation.to(url);
    }

    public void to(URL url) {
        this.navigation.to(url);
    }

    public void refresh() {
        this.navigation.refresh();
    }
}
