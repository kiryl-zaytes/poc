package uk.ee.framework.pages.shop;

import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.common.TextInput;
import uk.ee.framework.pages.BasePage;

/**
 * Created by Syamphaneendra Kalluri on 06/20/2016
 * 
 * This class represents the selenium version of the ThreeDSecure screen.
 * 
 */
@Component
@Scope("prototype")
public class ThreeDSecure extends BasePage {

	@FindBy(xpath = "//input[@type='password']")
	TextInput threeDPassword;

	@FindBy(xpath = "//input[@name='UsernamePasswordEntry']")
	Button threeDSubmit;

	/**
	 * 
	 */
	public void threeDSubmit() {
		threeDPassword.sendKeys("1234");
		threeDSubmit.click();
	}
}
