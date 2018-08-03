package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.htmlelements.element.TextInput;
import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.common.Radio;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;
import uk.ee.framework.utils.Waiter;

/**
 * Created by prabhu_s on 08/02/16.
 * 
 * This is PAYM Alerts tab section on Account and Settings page
 */

public class AlertsTab extends CustomHtmlElement{

	@FindBy(xpath = "//a[contains(text(),'Your alerts')]")
	Button alertsTab;
	
    @FindBy(css = "input#topUpReminderBalance")
    TextInput topUpRemainder;
    
    @FindBy(id= "topup-reminder-yes")
    Radio topUpReminderActive;
    
    @FindBy(css = "input#btn-2")
    Button applyPayg;
    
	@FindBy(css = "div.mod-notification-pane")
	WebElement notificationArea;
	
	@FindBy(xpath="//label[contains(text(),'Text')]")
	WebElement alertTextPaym;
	
	@FindBy(xpath="//label[contains(text(),'Text to another')]")
	WebElement alertTexttoOtherPaym;
	
	@FindBy(xpath="//label[contains(text(),'Email')]")
	WebElement alertEmailPaym;
	
	@FindBy(css = "input#billOptions")
    Button applyPaym;
	
	@FindBy(css="span.h4.mod-notification-pane__title-text")
	WebElement notification;
	
    
	public String setupPAYGAlert(String amount){
		
//		topUpReminderActive.selectByIndex(0);
		topUpRemainder.sendKeys(amount);
		applyPayg.click();
		System.out.println("Status: " + notification.getText());
		Assert.assertTrue(notification.getText().contains("Your low balance alert has been successfully updated"));
		return notification.getText();
	}

	public void validatePaymAlerts(String alertType) {
		alertTexttoOtherPaym.click();
		applyPaym.click();
		System.out.println("Status: " + notification.getText());
		Assert.assertTrue(notification.getText().contains("Thanks. Your bill reminders will be sent to your new preference in future"));	
		
	}
}

