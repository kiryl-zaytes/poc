package uk.ee.framework.business_objects.dao.payment_details;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Syamphaneendra Kalluri on 06/15/2016
 * 
 * This class acts as a Domain object for PaymentDetails.
 */
@Entity
@Table(name = "PAYMENT_DETAILS")
public class PaymentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CARD_TYPE")
	private String cardType;

	@Column(name = "NAME_ON_CARD")
	private String nameOnCard;

	@Column(name = "CARD_NUM")
	private String cardNumber;

	@Column(name = "START_DATE_MONTH")
	private String startDateMonth;

	@Column(name = "START_DATE_YEAR")
	private String startDateYear;

	@Column(name = "EXPIRY_DATE_MONTH")
	private String expiryDateMonth;

	@Column(name = "EXPIRY_DATE_YEAR")
	private String expiryDateYear;

	@Column(name = "ISSUE_NUMBER")
	private String issueNumber;

	@Column(name = "CARD_SECURITY_CODE")
	private String cardSecurityCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getStartDateMonth() {
		return startDateMonth;
	}

	public void setStartDateMonth(String startDateMonth) {
		this.startDateMonth = startDateMonth;
	}

	public String getStartDateYear() {
		return startDateYear;
	}

	public void setStartDateYear(String startDateYear) {
		this.startDateYear = startDateYear;
	}

	public String getExpiryDateMonth() {
		return expiryDateMonth;
	}

	public void setExpiryDateMonth(String expiryDateMonth) {
		this.expiryDateMonth = expiryDateMonth;
	}

	public String getExpiryDateYear() {
		return expiryDateYear;
	}

	public void setExpiryDateYear(String expiryDateYear) {
		this.expiryDateYear = expiryDateYear;
	}

	public String getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(String issueNumber) {
		this.issueNumber = issueNumber;
	}

	public String getCardSecurityCode() {
		return cardSecurityCode;
	}

	public void setCardSecurityCode(String cardSecurityCode) {
		this.cardSecurityCode = cardSecurityCode;
	}

}
