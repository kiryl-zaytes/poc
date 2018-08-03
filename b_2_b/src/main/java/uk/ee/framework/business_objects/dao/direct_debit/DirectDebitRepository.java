package uk.ee.framework.business_objects.dao.direct_debit;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Prabhu S on 5/10/16.
 */
public interface DirectDebitRepository extends CrudRepository<DirectDebit, Long> {
    DirectDebit findByTagsLike(String tags);
    DirectDebit findById(int id);
}
