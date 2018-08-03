package uk.ee.framework.elements.sections.shop;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;

/**
 * Created by Syamphaneendra Kalluri on 06/06/2016
 * 
 * This class represents the selenium version of the Terms And Conditions
 * section.
 * 
 */
public class TermsAndConditions extends CustomHtmlElement {

	@FindBy(xpath = "//label[@for='termsCheckBox']")
	WebElement termsCheckBox;

	@FindBy(xpath = "//label[@for='coverageCheckerCheckBox']")
	WebElement coverageCheckBox;

	@FindBy(xpath = "//label[@for='idRequiredCheckBox']")
	WebElement requiredCheckBox;

	@FindBy(css = "input.checkout-cta")
	Button nextStep;
	
	@FindBy(xpath="//label[@for='confirmSoleTraderCheckBox']")
	WebElement soleTraderCheckBox;
	/**
	 * 
	 */
	public void agreeTerms() {
		termsCheckBox.click();
		coverageCheckBox.click();
		requiredCheckBox.click();
		nextStep.click();
	}

	/**
	 * 
	 */
	public void agreeSIMOTerms() {
		termsCheckBox.click();
		nextStep.click();
	}
	
	public void agreeSBSoleTraderTerms() {
		soleTraderCheckBox.click();
		termsCheckBox.click();		
		nextStep.click();
	}
	
	public void agreeSBTerms() {
		try {
			if (soleTraderCheckBox.isDisplayed()) {
				soleTraderCheckBox.click();
			}
		} catch (NoSuchElementException exception) {
			System.out.println("Proceed to Next checkbox");
		}

		try {
			if (coverageCheckBox.isDisplayed()) {
				coverageCheckBox.click();
			}
		} catch (NoSuchElementException exception) {
			System.out.println("Proceed to Next checkbox");
		}
		try {
			if (requiredCheckBox.isDisplayed()) {
				requiredCheckBox.click();
			}
		} catch (NoSuchElementException exception) {
			System.out.println("Proceed to Next checkbox and click next step");
		} finally {
			termsCheckBox.click();
			nextStep.click();
		}
	}
	
}
