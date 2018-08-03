package uk.ee.framework.elements.sections.shop;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.TextInput;
import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by Syamphaneendra Kalluri on 06/06/2016
 * Modified by prabhu_S on 07/18/2016
 * This class represents the selenium version of the Billing Details section.
 * 
 */
public class BillingDetails extends CustomHtmlElement {

	@FindBy(id = "sortCode1")
	TextInput sortCode1;

	@FindBy(id = "sortCode2")
	TextInput sortCode2;

	@FindBy(id = "sortCode3")
	TextInput sortCode3;

	@FindBy(id = "accountNumber")
	TextInput accountNumber;

	@FindBy(id = "accountName")
	TextInput accountName;

	@FindBy(css="input#button_submit")
	Button nextStep;

	/**
	 * @param bdObj
	 */
	private void setBillingDetails(final uk.ee.framework.business_objects.dao.billing_details.BillingDetails bdObj) {
		sortCode1.sendKeys(bdObj.getSortCode1());
		sortCode2.sendKeys(bdObj.getSortCode2());
		sortCode3.sendKeys(bdObj.getSortCode3());
		accountNumber.sendKeys(bdObj.getAccountNumber());
		accountName.sendKeys(bdObj.getAccountName());
		nextStep.click();
	}

	/**
	 * @param bdObj
	 */
	public void proceedBillingDetails(final uk.ee.framework.business_objects.dao.billing_details.BillingDetails bdObj) {
		setBillingDetails(bdObj);
		nextStep.click();
		
	}

}
