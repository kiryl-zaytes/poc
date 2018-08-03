package com.nbc.testautomation.webdriver.decorator;

import org.openqa.selenium.SearchContext;
import ru.yandex.qatools.htmlelements.pagefactory.CustomElementLocatorFactory;

/**
 * Wrapper for {@link ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator}
 *
 * @see ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator
 */
public class ExtendedHtmlElementDecorator extends ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator {

    public ExtendedHtmlElementDecorator(CustomElementLocatorFactory locatorFactory) {
        super(locatorFactory);
    }

    public ExtendedHtmlElementDecorator(SearchContext searchContext) {
        super(searchContext);
    }
}
