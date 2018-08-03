package uk.ee.framework.elements.sections.shop;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.TextInput;
import uk.ee.framework.business_objects.dao.customer.Customer;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by Syamphaneendra Kalluri on 07/11/2016
 * 
 * This class represents the selenium version of the Upgrade Contact Details
 * section.
 * 
 */
public class UpgradeContactDetails extends CustomHtmlElement {

	@FindBy(css = "input#firstName")
	TextInput firstName;

	@FindBy(css = "input#lastName")
	TextInput lastName;

	@FindBy(css = "input#Email")
	TextInput email;

	@FindBy(css = "input#phoneNumber")
	TextInput phoneNumber;

	/**
	 * @param customerObj
	 */
	public void fillContactDetails(final Customer customerObj) {
		firstName.sendKeys(customerObj.getFirstName());
		lastName.sendKeys(customerObj.getLastName());
		email.sendKeys(customerObj.getEmail());
		phoneNumber.sendKeys(customerObj.getContactNumber());
	}
}
