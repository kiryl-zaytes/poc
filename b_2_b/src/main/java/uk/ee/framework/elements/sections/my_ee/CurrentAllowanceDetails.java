package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import uk.ee.framework.elements.common.TextBlock;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by anuj_dasari on 5/12/16.
 */

public class CurrentAllowanceDetails extends CustomHtmlElement{
	
	@FindBy(xpath = "//div[@class='dau-subtitle']/h2[contains(text(),'Your allowances')]")
    WebElement currentAllowances;
    
	@FindBy(css = "div.usage-datapass-header>h3")
	WebElement allowanceDetails;
    
	@FindBy(xpath = "//span[@class='ec-total-so-far-amount']")
	WebElement extraChargesIncurred;
	
	@FindBy(css = "span.usage-datapass-header-text2>span")
	WebElement dataAllowanceLeft;
	
	@FindBy(css = "span.usage-datapass-header-text3>span")
	WebElement maxDataAllowance;
	
	@FindBy(css="span.usage-datapass-header-text2.usage-datapass-header-text2--lg")
	TextBlock remaininAllowance;

	@FindBy(css="div.usage-itemisation--table")
	TextBlock dataPass;
	
    public String checkCurrentAllowanceDetails(){
    	//return allowanceDetails.getText();
    	System.out.println(extraChargesIncurred.getText());
//    	Assert.assertTrue(extraChargesIncurred.getText().contains("�"));
    	return ("Extra charges incurred: " + extraChargesIncurred.getText());
    } 

    public String getCurrentAllowanceDetails(){
    	System.out.println(remaininAllowance.getText());
    	Assert.assertTrue(remaininAllowance.getText().contains("left"));
    	return (dataAllowanceLeft.getText() + "left of" +maxDataAllowance.getText());
    }
    
    public void getDataPasses(){
    	
    	Assert.assertTrue(dataPass.isDisplayed());
    	
    } 
}
