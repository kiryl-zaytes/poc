package uk.ee.framework.elements.sections.shop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;
import uk.ee.framework.business_objects.dao.customer.Customer;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by Syamphaneendra Kalluri on 07/11/2016
 * Modified by prabhu_s on 07/13/16.
 * This class represents the selenium version of the Upgrade Billing Address
 * section.
 * 
 */
public class UpgradeBillingAddress extends CustomHtmlElement {

	@FindBy(xpath = "//input[@name='billingPostCode']")
	TextInput billingPostCode;
	@FindBy(xpath = "(//span[text()='Find'])[1]")
	WebElement findAddress;
	@FindBy(xpath = "//select[option[@value='Choose address']]")
	Select addressList;
	@FindBy(xpath = "//*[@id='billingPostCodeInput']/span[2]")
	WebElement billingPostCodeErrorMsg1;
	@FindBy(css = "span.ee-form-message.postcode-not-exists.ee-form-message--active")
	WebElement billingPostCodeErrorMsg2;
	@FindBy(xpath = "(//input[@name='billingBuildingNumber'])[2]")
	TextInput billingBuildingNumber;
	@FindBy(xpath = "(//input[@name='billingAddress'])[2]")
	TextInput address1;
	@FindBy(xpath = "(//input[@name='billingTown'])[2]")
	TextInput billingTown;
	@FindBy(xpath = "(//input[@name='billingPostcodeField'])[2]")
	TextInput billingPostcodeField;

	/**
	 * @param customerObj
	 */
	public void fillBillingAddressDetails(final Customer customerObj) {
		billingPostCode.sendKeys(customerObj.getPostcode());
		findAddress.click();
		if (billingPostCodeErrorMsg1.isDisplayed()) {
			billingPostCode.sendKeys("LS116EE");
		}
		if (billingBuildingNumber.isDisplayed()) {
			billingBuildingNumber.sendKeys(customerObj.getBuilding());
			address1.sendKeys(customerObj.getAddress1());
			billingTown.sendKeys(customerObj.getTownName());
			billingPostcodeField.sendKeys(customerObj.getPostCodeCurrentAddress());
		} else {
			addressList.selectByIndex(2);
		}
	}
}
