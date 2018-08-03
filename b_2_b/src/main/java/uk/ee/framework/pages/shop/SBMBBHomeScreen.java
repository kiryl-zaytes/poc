package uk.ee.framework.pages.shop;

import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import uk.ee.framework.elements.common.Button;
import uk.ee.framework.pages.BasePage;

/**
 * Created by Syamphaneendra Kalluri on 07/07/2016
 * Modified by prabhu_s on 07/13/16
 * This class represents the selenium version of the SB MBB Home screen.
 * 
 */
@Component
@Scope("prototype")
public class SBMBBHomeScreen extends BasePage {

	@FindBy(xpath = "//a[text()='View our 4GEE WiFi devices']")
	Button sbMBBWifiDevicesLink;

	public void selectWiFiDevices() {
		sbMBBWifiDevicesLink.click();
	}

}
