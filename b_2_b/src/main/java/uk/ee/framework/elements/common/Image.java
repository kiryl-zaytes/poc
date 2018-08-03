package uk.ee.framework.elements.common;

import org.openqa.selenium.WebElement;

/**
 * Wrapper for {@link ru.yandex.qatools.htmlelements.element.Image}
 * <p>
 * Goal of this wrapper it to provide easy way of extending base functionality and add custom functions in case of necessity
 *
 * @see ru.yandex.qatools.htmlelements.element.Image
 */
public class Image extends ru.yandex.qatools.htmlelements.element.Image {

    public Image(WebElement wrappedElement) {
        super(wrappedElement);
    }
}
