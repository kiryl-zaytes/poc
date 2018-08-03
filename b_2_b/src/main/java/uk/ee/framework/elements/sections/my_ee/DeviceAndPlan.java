package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import uk.ee.framework.elements.common.Link;
import uk.ee.framework.elements.common.TextBlock;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

public class DeviceAndPlan extends CustomHtmlElement{

	@FindBy(css = "div.deviceImg")
	WebElement deviceImg;
	
	@FindBy(css = "div.deviceDetails>span.deviceName")
	TextBlock deviceName;
	
	@FindBy(css = "div.deviceDetails>span.device-number")
	TextBlock deviceNumber;
	
	@FindBy(xpath = "//a[contains(text(),'Manage your device')]")
	Link manageDevice;

	@FindBy(xpath = "//*[@id='tariffName0']")
	TextBlock tariffName;
	
	@FindBy(xpath = "//a[contains(text(),'See plans and upgrades details')]")
	Link upgradePlans;
	
	@FindBy(xpath = "//a[contains(text(),'Manage plan and add-ons')]")
	Link managePlans;

	@FindBy(id="topText")
	TextBlock toptext;
	
	@FindBy(css = "span.mod-single-device__image")
	WebElement deviceImgMbb;
	
	@FindBy(css = "a#deviceName")
	TextBlock deviceNameMbb;
	
	@FindBy(css = "span.mod-single-device__number")
	TextBlock deviceNumberMbb;
	
	
	public void viewPayMDevicesAndPlansInfo() {
		Assert.assertNotNull(deviceImg);
		Assert.assertNotNull(deviceName);
		String NameOfDevice = deviceName.getText();
		assert deviceNumber.isDisplayed();
		String NumberOfDevice = deviceNumber.getText();
		String planName = tariffName.getText();

	}

	public String viewSBDevicesAndPlansInfo() {
		Assert.assertNotNull(deviceImg);
		Assert.assertNotNull(deviceName);
		String NameOfDevice = deviceName.getText();
		assert deviceNumber.isDisplayed();
		String NumberOfDevice = deviceNumber.getText();
		return tariffName.getText();
	}
	 
	public void viewMBBDevicesInfo() {
		Assert.assertNotNull(deviceImg);
		Assert.assertNotNull(deviceName);
		Assert.assertNotNull(deviceNumberMbb);
	}
}
