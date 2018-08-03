package uk.ee.framework.elements.sections.shop;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.TextInput;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by Syamphaneendra Kalluri on 07/11/2016
 * Modified by prabhu_s on 07/13/16.
 * This class represents the selenium version of the Upgrade Direct Debit
 * Section
 * 
 */
public class UpgradeDirectDebit extends CustomHtmlElement {

	@FindBy(css="input.validation-required.value-required.sortcode")
	WebElement sortCode;

	@FindBy(xpath = "//input[@name='accountNumber']")
	TextInput accountNumber;

	@FindBy(xpath = "//input[@name='holderName']")
	TextInput holderName;

	private String sortCodeStr = "";

	/**
	 * @param bdObj
	 */
	public void fillDebitCardDetails(final uk.ee.framework.business_objects.dao.billing_details.BillingDetails bdObj) {
		sortCodeStr = bdObj.getSortCode1().trim() + bdObj.getSortCode2().trim() + bdObj.getSortCode3().trim();
		sortCode.click();
		sortCode.clear();
		sortCode.sendKeys(sortCodeStr);
		accountNumber.sendKeys(bdObj.getAccountNumber());
		holderName.sendKeys(bdObj.getAccountName());
	}
}
