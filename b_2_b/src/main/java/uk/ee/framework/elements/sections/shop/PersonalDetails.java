package uk.ee.framework.elements.sections.shop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;
import uk.ee.framework.business_objects.dao.customer.Customer;
import uk.ee.framework.elements.common.Button;
import uk.ee.framework.elements.common.CheckBox;
import uk.ee.framework.elements.common.Link;
import uk.ee.framework.elements.common.TextBlock;
import uk.ee.framework.elements.webdriver_aware.CustomHtmlElement;
import uk.ee.framework.utils.Waiter;

/**
 * Created by Syamphaneendra Kalluri on 06/06/2016
 * Modified by prabhu_S on 07/13/2016
 * This class represents the selenium version of the Personal Details section.
 * 
 */
public class PersonalDetails extends CustomHtmlElement {

	@FindBy(css = "input#email")
	TextInput email;

	@FindBy(css = "select#title")
	Select title;

	@FindBy(css = "input#firstName")
	TextInput firstName;

	@FindBy(css = "input#initials")
	TextInput initial;

	@FindBy(css = "input#lastName")
	TextInput lastName;

	@FindBy(css = "input#contactNumber")
	TextInput contactNumber;

	@FindBy(css = "input#alternativeNumber")
	TextInput alternativeNumber;

	@FindBy(css = "select#dob_day")
	Select dob_day;

	@FindBy(css = "select#dob_month")
	Select dob_month;

	@FindBy(css = "select#dob_year")
	Select dob_year;

	@FindBy(css = "input#useDeliveryAddress")
	CheckBox useDeliveryAddress;

	@FindBy(css = "input#lookup_postcode_currentAddress")
	TextInput postcode;

	@FindBy(css = "a#link_lookup_postcode_currentAddress")
	Link findAddress;

	@FindBy(css = "input#companyName_currentAddress")
	TextInput companyName;

	@FindBy(css = "input#building_currentAddress")
	TextInput building;

	@FindBy(css = "input#street1_currentAddress")
	TextInput address1;

	@FindBy(css = "input#town_currentAddress")
	TextInput townName;

	@FindBy(css = "input#postCode_currentAddress")
	TextInput postCodeCurrentAddress;

	@FindBy(css = "select#currentAddressMonth")
	Select currentAddressMonth;

	@FindBy(css = "select#currentAddressYear")
	Select currentAddressYear;

	@FindBy(id = "employmentType")
	Select employmentType;

	@FindBy(css = "select#startMonthOfEmployment")
	Select startMonthOfEmployment;

	@FindBy(css = "select#startYearOfEmployment")
	Select startYearOfEmployment;

	@FindBy(css = "select#startMonthOfBank")
	Select startMonthOfBank;

	@FindBy(css = "select#startYearOfBank")
	Select startYearOfBank;

	@FindBy(css="select#addressList_currentAddress_select")
	Select addressList;

	@FindBy(css = "input.checkout-cta")
	Button nextStep;
	
	/*SB customer*/
	@FindBy(css="input#businessCompanyName")
	WebElement businessCompanyName;
	
	@FindBy(xpath="//input[@id='tradingName']")
	WebElement tradingName;
	
	@FindBy(css = "input#buildingNumber_deliveryAddress")
	WebElement houseNumber;
	@FindBy(css = "input#county_deliveryAddress")
	TextInput country;
	@FindBy(css = "input#buildingNumber_currentAddress")
	WebElement sbHouseNumber;
	@FindBy(css = "input#county_currentAddress")
	TextInput sbCountry;
	
	@FindBy(css = "span.ee-form-message.ee-form-message--active")
	TextBlock errorMsg;
	
	/**
	 * @param customerObj
	 */
	private void proceedBasicPersonalDetails(final Customer customerObj) {
		email.sendKeys(customerObj.getEmail());
		title.selectByValue(customerObj.getTitle());
		initial.sendKeys(customerObj.getInitial());
		firstName.sendKeys(customerObj.getFirstName());
		lastName.sendKeys(customerObj.getLastName());
		contactNumber.sendKeys(customerObj.getContactNumber());
		alternativeNumber.sendKeys(customerObj.getAlternativeNumber());
		dob_day.selectByValue(customerObj.getDob_day());
		dob_month.selectByValue(customerObj.getDob_month());
		dob_year.selectByValue(customerObj.getDob_year());
	}

	/**
	 * @param customerObj
	 */
	public void proceedPersonalDetails(final Customer customerObj) {
		proceedBasicPersonalDetails(customerObj);
		if ("true".equalsIgnoreCase(customerObj.getUseDeliveryAddress())) {
			useDeliveryAddress.set(Boolean.TRUE);
		} else {
			useDeliveryAddress.set(Boolean.FALSE);
		}
		/*
		 * postcode.sendKeys(customerObj.getPostcode());
		 * companyName.sendKeys(customerObj.getCompanyName());
		 * building.sendKeys(customerObj.getBuilding());
		 * address1.sendKeys(customerObj.getAddress1());
		 * townName.sendKeys(customerObj.getTownName());
		 * postCodeCurrentAddress.sendKeys(customerObj.getPostCodeCurrentAddress
		 * ());
		 */
		currentAddressMonth.selectByValue(customerObj.getCurrentAddressMonth());
		currentAddressYear.selectByValue(customerObj.getCurrentAddressYear());
		employmentType.selectByValue(customerObj.getEmploymentType());
		startMonthOfEmployment.selectByValue(customerObj.getStartMonthOfEmployment());
		startYearOfEmployment.selectByValue(customerObj.getStartYearOfEmployment());
		startMonthOfBank.selectByValue(customerObj.getStartMonthOfBank());
		startYearOfBank.selectByValue(customerObj.getStartYearOfBank());
		nextStep.click();
	}

	/**
	 * @param customerObj
	 */
	public void proceedPaygPersonalDetails(final Customer customerObj) {
		proceedBasicPersonalDetails(customerObj);
		if ("true".equalsIgnoreCase(customerObj.getUseDeliveryAddress())) {
			useDeliveryAddress.set(Boolean.TRUE);
		} else {
			useDeliveryAddress.set(Boolean.FALSE);
		}
		nextStep.click();
	}
	
	/**
	 * @param customerObj
	 */
	public void proceedSIMOPaygPersonalDetails(final Customer customerObj) {
		proceedBasicPersonalDetails(customerObj);
		selectPersonalAddress(customerObj.getPostcode());
		// Setting SIMO address
		/*postcode.sendKeys(customerObj.getPostcode());
		findAddress.click();
		addressList.selectByValue("2");*/
		nextStep.click();
	}

	/**
	 * @param customerObj
	 */
	
	
	public void proceedSIMOPersonalDetails(final Customer customerObj) {
		proceedBasicPersonalDetails(customerObj);
		//setting SIMO address
		postcode.sendKeys(customerObj.getPostcode());
		findAddress.click();		
		currentAddressMonth.selectByValue(customerObj.getCurrentAddressMonth());
		currentAddressYear.selectByValue(customerObj.getCurrentAddressYear());
		employmentType.selectByValue(customerObj.getEmploymentType());
		startMonthOfEmployment.selectByValue(customerObj.getStartMonthOfEmployment());
		startYearOfEmployment.selectByValue(customerObj.getStartYearOfEmployment());
		startMonthOfBank.selectByValue(customerObj.getStartMonthOfBank());
		startYearOfBank.selectByValue(customerObj.getStartYearOfBank());
		addressList.selectByIndex(1);
		nextStep.click();
	}

	public void proceedSBSoleTraderDetails(String postCode, final Customer customerObj) {
		businessCompanyName.sendKeys("Everything");
		tradingName.sendKeys("Everywhere");
		proceedBasicPersonalDetails(customerObj);
		selectSBAddress(customerObj.getPostcode());	
		currentAddressMonth.selectByValue(customerObj.getCurrentAddressMonth());
		currentAddressYear.selectByValue(customerObj.getCurrentAddressYear());
		employmentType.selectByValue(customerObj.getEmploymentType());
		startMonthOfEmployment.selectByValue(customerObj.getStartMonthOfEmployment());
		startYearOfEmployment.selectByValue(customerObj.getStartYearOfEmployment());
		startMonthOfBank.selectByValue(customerObj.getStartMonthOfBank());
		startYearOfBank.selectByValue(customerObj.getStartYearOfBank());
		nextStep.click();
	}
	
	public void selectPersonalAddress(final String postCode) {
		try {
			postcode.sendKeys(postCode);
			findAddress.click();
			if (houseNumber.isDisplayed()) {
				houseNumber.sendKeys("2");
				address1.sendKeys("Marsh Layne");
				townName.sendKeys("Leeds");
				country.sendKeys("UK");
			} else {
				addressList.selectByIndex(2);
			}
		} catch (NoSuchElementException e) {
			addressList.selectByIndex(2);
		}
	}
	
	public void selectSBAddress(final String postCode) {
		try {
			postcode.sendKeys(postCode);
			findAddress.click();
			System.out.println("errorMsg.isDisplayed()" + errorMsg.isDisplayed());
			webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("houseNumber.isDisplayed()" + houseNumber.isDisplayed());
			if (sbHouseNumber.isDisplayed()) {
				sbHouseNumber.sendKeys("2");
				address1.sendKeys("Marsh Layne");
				townName.sendKeys("Leeds");
				sbCountry.sendKeys("UK");
				
			} else {
				addressList.selectByIndex(2);	
			}
		} catch (NoSuchElementException e) {
			addressList.selectByIndex(2);	
		}
	}
	
	public void continueToNext()
	{
		nextStep.click();
	}

}
