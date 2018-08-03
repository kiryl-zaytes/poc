package uk.ee.framework.elements.sections.my_ee;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import uk.ee.framework.elements.common.TextBlock;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by kiryl_zayets on 5/8/16.
 */
public class LastBill extends CustomHtmlElement {

    @FindBy(css="a[href*='make-payment']")
    Link makePayment;

    @FindBy(css = "a[href*='my-bills']")
    Button seeBill;
    
    @FindBy(css ="h4.total-bill")
    TextBlock totalBill;

    public void makePayment(){
        makePayment.click();
    }

    public void seeBill(){
        seeBill.click();
    }

    public String getBillDetails(){
    	
    	return totalBill.getText(); 
    	
    }
}
