package com.nbc.testautomation.chillertv.data;

import com.nbc.testautomation.chillertv.businessobject.Video;
import com.nbc.testautomation.chillertv.service.video.VideoService;
import org.springframework.beans.factory.annotation.Autowired;

public class ApiVideoRepository implements VideoRepository {

    @Autowired
    protected VideoService videoApiService;

    public Video getById(String id) {
        return videoApiService.getVideoById(id);
    }
}
