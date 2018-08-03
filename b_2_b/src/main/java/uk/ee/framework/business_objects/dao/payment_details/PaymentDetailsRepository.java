package uk.ee.framework.business_objects.dao.payment_details;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Syamphaneendra Kalluri on 06/15/2016
 * 
 * This class acts as a implementation class for PaymentDetails.
 */
public interface PaymentDetailsRepository extends CrudRepository<PaymentDetails, Long> {

	/**
	 * This method is used save the PaymentDetails data.
	 * 
	 */
	PaymentDetails save(PaymentDetails paymentDetailsObj);

	/**
	 * This method is used to find the PaymentDetails data based on Id.
	 * 
	 * @param id
	 * @return
	 */
	PaymentDetails findById(long id);
}
