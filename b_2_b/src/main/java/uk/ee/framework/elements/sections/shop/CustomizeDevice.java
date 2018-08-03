package uk.ee.framework.elements.sections.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.Select;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;
import uk.ee.framework.utils.Waiter;

import java.util.List;
import java.util.Random;

/**
 * Created by kiryl_zayets on 5/20/16.
 */

@Timeout(15)
public class CustomizeDevice extends CustomHtmlElement {

    @FindBy(css = "select#Size")
    Select capacity;

    @FindBy(css = ".ee-product-colours-list")
    WebElement colors;

    @FindBy(id = "upgrade-plan-link")
    Link upgrade;

    @FindBy(css = "#CQ5Content_LinkToSB_DeviceDetailsTop+div a")
    Link goToBusinessShop;

    public CustomizeDevice selectCapacity(String capacity){
        this.capacity.selectByVisibleText(capacity);
        waiter.waitForLoad();
        return this;
    }

    public CustomizeDevice getRandlomColor(){
        List<WebElement> colorsElements = waiter.waitForLoad().elementVisible(colors).findElements(By
                .cssSelector("li a"));
        Random random = new Random();
        colorsElements.get(random.nextInt(colorsElements.size())).click();
        waiter.waitForLoad();
        return this;
    }

    public CustomizeDevice goUpgrade(){
        upgrade.click();
        return this;
    }

    public CustomizeDevice goBusinessShop(){
        goToBusinessShop.click();
        return this;
    }

}
