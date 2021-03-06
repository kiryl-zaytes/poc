package uk.ee.framework.elements.sections.shop;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Button;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by Syamphaneendra Kalluri on 07/25/2016
 * 
 * This class represents the selenium version of the Confirmation PopUp.
 * 
 */
public class ConfirmationPopUp extends CustomHtmlElement {

	@FindBy(xpath = "//*[@id='oo_launch_prompt']")
	Button yesBtn;

	@FindBy(xpath = "//*[@id='oo_no_thanks']")
	Button noBtn;

	/**
	 * selectBtn
	 */
	public void selectBtn(final String yesOrNo) {

		if ("yes".equalsIgnoreCase(yesOrNo)) {
			yesBtn.click();
		} else {
			noBtn.click();
		}
	}

}
