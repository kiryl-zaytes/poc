package uk.ee.framework.elements.common;

import org.openqa.selenium.WebElement;

/**
 * Wrapper for {@link ru.yandex.qatools.htmlelements.element.Button}
 * <p>
 * Goal of this wrapper it to provide easy way of extending base functionality and add custom functions in case of necessity
 *
 * @see ru.yandex.qatools.htmlelements.element.Button
 */
public class Button extends ru.yandex.qatools.htmlelements.element.Button {

    public Button(WebElement wrappedElement) {
        super(wrappedElement);
    }
}
