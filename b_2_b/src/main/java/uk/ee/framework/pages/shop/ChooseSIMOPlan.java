package uk.ee.framework.pages.shop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import uk.ee.framework.business_objects.dao.order_management.Order;
import uk.ee.framework.elements.common.Button;
import uk.ee.framework.pages.BasePage;

import java.util.List;

/**
 * Created by Syamphaneendra Kalluri on 06/06/2016
 * <p>
 * This class represents the selenium version of the choose SIMO plan screen.
 */
@Component
@Scope("prototype")
public class ChooseSIMOPlan extends BasePage {

    @FindBy(xpath = "(//*[@id='me']/a)[1]")
    Button paygPhoneChoose;

    @FindBy(xpath = "(//*[@id='command']/p/button[1])[7]")
    Button paymPhoneChoose;

    @FindBy(xpath = "(//*[@id='me']/a)[1]")
    Button choose;

    @FindBy(css = "a.button.submit.aqua")
    List<WebElement> sbChoose;

    @FindBy(xpath = "(//*[@id='me']/a)[4]")
    Button sbchooseBtn;

    @FindBy(xpath = "//*[@id='me']/a") 
    private List<Button> plansList;

	public void choosePlan(final Order order) {
		choose.click();
	}
	/**
	 * @param order
	 */
	public void choosePaygPhonePlan(final Order order) {
		paygPhoneChoose.click();
	}

	/**
	 * @param order
	 */
	public void choosePaymPhonePlan(final Order order) {
		paymPhoneChoose.click();
	}

	/**
	 * @param order
	 *//*
	public void chooseSBSIMOPlan() {
		waiter.displayButtonCheck(sbChoose);
	}*/
    public void chooseSBSIMOPlan() {
        sbchooseBtn.click();
    }

    public int getPlansCount(){
        return plansList.size();
    }

}
