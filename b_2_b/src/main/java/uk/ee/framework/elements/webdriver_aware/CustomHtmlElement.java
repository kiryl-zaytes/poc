package uk.ee.framework.elements.webdriver_aware;

import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import uk.ee.framework.utils.Waiter;

/**
 * Created by kiryl_zayets on 5/2/16.
 */
public class CustomHtmlElement extends HtmlElement implements WebDriverAware {
    protected WebDriver webDriver;
    protected Waiter waiter;

    @Override
    public void setWebDriver(WebDriver driver) {
        this.webDriver = driver;
    }

    @Override
    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }
}
