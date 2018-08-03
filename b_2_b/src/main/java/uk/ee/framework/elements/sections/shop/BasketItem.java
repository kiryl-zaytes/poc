package uk.ee.framework.elements.sections.shop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kiryl_zayets on 5/23/16.
 */

@FindBy(css = "div.basket-items")
@Timeout(8)
public class BasketItem extends CustomHtmlElement {

    @FindBy(xpath = "//section//p[text()='1']")
    BundlePackage bundlePackage1;

    @FindBy(xpath = "//section//p[text()='2']")
    BundlePackage bundlePackage2;

    @FindBy(xpath = "//section//p[text()='3']")
    BundlePackage bundlePackage3;

    @FindBy(css = "section#addons_1_")
    Extras extras1;

    @FindBy(css = "section#addons_2_")
    Extras extras2;

    @FindBy(css = "section#addons_3_")
    Extras extras3;


    public BasketItem addExtras1(List<String> extras) {
        extras1.chooseExtras(extras, webDriver);
        return this;
    }

    public BasketItem addExtras2(List<String> extras) {
        extras2.chooseExtras(extras, webDriver);
        return this;
    }

    public BasketItem addExtras3(List<String> extras) {
        extras3.chooseExtras(extras, webDriver);
        return this;
    }

    public void addExtras(List<String> extras, int basketItem) {
        ArrayList<Extras> extraList = new ArrayList<>(Arrays.asList
                (extras1, extras2, extras3));
        extraList.get(basketItem).chooseExtras(extras, webDriver);
    }
}
