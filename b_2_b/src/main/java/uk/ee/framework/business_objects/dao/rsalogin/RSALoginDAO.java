package uk.ee.framework.business_objects.dao.rsalogin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Syamphaneendra Kalluri on 06/29/2016
 * 
 * This class acts as a Domain object for RSALoginDAO.
 */

@Entity
@Table(name = "RSA_LOGIN")
public class RSALoginDAO {
	@Id
	@Column(name = "EMPLOYEE_ID")
	private String employeeId;

	@Column(name = "STORE_ID")
	private String storeId;

	@Column(name = "STORE_COMM_CODE")
	private String storeCommCode;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreCommCode() {
		return storeCommCode;
	}

	public void setStoreCommCode(String storeCommCode) {
		this.storeCommCode = storeCommCode;
	}

}
