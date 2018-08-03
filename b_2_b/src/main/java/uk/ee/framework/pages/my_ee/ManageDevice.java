package uk.ee.framework.pages.my_ee;

import org.openqa.selenium.support.FindBy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import uk.ee.framework.elements.sections.my_ee.CurrentUsage;
import uk.ee.framework.elements.sections.my_ee.DeviceControlsTab;
import uk.ee.framework.elements.sections.my_ee.DeviceUsageControls;
import uk.ee.framework.elements.sections.my_ee.GroupUsageControls;

import uk.ee.framework.pages.BasePage;

/**
 * Created by Prabhu S on 5/12/16.
 */
@Component
@Scope("prototype")
public class ManageDevice extends BasePage {
	
	
	@FindBy(id = "Device_Controls_ID")
	DeviceControlsTab deviceControl;

	@FindBy(id= "Device_Usage_Controls_ID")
	DeviceUsageControls deviceUsageControls;
	
	@FindBy(id="Group_Usage_Controls_ID")
	GroupUsageControls groupUsageControlsTab;
	
	@FindBy(id="GroupUsageControls")
	GroupUsageControls groupUsageControls;
	
	CurrentUsage currentUsage;

	public void manageContentLock(String status) {
		deviceControl.updateContentLock(status);		
	}

	public void deviceUsageControls(String status, String addOn) {
		deviceUsageControls.click();
		String returnMsg = (String) deviceUsageControls.updateDeviecUsageControls(status, addOn);
		System.out.println("returnMsg: " + returnMsg);
		Assert.assertTrue(returnMsg.contains("Service control details have been updated successfully."));		
	}
	
	public void groupUsageControls(String status) {
		groupUsageControlsTab.click();
		groupUsageControls.grpUpdate(status);
		
		
	}
}