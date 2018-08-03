package uk.ee.framework.elements.sections.shop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;
import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.common.Link;
import uk.ee.framework.elements.common.TextBlock;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by Syamphaneendra Kalluri on 06/06/2016
 * 
 * This class represents the selenium version of the Home Address section.
 * 
 */
public class HomeAddress extends CustomHtmlElement {

	@FindBy(id = "lookup_postcode_deliveryAddress")
	TextInput deliveryAddressPostCode;

	@FindBy(css = "a#link_lookup_postcode_deliveryAddress")
	Link findAddress;

	@FindBy(id = "addressList_deliveryAddress_select")
	Select addressList;

	@FindBy(css = "input#goToCheckout")
	Button goToCheckout;

	@FindBy(css = "span.ee-form-message.ee-form-message--active")
	TextBlock errorMsg;
	
	@FindBy(xpath = "//*[@id='buildingNumber_deliveryAddress']")
	TextInput houseNumber;

	@FindBy(css = "input#street1_deliveryAddress")
	TextInput address1;

	@FindBy(css = "input#town_deliveryAddress")
	TextInput townName;

	@FindBy(css = "input#county_deliveryAddress")
	TextInput country;

	/**
	 * @param postCode
	 * @return
	 */
	public HomeAddress findHomeAddress(String postCode) {
		try {
			deliveryAddressPostCode.sendKeys(postCode);
			findAddress.click();			
			System.out.println("errorMsg.isDisplayed()" + errorMsg.isDisplayed());
			webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("houseNumber.isDisplayed()" + houseNumber.isDisplayed());
			if (houseNumber.isDisplayed()) {
				System.out.println("entered to if block");
				houseNumber.sendKeys("2");
				address1.sendKeys("Marsh Layne");
				townName.sendKeys("Leeds");
				country.sendKeys("UK");
				proceedToCheckout();
				return this;
			} else {
				selectAddress();
				proceedToCheckout();
				return this;
			}

		} catch (NoSuchElementException e) {
			selectAddress();
			proceedToCheckout();
			return this;
		}
	}

	/**
	 * 
	 */
	public void selectAddress() {
		addressList.selectByIndex(2);
	}

	/**
	 * @return
	 */
	public HomeAddress proceedToCheckout() {
		goToCheckout.click();
		return this;
	}

}
