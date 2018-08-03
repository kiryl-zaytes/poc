package uk.ee.framework.pages.my_ee;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.sections.my_ee.AlertsTab;
import uk.ee.framework.pages.BasePage;

/**
 * updated by anuj_dasari on 5/26/16.
 */
@Component
@Scope("prototype")
public class AccountSettings extends BasePage{

	@FindBy(xpath = "//a[contains(text(),'Your alerts')]")
	Button alertsTabButton;
	
	@FindBy(xpath = "//a[contains(text(),'Your alerts')]")
	Button alertsTab;
	
	@FindBy(css="section.tabs.tabs-content")
	AlertsTab alertsSectionPayG;
	
	@FindBy(xpath = "//a[contains(text(),'Your alerts')]")
	WebElement alertsTabPayM;

	public void setupPAYGAlert(String amount){
		alertsTabButton.click();
		alertsSectionPayG.setupPAYGAlert(amount);
	}

	public void setupPaymAlert(String alertType) {
		alertsTabPayM.click();
		alertsSectionPayG.validatePaymAlerts(alertType);
	}
}
