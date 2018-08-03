package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.common.Link;
import uk.ee.framework.elements.common.TextInput;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by Prabhu_S on 5/16/16.
 * 
 * Modified by Syamphaneendra kalluri on 08/02/16.
 */
public class DeviceControlsTab extends CustomHtmlElement {

	@FindBy(xpath = "//span[contains(text(),'Allow')]")
	Button allowContentLockRadio;

	@FindBy(xpath = "//span[contains(text(),'Block')]")
	Button blockContentLockRadio;

	// @FindBy(id = "setContentLock")
	@FindBy(xpath = "//input[@id='setContentLock']")
	WebElement applyContentLock;

	@FindBy(css = "div.device-control-link.a")
	Link unlockPhone;

	@FindBy(id = "linkpuk")
	Link showPuk;

	@FindBy(id = "viewpukid")
	TextInput puk;

	@FindBy(xpath = "//span[contains(text(),'Your Content Lock')]")
	WebElement updatedContentLockMsg;

	public Object updateContentLock(String status) {
		String statusMsg = null;
		if (status.equalsIgnoreCase("Allow")) {
			allowContentLockRadio.click();
		} else {
			blockContentLockRadio.click();
		}
		// To click the Apply button.
		applyContentLock.click();
		// The below components are used to identify the hidden elements.
		WebElement contentLockErrorMsgDiv = webDriver.findElement(By.id("contentLockErrorMsg"));
		WebElement contentLockSuccessMsgDiv = webDriver.findElement(By.id("contentLockSuccessMsg"));
		WebElement contentLockSuccessMsg = webDriver.findElement(
				By.cssSelector("div[id='contentLockSuccessMsg'] span[class='h4 mod-notification-pane__title-text']"));
		WebElement contentLockErrorMsg = webDriver.findElement(
				By.cssSelector("div[id='contentLockErrorMsg'] span[class='h4 mod-notification-pane__title-text']"));

		System.out.println("contentLockErrorMsgDiv.isDisplayed(): " + contentLockErrorMsgDiv.isDisplayed());
		System.out.println("contentLockSuccessMsgDiv.isDisplayed(): " + contentLockSuccessMsgDiv.isDisplayed());

		if (contentLockSuccessMsgDiv.isDisplayed()) {
			statusMsg = contentLockSuccessMsg.getText();
		} else {
			statusMsg = contentLockErrorMsg.getText();
		}
		System.out.println("statusMsg: " + statusMsg);
		Assert.assertTrue(statusMsg.contains("Your Content Lock setting for this device has been updated."));
		return statusMsg;
	}

}