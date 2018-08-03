package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.support.FindBy;

import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

public class TopUpConfirmTab extends CustomHtmlElement{

	@FindBy(css="input#submitButton")
	Button submitButton;
	
	public void topUpNewCardConfirm(){
		System.out.println(submitButton.getText());
//		submitButton.click();
	}
}
