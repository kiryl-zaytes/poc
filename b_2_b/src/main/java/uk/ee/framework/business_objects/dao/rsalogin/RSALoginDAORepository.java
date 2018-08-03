package uk.ee.framework.business_objects.dao.rsalogin;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Syamphaneendra Kalluri on 06/29/2016
 * 
 * This class acts as a implementation class for RSALoginDAO.
 */

public interface RSALoginDAORepository extends CrudRepository<RSALoginDAO, String> {

	/**
	 * This method is used save the RSA Login data.
	 * 
	 */
	RSALoginDAO save(RSALoginDAO customerObj);

	/**
	 * This method is used to find the RSA Login data based on employeeId.
	 * 
	 * @param employeeId
	 * @return
	 */
	RSALoginDAO findByEmployeeId(String employeeId);
}
