package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Select;
import uk.ee.framework.business_objects.dao.credit_card.CreditCard;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by kiryl_zayets on 5/8/16.
 */
public class AddCreditCard extends CustomHtmlElement {

    @FindBy(css = "#cardType")
    Select cardType;

    public void addCreditCard(CreditCard creditCard){

    }

}
