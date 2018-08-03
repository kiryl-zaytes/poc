package com.nbc.testautomation.chillertv;

import com.nbc.testautomation.chillertv.businessobject.Series;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SeriesDetailsPageTest extends BaseTest {

    public static final String SERIES_ID = "47157e94-0ae8-43c6-8185-7b8083548b1b";

    @DataProvider(name = "seriesDataProvider")
    public Object[][] getSeriesData() {
        Series series = seriesRepository.getById(SERIES_ID);

        return new Object[][]{
                {series}
        };
    }

    @Test(dataProvider = "seriesDataProvider")
    public void verifySeriesDetails(Series expectedSeries) {
        Series actualSeries = seriesUiService.getSeriesById(SERIES_ID);

        Assert.assertEquals(actualSeries, expectedSeries);
    }
}
