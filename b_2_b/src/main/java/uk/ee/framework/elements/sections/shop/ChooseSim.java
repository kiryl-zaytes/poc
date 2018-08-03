package uk.ee.framework.elements.sections.shop;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Button;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by Syamphaneendra Kalluri on 06/16/2016
 * 
 * This class represents the selenium version of the Choose Sim section.
 * 
 */
public class ChooseSim extends CustomHtmlElement {

	@FindBy(css="a.cta-group__button.button.button-primary")
	Button paymPhoneSims;

	@FindBy(css="a.cta-group__button.button.button-secondary")
	Button paygPhoneSims;

	@FindBy(css = "a.button-secondary")
	Button tabletsSim;

	/**
	 * 
	 */
	public void goPaymPhoneSims() {
		paymPhoneSims.click();
	}

	/**
	 * 
	 */
	public void goPaygPhoneSims() {
		paygPhoneSims.click();
	}

	/**
	 * 
	 */
	public void goTabletsSims() {
		tabletsSim.click();
	}
}
