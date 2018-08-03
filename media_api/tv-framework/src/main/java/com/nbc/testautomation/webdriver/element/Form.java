package com.nbc.testautomation.webdriver.element;

import org.openqa.selenium.WebElement;

/**
 * Wrapper for {@link ru.yandex.qatools.htmlelements.element.Form}
 * <p>
 * Goal of this wrapper it to provide easy way of extending base functionality and add custom functions in case of necessity
 *
 * @see ru.yandex.qatools.htmlelements.element.Form
 */
public class Form extends ru.yandex.qatools.htmlelements.element.Form {

    public Form(WebElement wrappedElement) {
        super(wrappedElement);
    }
}
