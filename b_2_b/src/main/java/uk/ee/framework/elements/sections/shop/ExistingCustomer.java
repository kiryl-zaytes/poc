package uk.ee.framework.elements.sections.shop;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.TextInput;
import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.common.Radio;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by Syamphaneendra Kalluri on 06/16/2016
 *
 * This class represents the selenium version of the Existing Customer section.
 *
 * <p>
 * This class represents the selenium version of the Existing CustomerType
 * section.
 */
public class ExistingCustomer extends CustomHtmlElement {

	@FindBy(xpath = "//label[@for='No']")
	WebElement newCustomer;

	@FindBy(xpath = "//label[@for='Yes']")
	WebElement existingCustomer;

	@FindBy(id = "globalMessages")
	WebElement globalInfoMessage;

	@FindBy(css = "input.checkout-cta")
	Button nextStep;

	@FindBy(css = "input#inputCtn")
	TextInput inputCtn;

	/**
	 * @param customerType
	 */
	public void checkExistingCustomer(final String customerType) {

		if ("false".equalsIgnoreCase(customerType)) {
			newCustomer.click();
		} else {
			existingCustomer.click();
			inputCtn.sendKeys("07996016997");
		}
		nextStep.click();
	}

	public ExistingCustomer checkGlobalMsgAndContinue() {
		try {
			if (globalInfoMessage.isDisplayed()) {
				nextStep.click();
			}
		} catch (NoSuchElementException e) {
			return null;
		}
		return this;
	}
}
