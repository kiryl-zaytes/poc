package uk.ee.framework.elements.common;

import org.openqa.selenium.WebElement;

/**
 * Wrapper for {@link ru.yandex.qatools.htmlelements.element.Radio}
 * <p>
 * Goal of this wrapper it to provide easy way of extending base functionality and add custom functions in case of necessity
 *
 * @see ru.yandex.qatools.htmlelements.element.Radio
 */
public class Radio extends ru.yandex.qatools.htmlelements.element.Radio {

    public Radio(WebElement wrappedElement) {
        super(wrappedElement);
    }
}
