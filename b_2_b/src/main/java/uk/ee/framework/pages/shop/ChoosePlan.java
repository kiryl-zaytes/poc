package uk.ee.framework.pages.shop;

import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import uk.ee.framework.business_objects.dao.order_management.Order;
import uk.ee.framework.business_objects.dao.order_management.constant.PLAN;
import uk.ee.framework.elements.common.Button;
import uk.ee.framework.pages.BasePage;

/**
 * Created by Syamphaneendra Kalluri on 06/06/2016
 * 
 * This class represents the selenium version of the choose plan screen.
 * 
 */
@Component
@Scope("prototype")
public class ChoosePlan extends BasePage {

	/*
	 * @FindBy(css = "//input.button alt[value='CHOOSE THIS PLAN']") Button
	 * chooseThisPlan;
	 */

	@FindBy(css="input.button.alt")
	Button chooseThisPlan;

	@FindBy(css = "a#plansTab")
	Button paygPacksTab;

	@FindBy(xpath = "//*[@id='command']/input[6]")
	Button choose;
	
	@FindBy(css="a.button.submit.aqua.trigger-click")
	Button paygChoose;
	
	@FindBy(xpath="//input[@type='submit']")
	Button sbChoosePlan;

	@FindBy(css= "input.button.theme-default.theme-standard.bold-outline")
	Button rsaChooseThisPlan;
	
	@FindBy(css= "input.button.theme-default.theme-standard")
	Button upgradeChooseThisPlan;
		

	/**
	 * @param order
	 */
	
	public void selectPlan(String planType, final Order order) {
		if ("SB".equalsIgnoreCase(planType)) {
			chooseSBPlan(order);
		}else if ("PAYM".equalsIgnoreCase(planType)) {
		choosePaymPlan(order);
		} else {
			choosePaygPhonePlan(order);
		}
	}
	
	public void choosePaymPlan(final Order order) {

		if (order.getPlan() == PLAN.BEST_SELLING) {
			chooseThisPlan.click();
		} else {
			choose.click();
		}
	}
	
	public void chooseMBBPlan(final Order order) {

		if (order.getPlan() == PLAN.BEST_SELLING) {
			chooseThisPlan.click();
		} else {
			choose.click();
		}
	}
	
	/**
	 * @param order
	 */
	public void choosePaymPhonePlan(final Order order) {

		if (order.getPlan() == PLAN.BEST_SELLING) {
			rsaChooseThisPlan.click();
		} else {
			choose.click();
		}
	}

	/**
	 * @param order
	 */
	public void choosePaygPhonePlan(final Order order) {

		if (order.getPlan() == PLAN.BEST_SELLING) {
			chooseThisPlan.click();
		} else {
			paygPacksTab.click();
			paygChoose.click();
		}
	}

	/**
	 * @param order
	 */
	public void chooseRSAPaymPhonePlan(final Order order) {
		if (order.getPlan() == PLAN.BEST_SELLING) {
			rsaChooseThisPlan.click();
		} else {
			choose.click();
		}
	}
	
	public void chooseSBPlan(final Order order) {

		if (order.getPlan() == PLAN.BEST_SELLING) {
			sbChoosePlan.click();
		} else {
			sbChoosePlan.click();
		}
	}
	
	public void chooseUpgradePhonePlan(final Order order) {

		if (order.getPlan() == PLAN.BEST_SELLING) {
			upgradeChooseThisPlan.click();
		} else {
			choose.click();
		}
	}


}
