package uk.ee.framework.elements.sections.shop;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Button;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by Syamphaneendra Kalluri on 07/05/2016
 * 
 * This class represents the selenium version of the SB Secure Checkout PopUp.
 * 
 */
public class SBSecureCheckoutPopUp extends CustomHtmlElement {

	@FindBy(xpath = "(//*[@id='business_type_modal']/div/section/p[2]/a[1])[2]")
	Button soleTraderBtn;

	@FindBy(xpath = "(//*[@id='business_type_modal']/div/section/p[2]/a[2])[2]")
	Button limittedPartner;

	/**
	 * 
	 */
	public void selectSoleTrader() {
		soleTraderBtn.click();
	}

	/**
	 * 
	 */
	public void selectLimittedpartner() {
		limittedPartner.click();
	}

}
