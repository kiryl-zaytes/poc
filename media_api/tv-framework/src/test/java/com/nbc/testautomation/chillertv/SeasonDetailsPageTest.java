package com.nbc.testautomation.chillertv;

import com.nbc.testautomation.chillertv.businessobject.Season;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SeasonDetailsPageTest extends BaseTest {

    public static final String SEASON_ID = "47157e94-0ae8-43c6-8185-7b8083548b1b";

    public static final String SERIES_ID = "47157e94-0ae8-43c6-8185-7b8083548b1b";

    @DataProvider(name = "seasonDataProvider")
    public Object[][] getSeasonData() {
        Season season = seasonRepository.getById(SEASON_ID, SERIES_ID);

        return new Object[][]{
                {season}
        };
    }

    @Test(dataProvider = "seasonDataProvider")
    public void verifySeasonDetails(Season expectedSeason) {

        Season actualSeason = seasonUiService.getSeasonById(SEASON_ID, SERIES_ID);

        Assert.assertEquals(actualSeason, expectedSeason);
    }


}
