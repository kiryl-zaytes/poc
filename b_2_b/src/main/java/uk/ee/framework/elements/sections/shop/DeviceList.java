package uk.ee.framework.elements.sections.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uk.ee.framework.business_objects.dao.order_management.constant.SHOP_OPTIONS;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by Syamphaneendra Kalluri on 06/16/2016
 * 
 * This class represents the selenium version of theDevice List section.
 * 
 */
@FindBy(id = "show")
public class DeviceList extends CustomHtmlElement {

	By caption = By.cssSelector("li.tile");
	String directLinkPattern = "li.tile a[href*='%s']";

	@FindBy(xpath = "//label[@for='topValuepay-monthly1']")
	WebElement paymPhoneRadioBtn;

	@FindBy(xpath = "//label[@for='topValuepay-as-you-go3']")
	WebElement paygPhoneRadioBtn;

	@FindBy(xpath = "//label[@for='topValuepay-monthly-tablets1']")
	WebElement paymTabletRadioBtn;

	@FindBy(xpath = "//label[@for='topValuepay-as-you-go-tablets3']")
	WebElement paygTabletRadioBtn;

	/**
	 * @return
	 */
	public int getDevicesCount() {
		return this.getWrappedElement().findElements(caption).size();
	}

	/**
	 * @param name
	 */
	public void selectDevice(String name) {
		this.getWrappedElement().findElement(By.cssSelector(String.format(directLinkPattern, name))).click();
	}

	/**
	 * @param payType
	 * @param deviceType
	 */
	public void selectPayType(final String payType, final SHOP_OPTIONS deviceType) {
		switch (deviceType) {
		case PHONE:
			if ("PAYM".equalsIgnoreCase(payType)) {
				paymPhoneRadioBtn.click();
			} else {
				paygPhoneRadioBtn.click();
			}
			break;
		case TABLET:
			if ("PAYM".equalsIgnoreCase(payType)) {
				paymTabletRadioBtn.click();
			} else {
				paygTabletRadioBtn.click();
			}
			break;
		default:
			if ("PAYM".equalsIgnoreCase(payType)) {
				paymPhoneRadioBtn.click();
			} else {
				paygPhoneRadioBtn.click();
			}
		}
	}

}
