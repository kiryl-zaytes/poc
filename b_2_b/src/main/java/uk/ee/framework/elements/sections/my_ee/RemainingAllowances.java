package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.support.FindBy;
import uk.ee.framework.elements.common.TextBlock;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

public class RemainingAllowances extends CustomHtmlElement {

    @FindBy(xpath = "//*[@id='main']/section[3]/form/div/div/div/span/div[2" +
            "]/div/div[2]/h3[2]/b/span[1]")
    TextBlock dataAllowance;

    @FindBy(xpath = "//*[@id='main']/section[3]/form/div/div/div/span/div[3" +
			"]/div/div[2]/h3[2]/b")
    TextBlock minutesLeft;

    @FindBy(xpath = "//*[@id='main']/section[3]/form/div/div/div/span/div[4" +
			"]/div/div[2]/h3[2]/b")
    TextBlock textLeft;

    public String checkRemainingAllowances() {
        assert dataAllowance.isDisplayed();
        assert minutesLeft.isDisplayed();
        assert textLeft.isDisplayed();
        return dataAllowance.getText() + minutesLeft.getText() +
                textLeft.getText();

    }

}
