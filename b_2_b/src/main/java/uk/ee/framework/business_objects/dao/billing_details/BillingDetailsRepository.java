package uk.ee.framework.business_objects.dao.billing_details;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Syamphaneendra Kalluri on 06/15/2016
 * 
 * This acts as a implementation class for BillingDetails.
 */
public interface BillingDetailsRepository extends CrudRepository<BillingDetails, Long> {

	/**
	 * This method is used save the BillingDetails data.
	 * 
	 */
	BillingDetails save(BillingDetails billingDetailsObj);

	/**
	 * This method is used to find the BillingDetails data based on Id.
	 * 
	 * @param id
	 * @return
	 */
	BillingDetails findById(long id);
}
