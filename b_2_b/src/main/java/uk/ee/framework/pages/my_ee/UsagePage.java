package uk.ee.framework.pages.my_ee;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import uk.ee.framework.elements.sections.my_ee.CurrentAllowanceDetails;
import uk.ee.framework.elements.common.Link;
import uk.ee.framework.elements.sections.my_ee.ConfirmationPopUp;
import uk.ee.framework.pages.BasePage;

/**
 * Created by anuj_dasari on 5/12/16.
 * updated by Prabhu S on 08/02/16
 */

@Component
@Scope("prototype")
public class UsagePage extends BasePage {

	@FindBy(css = "div.usage-allowance-detail-container")
	CurrentAllowanceDetails currentAllowanceDetails;

	@FindBy(css = "div.panel.ee-form.white")
	CurrentAllowanceDetails extraCharges;
	
	@FindBy(css = "div.col.span-12.panels.ee-form")
	CurrentAllowanceDetails dataPasses;
	
	@FindBy(xpath="//a[@href='#datapassscroll']")
	Link seeDataPass;
	
	@FindBy(xpath = "//*[@id='oo_invitation_prompt']")
	ConfirmationPopUp popUp;
	
	public String viewAllowances(){
		return extraCharges.checkCurrentAllowanceDetails();
	}
	
	public String viewAllowanceDetails(){
		return currentAllowanceDetails.getCurrentAllowanceDetails();
	}
	
	public void viewDataPasses(){
		seeDataPass.click();
		dataPasses.getDataPasses();
	}
	
	public void closeThePopUp(final String yesOrNo) {
		try{
			String myWindowHandle = browser.getWindowHandle();
			if (null != myWindowHandle) {
				browser.switchTo().window(myWindowHandle);
				popUp.selectBtn(yesOrNo);
			}
		} catch (ElementNotVisibleException e){
			System.out.println("No Pop-up");
		}
	}
	
}


