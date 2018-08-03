package uk.ee.framework.elements.webdriver_aware;

import org.openqa.selenium.WebDriver;
import uk.ee.framework.utils.Waiter;

/**
 * Created by kiryl_zayets on 5/2/16.
 */
public interface WebDriverAware  {
    void setWebDriver(WebDriver driver);
    void setWaiter(Waiter driver);
}
