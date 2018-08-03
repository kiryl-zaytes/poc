package uk.ee.framework.pages.shop;

import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import uk.ee.framework.elements.common.Radio;
import uk.ee.framework.elements.sections.shop.HomeAddress;
import uk.ee.framework.pages.BasePage;

/**
 * Created by Syamphaneendra Kalluri on 06/06/2016
 * 
 * This class represents the selenium version of the choose delivery option
 * screen.
 * 
 */
@Component
@Scope("prototype")
public class ChooseDelivery extends BasePage {

	/**
	 * deliverToHome radio button indicates the selected address is Home.
	 * 
	 */
	@FindBy(css = "input#deliverToHome")
	Radio deliverToHome;

	/**
	 * deliverToStore radio button indicates the selected address is store.
	 * 
	 */
	@FindBy(css = "input#deliverToStore")
	Radio deliverToStore;

	@FindBy(id = "customer-delivery")
	HomeAddress homeAddress;

	/**
	 * This method is used to choose the correct address based on input
	 * parameters.
	 * 
	 * @param deliveryAddress
	 * @param postCode
	 */
	public void selectAddress(final String deliveryAddress, final String postCode) {
		if (null != deliveryAddress && "deliverToHome".equalsIgnoreCase(deliveryAddress)) {
			deliverToHome.selectByValue("false");
			homeAddress.findHomeAddress(postCode);
		} else {
			deliverToStore.selectByValue("true");
		}
	}
}
