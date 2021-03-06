package uk.ee.framework.elements.webdriver_aware;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.pagefactory.CustomElementLocatorFactory;
import uk.ee.framework.utils.Waiter;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by kiryl_zayets on 5/2/16.
 */
public class WebDriverAwareDecorator extends HtmlElementDecorator {
    private WebDriver driver;
    private Waiter waiter;

    public WebDriverAwareDecorator(CustomElementLocatorFactory factory, WebDriver driver) {
        super(factory);

        this.driver = driver;
        this.waiter = new Waiter(driver);
    }

    @Override
    protected <T extends HtmlElement> T decorateHtmlElement(ClassLoader loader, Field field) {
        T element = super.decorateHtmlElement(loader, field);

        if (element instanceof WebDriverAware) {
            ((WebDriverAware)element).setWebDriver(driver);
            ((WebDriverAware)element).setWaiter(waiter);
        }

        return element;
    }

    @Override
    protected <T extends HtmlElement> List<T> decorateHtmlElementList(ClassLoader loader, Field field) {
        List<T> elements = super.decorateHtmlElementList(loader, field);

        if (!elements.isEmpty() && elements.get(0) instanceof WebDriverAware) {
            for (T element : elements) {
                ((WebDriverAware)element).setWebDriver(driver);
                ((WebDriverAware)element).setWaiter(waiter);
            }
        }

        return elements;
    }
}
