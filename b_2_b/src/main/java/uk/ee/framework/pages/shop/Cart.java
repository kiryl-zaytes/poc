package uk.ee.framework.pages.shop;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.yandex.qatools.htmlelements.element.Link;
import uk.ee.framework.elements.sections.shop.BasketItem;
import uk.ee.framework.elements.sections.shop.SBCartOverlay;
import uk.ee.framework.elements.sections.shop.SBSecureCheckoutPopUp;
import uk.ee.framework.pages.BasePage;

/**
 * Created by kiryl_zayets on 06/23/16.
 * 
 * Modified by Syamphaneendra Kalluri on 06/15/16.
 */
@Component
@Scope("prototype")
public class Cart extends BasePage {

	BasketItem basketItem;

	/**
	 * For MBB choose delivery option
	 */
	@FindBy(xpath = "//*[@id='basket-page']/section[1]/div/div/div/a")
	Link chooseDeliveryOptions;

	@FindBy(css = "a.cart-bundle-editable")
	Link changePlan;

	/**
	 * For SIMO Secure checkout
	 */
	@FindBy(xpath = "//*[@id='basket-page']/section[1]/div/div/div/a")
	Link secureCheckout;

	@FindBy(css="div.modal-content")
	SBCartOverlay overlay;
	
	@FindBy(xpath="(//*[@id='business_type_modal'])[2]")
	SBSecureCheckoutPopUp sbPopUp;
	
	public void goToDeviceGallery() {
		changePlan.click();
	}

	public Cart goToDeliveryOptions() {
		waiter.elementVisible(chooseDeliveryOptions.getWrappedElement()).click();
		return this;
	}
	
	public Cart goToSBDeliveryOptions() {
		waiter.elementVisible(chooseDeliveryOptions.getWrappedElement()).click();
		waiter.elementVisible(overlay);
		waiter.switchToActive(overlay);
		overlay.soleTraderClick();
		return this;
	}

	public Cart addExtras(List<String> extras) {
		basketItem.addExtras(extras, 0);
		return this;
	}

	public Cart addExtras(List<String> extras, int index) {
		basketItem.addExtras(extras, index);
		return this;
	}

	/**
	 * For SIMO Secure checkout
	 */
	public void goToSecureCheckout() {
		secureCheckout.click();
	}
	
	/**
	 * For SIMO Secure checkout
	 */
	public void goToSBSimSecureCheckout(final String typeOfBusiness) {
		secureCheckout.click();
		String myWindowHandle = browser.getWindowHandle();
		if (null != myWindowHandle) {
			browser.switchTo().window(myWindowHandle);
			if ("SoleTrader".equalsIgnoreCase(typeOfBusiness)) {
				sbPopUp.selectSoleTrader();
			} else {
				sbPopUp.selectLimittedpartner();
			}
		}
	}
}