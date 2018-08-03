package uk.ee.framework.pages.shop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import uk.ee.framework.pages.BasePage;
@Component
@Scope("prototype")
public class SearchResults extends BasePage{

	@FindBy(css="h4.search-results-desktop")
	WebElement resultsCount;
	
	public void webSearchResult(){
		System.out.println(resultsCount.getText());
	}
}
