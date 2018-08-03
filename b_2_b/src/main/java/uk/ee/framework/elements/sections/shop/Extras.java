package uk.ee.framework.elements.sections.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;
import uk.ee.framework.utils.Waiter;

import java.util.List;

/**
 * Created by kiryl_zayets on 5/23/16.
 */
@Timeout(5)
public class Extras extends CustomHtmlElement {

    @FindAll({@FindBy(css = "h2.addon__header")})
    private List<WebElement> extrasSection;

    @FindAll({@FindBy(css = "span.label")})
    private List<WebElement> labels;


    String checkbox = "label[for^='bundle'][for*='SingleTerms']";
    String done = "input[id^='bundle'][id$='DoneButton']";
    String modal = "div.terms-overlay[id^='modal-bundle'][id*='SingleTerms']";


    public void chooseExtras(List<String> extras, WebDriver webDriver)  {

        if (extras.size()==0){
            return;
        }

        for (WebElement extr : extrasSection) {
            extr.click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (WebElement label : labels) {
            String text = label.getText();
            if (extras.get(0).contains(text)) {
                label.click();
                extras.remove(0);
                acceptModalForm(webDriver);
                if (extras.size() == 0) {
                    break;
                }

            }
        }
    }


    private void acceptModalForm(WebDriver webDriver) {
        try {
            new Waiter(webDriver).elementVisible(By.cssSelector(modal));

            WebElement form = webDriver.findElement(By.cssSelector(modal));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            form.findElement(By.cssSelector(checkbox)).click();

            form.findElement(By.cssSelector(done)).click();

        } catch (Exception e) {

        }
    }
}
