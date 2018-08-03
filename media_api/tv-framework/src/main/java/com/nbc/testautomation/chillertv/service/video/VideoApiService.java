package com.nbc.testautomation.chillertv.service.video;

import com.nbc.testautomation.chillertv.businessobject.Video;
import com.nbc.testautomation.chillertv.support.api.BaseApiService;
import com.nbc.testautomation.chillertv.support.ObjectConverter;
import com.nbc.testautomation.chillertv.support.api.pojo.VideoDetails;
import com.nbc.testautomation.reporting.logging.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link VideoService} for retrieving the data about video from API
 */
@Component
@Scope("prototype")
public class VideoApiService extends BaseApiService implements VideoService {

    protected final Logger LOGGER = new Logger(VideoApiService.class);

    public Video getVideoById(String videoId) {
        LOGGER.info(String.format("Requesting video {ID: %s}", videoId));

        String path = String.format(apiEndpoints.getVideoDetails(), videoId);

        VideoDetails videoDetails = httpProvider.get(environmentConfiguration.getApiHost(), path, VideoDetails.class);

        return new ObjectConverter().toVideo(videoDetails);
    }
}
