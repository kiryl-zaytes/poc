package uk.ee.framework.pages.my_ee;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import uk.ee.framework.elements.sections.my_ee.TopUpHistoryTable;
import uk.ee.framework.pages.BasePage;
import uk.ee.framework.utils.Waiter;

/**
 * Created by anuj_dasari on 5/16/16.
 */

@Component
@Scope("prototype")
public class TopUpHistory extends BasePage {

	@FindBy(xpath ="(//div[@class='col span-12'])[2]")
	TopUpHistoryTable topUpHistoryTable;
	
	@FindBy(css= "div.col.span-12>div.panel>h3")
	private WebElement noTopUpMsg;
	
	public String viewTopUpHistory(){
		Waiter.switchToWindow(browser);
		try{
			if(noTopUpMsg.isDisplayed()){
				return noTopUpMsg.getText();
			}
		} catch (NoSuchElementException e){
			return topUpHistoryTable.getTopUpHistoryDetails().toString();
		}
		return null;
	}
}