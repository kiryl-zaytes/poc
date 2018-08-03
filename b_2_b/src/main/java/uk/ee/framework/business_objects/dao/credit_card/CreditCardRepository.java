package uk.ee.framework.business_objects.dao.credit_card;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by kiryl_zayets on 5/2/16.
 */
public interface CreditCardRepository extends CrudRepository<CreditCard, Long> {
    CreditCard findByTagsLike(String tags);
    CreditCard findById(int id);
}
