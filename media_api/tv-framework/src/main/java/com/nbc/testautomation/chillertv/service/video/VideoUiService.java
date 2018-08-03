package com.nbc.testautomation.chillertv.service.video;

import com.nbc.testautomation.chillertv.businessobject.Video;
import com.nbc.testautomation.chillertv.page.VideoDetailsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link VideoService} for retrieving the data about video from UI
 */
@Component
@Scope("prototype")
public class VideoUiService implements VideoService {

    @Autowired
    protected VideoDetailsPage videoDetailsPage;

    public Video getVideoById(String videoId) {
        videoDetailsPage.navigate(videoId);

        Video video = new Video();
        video.setId(videoId);
        video.setTitle(videoDetailsPage.getVideoTitle().getText());
        video.setLongDescription(videoDetailsPage.getVideoLongDescription().getText());
        video.setVideoUrl(videoDetailsPage.getVideoSrc());

        return video;
    }
}
