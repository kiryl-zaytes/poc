package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import uk.ee.framework.elements.common.TextBlock;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

public class TopUpCompleteTab extends CustomHtmlElement{

	@FindBy(css="span.mod-notification-pane__subtitle")
	TextBlock successTopup;
	
	public void successTopUp() {
		Assert.assertNotNull(successTopup.getText());
		System.out.println(successTopup.getText());
		
	}
}
