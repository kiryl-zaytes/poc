package com.poc.pubcentral.tests.contenttypes;

import com.poc.pubcentral.bo.SeriesPojo;
import com.poc.pubcentral.page.content.Series;
import com.poc.pubcentral.tests.base.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by kiryl_zayets on 10/11/15.
 */

public class CreateSeries extends BaseTest {
    @Autowired Series series;

    @Test(groups = {"ct", "regression"})
    public void createSeries() {
        SeriesPojo seriesPojoBO = dao.getById(SeriesPojo.class, 3);
        String message = series.create(seriesPojoBO);
        Assert.assertEquals(
                "Status message\nSeries " + seriesPojoBO.getTitle() +
                        " has been created.", message);
    }
}
