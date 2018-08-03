package uk.ee.framework.pages.shop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import uk.ee.framework.business_objects.dao.order_management.constant.SHOP_OPTIONS;
import uk.ee.framework.elements.sections.shop.DeviceList;
import uk.ee.framework.pages.BasePage;

/**
 * Created by Syamphaneendra Kalluri on 06/03/2016
 * 
 * This class represents the selenium version of the MBBGallery screen.
 * 
 */
@Component
@Scope("prototype")
public class MBBGallery extends BasePage {

	/**
	 * DeviceList is the section of the MBB gallery page.
	 */
	DeviceList deviceList;

	@FindBy(xpath = "//label[@for='topValuepay-monthly-mobile-broadband1']")
	WebElement paymMBBRadiobtn;

	@FindBy(xpath = "//label[@for='topValuepay-as-you-go-mobile-broadband2']")
	WebElement paygMBBRadiobtn;

	/**
	 * This method is used to select Paym radio button.
	 */
	public void selectPaymPlan() {
		paymMBBRadiobtn.click();
	}

	/**
	 * This method is used to select Payg radio button.
	 */
	public void selectPaygPlan() {
		paygMBBRadiobtn.click();
	}

	/**
	 * @param name
	 */
	public void selectDevice(String name) {
		deviceList.selectDevice(name);
	}

	/**
	 * @param payType
	 * @param deviceType
	 */
	public void selectPayType(final String payType, final SHOP_OPTIONS deviceType) {
		deviceList.selectPayType(payType, deviceType);
	}

}
