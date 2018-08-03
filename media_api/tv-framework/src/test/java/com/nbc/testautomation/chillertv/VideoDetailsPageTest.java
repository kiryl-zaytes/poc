package com.nbc.testautomation.chillertv;

import com.nbc.testautomation.chillertv.businessobject.Video;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Add retrieving long description and source URL from UI after merging of corresponding locators
 */
public class VideoDetailsPageTest extends BaseTest {

    public static final String VIDEO_ID = "1";

    @DataProvider(name = "videoDataProvider")
    public Object[][] getVideoData() {
        Video video = videoRepository.getById(VIDEO_ID);

        return new Object[][]{
                {video}
        };
    }

    @Test(dataProvider = "videoDataProvider")
    public void verifyVideoDetails(Video expectedVideo) {
        Video actualVideo = videoUiService.getVideoById(VIDEO_ID);
        Assert.assertEquals(actualVideo, expectedVideo);
    }

}
