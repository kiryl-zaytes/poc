package uk.ee.framework.pages.shop;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import uk.ee.framework.elements.common.TextBlock;
import uk.ee.framework.pages.BasePage;

/**
 * Created by Syamphaneendra Kalluri on 06/06/2016
 * 
 * This class represents the selenium version of the Confirmation screen.
 * 
 */
@Component
@Scope("prototype")
public class ConfirmationPage extends BasePage {

	@FindBy(css = "span.order-placeholder")
	TextBlock orderNumber;

	/**
	 * @return
	 */
	public String getOrderNumber() {
		try {Assert.assertNotNull(orderNumber.getText());
		return orderNumber.getText();
		} catch (NoSuchElementException e){
			Assert.fail();
			return null;
		}
		
	}

}
