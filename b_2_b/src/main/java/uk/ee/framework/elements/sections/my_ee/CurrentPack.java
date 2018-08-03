package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Updated by anuj_dasari on 5/16/16.
 */

public class CurrentPack extends CustomHtmlElement {
	
	@FindBy(xpath = "//a[contains(text(),'Current pack')]")
	Link currentPack;
	
	@FindBy(xpath = "//a[contains(text(),'Learn about Packs')]")
	Link learnAboutPacks;
	
	@FindBy(css = "h2.h2.mod-current-pack__pack--title")
	TextBlock packName;
	
	@FindBy(css = "div.mod-current-pack__status")
	TextBlock packStatus;
	
    public String viewCurrentPackInfo(){
        String NameOfPack = packName.getText();
		packStatus.getText();
		return NameOfPack; 
    }
}
