package uk.ee.framework.elements.sections.my_ee;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uk.ee.framework.elements.common.Link;
import uk.ee.framework.elements.common.Table;
import uk.ee.framework.elements.common.TextBlock;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

public class PayGAllowanceSectionDashboard extends CustomHtmlElement {

	@FindBy(xpath = "//a[contains(text(),'Allowance') and @target='_top']")
	Link allowanceTab;

	@FindBy(xpath = "//a[contains(text(),'Usage') and @target='_top']")
	Link usageTab;

	@FindBy(xpath = "(//span[@class='usage-datapass-header-text2'])[1]")
	private WebElement dataAllowance;

	@FindBy(xpath = "(//span[@class='usage-datapass-header-text2'])[2]")
	private WebElement minutesAllowance;

	@FindBy(xpath = "(//span[@class='usage-datapass-header-text2'])[3]")
	private WebElement textsAllowance;
	
	@FindBy(xpath  = "//div[@id='Usage']")
	private WebElement dataUsageTable;
		


	 @FindBy(css = "table.current-addons-table")
	  Table addonsList;
	 
	 @FindBy(xpath = "//a[contains(text(),'Remove add-on')]")
	  List<WebElement> removeAddon;
	  

	  
	  @FindBy(xpath = "//a[contains(text(),'Buy another')]")
	  List<WebElement> buyAnother;
	
		@FindBy(xpath = "//a[contains(text(),'Learn about Add-ons')]")
		 Link learnAddOns;
		

		
	public String allowanceSection() {
		return ("Remaining Data Allowance: " + dataAllowance.getText()
				+ " Remaining Text Allowance: " + textsAllowance.getText()
				+ " Remaining Mins Allowances: " + minutesAllowance.getText());
	}

	public boolean selectUsageTab() {
		usageTab.click();
		try {
			if(dataUsageTable.isDisplayed()) {
				return true;
			}
		}
		catch(NoSuchElementException e) {
			return false;
		}
		return false;
	}
	
	
	
}
