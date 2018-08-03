package com.nbc.testautomation.chillertv.service.video;

import com.nbc.testautomation.chillertv.businessobject.Video;

/**
 * Service for retrieving the data about video via UI or API
 */
public interface VideoService {

    Video getVideoById(String videoId);
}
