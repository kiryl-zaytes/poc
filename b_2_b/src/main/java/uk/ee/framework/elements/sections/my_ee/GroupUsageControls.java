package uk.ee.framework.elements.sections.my_ee;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Table;
import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by kiryl_zayets on 5/13/16.
 */
public class GroupUsageControls extends CustomHtmlElement {

    @FindBy(id = "sharerDetailTable")
    Table devicesList;
    
    @FindBy(css ="label.green-button ")
    List<WebElement> greenButton;
    
    @FindBy(css ="label.red-button ")
    List<WebElement> redButton;
    
    @FindBy(xpath ="//input[@value='Confirm']")
    List<WebElement> confirm;
    
    public void grpUpdate(String status) {
    	Random randomGenerator = new Random();
    	if (status.equalsIgnoreCase("green")){
		int randomIndex = randomGenerator.nextInt(greenButton.size());
		greenButton.get(randomIndex).click();
		
    	} else 
    	{
    		int randomIndex = randomGenerator.nextInt(redButton.size());
    		redButton.get(randomIndex).click();
    	}
    	for(int i=0; i<confirm.size(); i++){
    		if (confirm.get(i).isDisplayed()){
    	    	confirm.get(i).click();
    	    	break;
    		}
    	}
    }
}
