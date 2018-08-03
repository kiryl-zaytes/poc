package uk.ee.framework.elements.sections.shop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by Syamphaneendra Kalluri on 07/11/2016
 * 
 * This class represents the selenium version of the Upgrad eDelivery Options
 * section.
 * 
 */
public class UpgradeDeliveryOptions extends CustomHtmlElement {

	@FindBy(xpath = "//label[@for='fed1']")
	WebElement delToMyBillingAdd;

	@FindBy(xpath = "//label[@for='fed2']")
	WebElement delToDiffHomeAdd;

	@FindBy(xpath = "//label[@for='fed3']")
	WebElement delToEEStoreAdd;

}
