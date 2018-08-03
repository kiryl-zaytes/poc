package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.common.TextBlock;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;
import uk.ee.framework.utils.Waiter;

import java.util.List;
import java.util.Random;

public class PayGAddOnsTab extends CustomHtmlElement {

    @FindBy(xpath = "//a[contains(text(),'Remove add-on')]")
    Button removeAddOn;

    @FindBy(xpath = "//*[contains(text(),'CONFIRM')]")
    Button confirmRemove;

    @FindBy(xpath = "//button[contains(text(),'Learn more')]")
    List<WebElement> learnMore;

    @FindBy(css = "button#confirmSelectPack")
    List<WebElement> buyNow;

    @FindBy(css = "dt.expandable__panel-header.h4")
    List<WebElement> addonGroup;

    
    public void selectRemoveAddon() {
        removeAddOn.click();
        confirmRemove.click();
    }

    public void selectBuyAddon() {
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(addonGroup.size());
        addonGroup.get(2).click();
        loop(learnMore);
        loop(buyNow);
    }

	public void loop(List<WebElement> ele) {
		int n = ele.size();
		for (int i = 0; i < n; i++) {
			if (ele.get(i).isDisplayed()) {
				ele.get(i).click();
				break;
			}
		}
	}

}
