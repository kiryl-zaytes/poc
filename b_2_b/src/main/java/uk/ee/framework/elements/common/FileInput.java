package uk.ee.framework.elements.common;

import org.openqa.selenium.WebElement;

/**
 * Wrapper for {@link ru.yandex.qatools.htmlelements.element.FileInput}
 * <p>
 * Goal of this wrapper it to provide easy way of extending base functionality and add custom functions in case of necessity
 *
 * @see ru.yandex.qatools.htmlelements.element.FileInput
 */
public class FileInput extends ru.yandex.qatools.htmlelements.element.FileInput {

    public FileInput(WebElement wrappedElement) {
        super(wrappedElement);
    }
}
