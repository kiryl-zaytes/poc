package uk.ee.framework.business_objects.dao.user;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by kiryl_zayets on 5/2/16.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByTagsLike(String tags);
    User findById(int id);
}
