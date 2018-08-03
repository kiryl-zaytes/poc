package com.nbc.testautomation.chillertv;

import com.nbc.testautomation.chillertv.businessobject.Episode;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EpisodeDetailsPageTest extends BaseTest {

    public static final String EPISODE_ID = "1";
    public static final String SERIES_ID = "1";

    @DataProvider(name = "episodeDataProvider")
    public Object[][] getEpisodeData() {
        Episode episode = episodeRepository.getById(EPISODE_ID, SERIES_ID);

        return new Object[][]{
                {episode}
        };
    }

    @Test(dataProvider = "episodeDataProvider")
    public void verifyEpisodeDetails(Episode expectedEpisode) {


        Episode actualEpisode = episodeUiService.getEpisodeById(EPISODE_ID, SERIES_ID);

        Assert.assertEquals(actualEpisode, expectedEpisode);
    }

}
