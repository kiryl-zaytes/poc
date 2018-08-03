package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gargoylesoftware.htmlunit.javascript.host.media.rtc.webkitRTCPeerConnection;

import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by anuj_dasari on 5/16/16.
 */
public class TopUpHistoryTable extends CustomHtmlElement{
	
	@FindBy(css = "th.table-column-0")
    WebElement dateColumnHeader;
    
	@FindBy(css = "th.table-column-1")
	WebElement typeColumnHeader;
	
	@FindBy(css = "th.table-column-2")
    WebElement amountColumnHeader;
	
	@FindBy(css = "td.table__row-header.table-column-0")
	WebElement dateColumnEntry;
	
	@FindBy(css="table.container__table.cols-4.sortable")
	WebElement table;
	
    public Boolean getTopUpHistoryDetails(){
    
    		return table.isDisplayed(); 
    	
    	
    	
    		
    } 
}

