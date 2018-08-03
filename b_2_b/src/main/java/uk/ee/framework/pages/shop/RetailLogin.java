package uk.ee.framework.pages.shop;

import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;
import uk.ee.framework.business_objects.dao.rsalogin.RSALoginDAO;
import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.common.TextInput;
import uk.ee.framework.pages.BasePage;
import uk.ee.framework.post_processor.Loggable;

/**
 * Created by Syamphaneendra Kalluri on 06/29/2016
 * 
 * This class represents the selenium version of the Retail Login screen.
 * 
 */

@Component
@Scope("prototype")
public class RetailLogin extends BasePage {

	@Loggable
	protected Logger logger;

	@FindBy(xpath = "//label[@for='employeeId']")
	TextInput employeeId;

	@FindBy(xpath = "//label[@for='storeId']")
	TextInput storeId;

	@FindBy(id = "commisionCode")
	TextInput storeCommCode;

	@FindBy(id = "rsaLogon")
	Button loginBtn;

	/**
	 * @param rsaLogObj
	 */
	public void login(final RSALoginDAO rsaLogObj) {
		employeeId.sendKeys(rsaLogObj.getEmployeeId());
		storeId.sendKeys(rsaLogObj.getStoreId());
		storeCommCode.sendKeys(rsaLogObj.getStoreCommCode());
		loginBtn.click();
	}
}
