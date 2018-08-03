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
 * 
 * This class represents the selenium version of the Confirm Retail Login
 * Screen.
 * 
 */
@Component
@Scope("prototype")
public class ConfirmRetailLoginScreen extends BasePage {

	@Loggable
	protected Logger logger;

	@FindBy(css = "a[id*='confirmAgent']")
	Link yesButton;

	@FindBy(css = "a[href*='retailLogin/logout']")
	Link noButton;

	/**
	 * @param confirmStr
	 */
	public void confirmLogin(final String confirmStr) {
		if ("Yes".equalsIgnoreCase(confirmStr)) {
			yesButton.click();
		} else {
			noButton.click();
		}
	}
}
