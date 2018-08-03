package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by Prabhu_S on 5/31/16.
 * 
 * Modified by Syamphaneendra kalluri on 08/02/16.
 */
public class DeviceUsageControls extends CustomHtmlElement {

	@FindBy(xpath = "//*[@id='usageControls_Submit']")
	Button submitUsageControl;

	@FindBy(xpath = "//label[@for='use_data_allow']")
	WebElement userDataAllow;

	@FindBy(xpath = "//label[@for='use_data_block']")
	WebElement userDataBlock;

	@FindBy(xpath = "//label[@for='buy_addons_allow']")
	WebElement buyAddonsAllow;

	@FindBy(xpath = "//label[@for='buy_addons_block']")
	WebElement buyAddonsBlock;

	@FindBy(xpath = "//label[@for='roaming_allow']")
	WebElement roamingAllow;

	@FindBy(xpath = "//label[@for='roaming_block']")
	WebElement roamingBlock;

	@FindBy(xpath = "//label[@for='calls_anywhere_allow']")
	WebElement callsAnywhereAllow;

	@FindBy(xpath = "//label[@for='calls_anywhere_block']")
	WebElement callsAnywhereBlock;

	public Object updateDeviecUsageControls(String status, String addOn) {
		String statusMsg = null;

		if (status.equalsIgnoreCase("Allow")) {

			switch (addOn) {
			case "Use Data":
				userDataAllow.click();
				submitUsageControl.click();

			case "Buy Data":
				buyAddonsAllow.click();
				submitUsageControl.click();

			case "Roaming":
				roamingAllow.click();
				submitUsageControl.click();

			case "Call abroad":
				callsAnywhereAllow.click();
				submitUsageControl.click();
			default:
				submitUsageControl.click();
			}
		} else {
			switch (addOn) {
			case "Use Data":
				userDataBlock.click();
				submitUsageControl.click();

			case "Buy Data":
				buyAddonsBlock.click();
				submitUsageControl.click();

			case "Roaming":
				roamingBlock.click();
				submitUsageControl.click();

			case "Call abroad":
				callsAnywhereBlock.click();
				submitUsageControl.click();
			default:
				submitUsageControl.click();
			}
		}
		// The below components are used to identify the hidden elements.
		WebElement serviceControlsErrorMsgDiv = webDriver.findElement(By.id("serviceControlsErrorMsg"));
		WebElement serviceControlsSuccessMsgDiv = webDriver.findElement(By.id("serviceControlsSuccessMsg"));
		WebElement serviceControlsSuccessMsg = webDriver.findElement(By
				.cssSelector("div[id='serviceControlsSuccessMsg'] span[class='h4 mod-notification-pane__title-text']"));
		WebElement serviceControlsErrorMsg = webDriver.findElement(
				By.cssSelector("div[id='serviceControlsErrorMsg'] span[class='h4 mod-notification-pane__title-text']"));

		System.out.println("serviceControlsErrorMsg.isDisplayed(): " + serviceControlsErrorMsgDiv.isDisplayed());
		System.out.println("serviceControlsSuccessMsg.isDisplayed(): " + serviceControlsSuccessMsgDiv.isDisplayed());

		if (serviceControlsSuccessMsgDiv.isDisplayed()) {
			statusMsg = serviceControlsSuccessMsg.getText();
		} else {
			statusMsg = serviceControlsErrorMsg.getText();
		}
		System.out.println("statusMsg: " + statusMsg);
		return statusMsg;
	}
}
