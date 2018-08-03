package uk.ee.framework.business_objects.dao.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Syamphaneendra Kalluri on 06/15/2016
 * 
 * This class acts as a Domain object for customer.
 */

@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "INITIAL")
	private String initial;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;

	@Column(name = "ALTERNATIVE_NUMBER")
	private String alternativeNumber;

	@Column(name = "DOB_DAY")
	private String dob_day;

	@Column(name = "DOB_MONTH")
	private String dob_month;

	@Column(name = "DOB_YEAR")
	private String dob_year;

	@Column(name = "USE_DELIVERY_ADDRESS")
	private String useDeliveryAddress;

	@Column(name = "POSTCODE")
	private String postcode;

	@Column(name = "COMPANY_NAME")
	private String companyName;

	@Column(name = "BUILDING")
	private String building;

	@Column(name = "ADDRESS1")
	private String address1;

	@Column(name = "TOWN_NAME")
	private String townName;

	@Column(name = "POSTCODE_CURRENT_ADDRESS")
	private String postCodeCurrentAddress;

	@Column(name = "CURRENT_ADD_MON")
	private String currentAddressMonth;

	@Column(name = "CURRENT_ADD_YEAR")
	private String currentAddressYear;

	@Column(name = "EMP_TYPE")
	private String employmentType;

	@Column(name = "START_MON_EMP")
	private String startMonthOfEmployment;

	@Column(name = "START_YEAR_EMP")
	private String startYearOfEmployment;

	@Column(name = "START_MON_BANK")
	private String startMonthOfBank;

	@Column(name = "START_YEAR_BANK")
	private String startYearOfBank;

	/**
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return
	 */
	public String getInitial() {
		return initial;
	}

	/**
	 * @param initial
	 */
	public void setInitial(String initial) {
		this.initial = initial;
	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return
	 */
	public String getAlternativeNumber() {
		return alternativeNumber;
	}

	/**
	 * @param alternativeNumber
	 */
	public void setAlternativeNumber(String alternativeNumber) {
		this.alternativeNumber = alternativeNumber;
	}

	/**
	 * @return
	 */
	public String getDob_day() {
		return dob_day;
	}

	/**
	 * @param dob_day
	 */
	public void setDob_day(String dob_day) {
		this.dob_day = dob_day;
	}

	/**
	 * @return
	 */
	public String getDob_month() {
		return dob_month;
	}

	/**
	 * @param dob_month
	 */
	public void setDob_month(String dob_month) {
		this.dob_month = dob_month;
	}

	/**
	 * @return
	 */
	public String getDob_year() {
		return dob_year;
	}

	/**
	 * @param dob_year
	 */
	public void setDob_year(String dob_year) {
		this.dob_year = dob_year;
	}

	/**
	 * @return
	 */
	public String getUseDeliveryAddress() {
		return useDeliveryAddress;
	}

	/**
	 * @param useDeliveryAddress
	 */
	public void setUseDeliveryAddress(String useDeliveryAddress) {
		this.useDeliveryAddress = useDeliveryAddress;
	}

	/**
	 * @return
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * @return
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return
	 */
	public String getBuilding() {
		return building;
	}

	/**
	 * @param building
	 */
	public void setBuilding(String building) {
		this.building = building;
	}

	/**
	 * @return
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param address1
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * @return
	 */
	public String getTownName() {
		return townName;
	}

	/**
	 * @param townName
	 */
	public void setTownName(String townName) {
		this.townName = townName;
	}

	/**
	 * @return
	 */
	public String getPostCodeCurrentAddress() {
		return postCodeCurrentAddress;
	}

	/**
	 * @param postCodeCurrentAddress
	 */
	public void setPostCodeCurrentAddress(String postCodeCurrentAddress) {
		this.postCodeCurrentAddress = postCodeCurrentAddress;
	}

	/**
	 * @return
	 */
	public String getCurrentAddressMonth() {
		return currentAddressMonth;
	}

	/**
	 * @param currentAddressMonth
	 */
	public void setCurrentAddressMonth(String currentAddressMonth) {
		this.currentAddressMonth = currentAddressMonth;
	}

	/**
	 * @return
	 */
	public String getCurrentAddressYear() {
		return currentAddressYear;
	}

	/**
	 * @param currentAddressYear
	 */
	public void setCurrentAddressYear(String currentAddressYear) {
		this.currentAddressYear = currentAddressYear;
	}

	/**
	 * @return
	 */
	public String getEmploymentType() {
		return employmentType;
	}

	/**
	 * @param employmentType
	 */
	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	/**
	 * @return
	 */
	public String getStartMonthOfEmployment() {
		return startMonthOfEmployment;
	}

	/**
	 * @param startMonthOfEmployment
	 */
	public void setStartMonthOfEmployment(String startMonthOfEmployment) {
		this.startMonthOfEmployment = startMonthOfEmployment;
	}

	/**
	 * @return
	 */
	public String getStartYearOfEmployment() {
		return startYearOfEmployment;
	}

	/**
	 * @param startYearOfEmployment
	 */
	public void setStartYearOfEmployment(String startYearOfEmployment) {
		this.startYearOfEmployment = startYearOfEmployment;
	}

	/**
	 * @return
	 */
	public String getStartMonthOfBank() {
		return startMonthOfBank;
	}

	/**
	 * @param startMonthOfBank
	 */
	public void setStartMonthOfBank(String startMonthOfBank) {
		this.startMonthOfBank = startMonthOfBank;
	}

	/**
	 * @return
	 */
	public String getStartYearOfBank() {
		return startYearOfBank;
	}

	/**
	 * @param startYearOfBank
	 */
	public void setStartYearOfBank(String startYearOfBank) {
		this.startYearOfBank = startYearOfBank;
	}

}
