package com.nbc.testautomation.webdriver;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.Logs;

import java.util.Set;

/**
 * Wrapper for {@link org.openqa.selenium.WebDriver.Options}
 * <p>
 * Goal of this wrapper it to provide easy way of extending base functionality and add custom functions in case of necessity
 *
 * @see org.openqa.selenium.WebDriver.Options
 */
public class ExtendedOptions implements WebDriver.Options {

    protected WebDriver.Options options = null;

    public ExtendedOptions(WebDriver.Options options) {
        this.options = options;
    }

    public void addCookie(Cookie cookie) {
        this.options.addCookie(cookie);
    }

    public void deleteCookieNamed(String name) {
        this.options.deleteCookieNamed(name);
    }

    public void deleteCookie(Cookie cookie) {
        this.options.deleteCookie(cookie);
    }

    public void deleteAllCookies() {
        this.options.deleteAllCookies();
    }

    public Set<Cookie> getCookies() {
        return this.options.getCookies();
    }

    public Cookie getCookieNamed(String name) {
        return this.options.getCookieNamed(name);
    }

    public WebDriver.Timeouts timeouts() {
        return this.options.timeouts();
    }

    public WebDriver.ImeHandler ime() {
        return this.options.ime();
    }

    public WebDriver.Window window() {
        return this.options.window();
    }

    public Logs logs() {
        return this.options.logs();
    }
}
