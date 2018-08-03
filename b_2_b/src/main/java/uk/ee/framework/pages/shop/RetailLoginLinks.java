package uk.ee.framework.pages.shop;

import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;
import ru.yandex.qatools.htmlelements.element.Link;
import uk.ee.framework.pages.BasePage;
import uk.ee.framework.post_processor.Loggable;

/**
 * Created by Syamphaneendra Kalluri on 06/29/2016
 * Modified by prabhu_s on 07/12/16.
 * This class represents the selenium version of the Retail Login Links screen.
 * 
 */
@Component
@Scope("prototype")
public class RetailLoginLinks extends BasePage {

	@Loggable
	protected Logger logger;

	// Shop Links

	@FindBy(xpath="(//a[@class='links-list__link h3'])[1]")
	Link paymPhonesLink;

	@FindBy(xpath="(//a[@class='links-list__link h3'])[2]")
	Link upgradeFromOrangeToEELink;

	@FindBy(xpath="(//a[@class='links-list__link h3'])[3]")
	Link upgradeFromTmobileToEELink;

	@FindBy(xpath="(//a[@class='links-list__link h3'])[4]")
	Link upgradeEELink;

	@FindBy(xpath="(//a[@class='links-list__link h3'])[5]")
	Link paygPhonesLink;

	// Stock Checker

	@FindBy(xpath="(//a[@class='links-list__link h3'])[6]")
	Link paymPhoneStockLink;

	@FindBy(xpath="(//a[@class='links-list__link h3'])[7]")
	Link paymDonglesLink;

	@FindBy(xpath="(//a[@class='links-list__link h3'])[8]")
	Link paymTabStockLink;

	/**
	 * @param typeOfLink
	 */
	public void navigateToGallery(final String typeOfLink) {
		if ("PAYMPhones".equalsIgnoreCase(typeOfLink)) {
			paymPhonesLink.click();
		} else if ("PAYGPhones".equalsIgnoreCase(typeOfLink)) {
			paygPhonesLink.click();
		} else {
			paymPhonesLink.click();
		}
	}

	/**
	 * 
	 */
	public void navigateToPaymPhoneGallery() {
		paymPhonesLink.click();
	}
	
	public void navigateToStockCheck(final String typeOfLink) {
		if (paymPhoneStockLink.getText().contains(typeOfLink)) {
			paymPhoneStockLink.click();
		} else if (paymDonglesLink.getText().contains(typeOfLink)) {
			paymDonglesLink.click();
		} else {
			paymTabStockLink.click();
		}
	}
	
	public void navigateToEEUpgrades() {
		upgradeEELink.click();
	}
}
