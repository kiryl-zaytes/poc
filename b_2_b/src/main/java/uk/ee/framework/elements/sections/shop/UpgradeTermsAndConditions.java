package uk.ee.framework.elements.sections.shop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by Syamphaneendra Kalluri on 07/11/2016
 * 
 * This class represents the selenium version of the upgrade Terms And
 * Conditions section.
 * 
 */
public class UpgradeTermsAndConditions extends CustomHtmlElement {

	@FindBy(xpath = "//label[@for='iagree']")
	WebElement termsCheckBox;

	/**
	 * This method is used to agree the upgrade terms and conditions.
	 */
	public void agreeTerms() {
		termsCheckBox.click();
	}
}
