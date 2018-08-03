package com.poc.pubcentral.tests.contenttypes;

import com.poc.pubcentral.bo.EventPojo;
import com.poc.pubcentral.page.content.Event;
import com.poc.pubcentral.tests.base.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by kiryl_zayets on 10/19/15.
 */
public class CreateEvent extends BaseTest {

    @Autowired Event event;

    @Test(groups = {"ct", "regression"})
    public void createEvent() {
        EventPojo eventPojoBO = dao.getById(EventPojo.class, 1);
        String message = event.create(eventPojoBO);
        Assert.assertEquals("Status message\nEvent " + eventPojoBO.getTitle() +
                " has been created.", message);
    }
}
