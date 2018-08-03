package uk.ee.framework.business_objects.dao.billing_details;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Syamphaneendra Kalluri on 06/15/2016
 * 
 * This class acts as a Domain object for BillingDetails.
 */
@Entity
@Table(name = "BILLING_DETAILS")
public class BillingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "SORT_CODE1")
	private String sortCode1;

	@Column(name = "SORT_CODE2")
	private String sortCode2;

	@Column(name = "SORT_CODE3")
	private String sortCode3;

	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;

	@Column(name = "ACCOUNT_NAME")
	private String accountName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSortCode1() {
		return sortCode1;
	}

	public void setSortCode1(String sortCode1) {
		this.sortCode1 = sortCode1;
	}

	public String getSortCode2() {
		return sortCode2;
	}

	public void setSortCode2(String sortCode2) {
		this.sortCode2 = sortCode2;
	}

	public String getSortCode3() {
		return sortCode3;
	}

	public void setSortCode3(String sortCode3) {
		this.sortCode3 = sortCode3;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

}
