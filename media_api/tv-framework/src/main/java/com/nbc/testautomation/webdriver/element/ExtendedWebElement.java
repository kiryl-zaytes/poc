package com.nbc.testautomation.webdriver.element;

import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

/**
 * Common representation of any web element, which type is not obvious. It can be extended with any custom functionality.
 */
public class ExtendedWebElement extends TypifiedElement {

    public ExtendedWebElement(WebElement wrappedElement) {
        super(wrappedElement);
    }
}
