package uk.ee.framework.business_objects.dao.customer;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Syamphaneendra Kalluri on 06/15/2016
 * <p>
 * This acts as a implementation class for CustomerType.
 *
 * This acts as a implementation class for Customer.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    /**
     * This method is used save the CustomerType data.
     */
    Customer save(Customer customerObj);

    /**
     * This method is used to find the CustomerType data based on Id.
     *
     * @param id
     * @return
     */
    Customer findById(long id);
}
