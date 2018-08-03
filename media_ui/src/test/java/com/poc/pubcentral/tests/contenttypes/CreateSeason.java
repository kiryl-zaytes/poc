package com.poc.pubcentral.tests.contenttypes;

import com.poc.pubcentral.bo.SeasonPojo;
import com.poc.pubcentral.page.content.Season;
import com.poc.pubcentral.tests.base.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by kiryl_zayets on 10/27/15.
 */
public class CreateSeason extends BaseTest {

    @Autowired Season season;

    @Test
    public void createSeason() {
        SeasonPojo seasonPojo = dao.getById(SeasonPojo.class, 1);
        String message = season.create(seasonPojo);
        Assert.assertEquals("Status message\nSeason " + seasonPojo.getTitle() +
                " has been created.", message);
    }
}
