package com.poc.pubcentral.bo.dao;


import com.poc.pubcentral.bo.BaseType;
import com.poc.pubcentral.bo.dao.interfaces.ContentType;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by kiryl_zayets on 10/23/15.
 */

@Component
public class DAO {

    @Autowired @Qualifier(value = "uniqueLaunchId") protected String uniqueId;
    @Autowired
    private SessionFactory sessionFactory;

    public DAO() {}

    ;

    @Transactional
    public <T extends ContentType> T getById(Class<T> bo, int id) {
        Criteria criteria = sessionFactory.openStatelessSession()
                .createCriteria(bo);
        BaseType ct = (BaseType) bo.cast(criteria.add(Restrictions.eq("id",
                id)).list()
                .get(0));
        ct.setTitle(ct.getTitle() + uniqueId);
        return bo.cast(ct);
    }
}
