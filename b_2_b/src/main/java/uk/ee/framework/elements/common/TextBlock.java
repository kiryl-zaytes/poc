package uk.ee.framework.elements.common;

import org.openqa.selenium.WebElement;

/**
 * Wrapper for {@link ru.yandex.qatools.htmlelements.element.TextBlock}
 * <p>
 * Goal of this wrapper it to provide easy way of extending base functionality and add custom functions in case of necessity
 * <p>
 * l@see ru.yandex.qatools.htmlelements.element.TextBlock
 */
public class TextBlock extends ru.yandex.qatools.htmlelements.element.TextBlock {

    public TextBlock(WebElement wrappedElement) {
        super(wrappedElement);
    }
}
