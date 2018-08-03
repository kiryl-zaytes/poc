package uk.ee.framework.pages.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.yandex.qatools.htmlelements.element.Link;
import uk.ee.framework.business_objects.dao.order_management.constant.ACCOUNT;
import uk.ee.framework.business_objects.dao.order_management.constant.CALLS;
import uk.ee.framework.business_objects.dao.order_management.constant.TERMS;
import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.common.Table;
import uk.ee.framework.elements.sections.shop.ChooseSim;
import uk.ee.framework.pages.BasePage;

import java.util.List;

/**
 * Created by Syamphaneendra Kalluri on 06/16/2016
 *
 * This class represents the selenium version of the Sim Only screen.
 *
 */
@Component
@Scope("prototype")
public class SimOnly extends BasePage {

	@FindBy(css = "div.promo-float-left")
	ChooseSim chooseSimMonthly;

	@FindBy(css = "div.promo-float-right")
	ChooseSim chooseSimAsYouGo;

	@FindBy(css = "a[href*='frequencyTab30']")
	Link plan30;

	@FindBy(css = "a[href*='frequencyTab12']")
	Link plan12;

	@FindBy(css="a[href*='sim-only/pay-monthly-phones']")
	Button SBSimoLink;

	Table planListing;
	String table12ID = "frequencyTab12_monthly__1";
	String table30ID = "frequencyTab30_daily__0";

    @FindBy(xpath = "//*[@id='command']//button") private List<Button> simList;

    /**
     * @param dataAmount
     * @param term
     * @param account
     * @param calls
     */
    public void selectPlan(String dataAmount,
            TERMS term,
            ACCOUNT account,
            CALLS calls) {
        selectSimType(account, calls);
        // selectTerm(term);
        // planListing.selectLastColumnButtonByValueInRow(dataAmount);

	}

	/**
	 * @param account
	 * @param calls
	 */
	private void selectSimType(ACCOUNT account, CALLS calls) {
		if (account == ACCOUNT.PAYM) {
			if (calls == CALLS.PHONE) {
				chooseSimMonthly.goPaymPhoneSims();
			} else {
				chooseSimMonthly.goTabletsSims();
			}
		} else {
			if (calls == CALLS.PHONE) {
				chooseSimAsYouGo.goPaygPhoneSims();
			} else {
				chooseSimAsYouGo.goTabletsSims();
			}
		}
	}

    /**
     * @param term
     * @return
     */
    private Table selectTerm(TERMS term) {
        if (term == TERMS.MONTH12) {
            plan12.click();
            planListing = new Table(browser.findElement(By.id(table12ID)));
        } else {
            plan30.click();
            planListing = new Table(browser.findElement(By.id(table30ID)));
        }
        return planListing;
    }


    public void selectSBSIMO() {
        SBSimoLink.click();
    }

    public int getSimsCount(){
        return simList.size();
    }

}
