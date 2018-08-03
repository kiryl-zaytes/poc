package com.nbc.testautomation.chillertv.data;

import com.nbc.testautomation.chillertv.businessobject.Episode;
import com.nbc.testautomation.chillertv.service.episode.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;

public class ApiEpisodeRepository implements EpisodeRepository {

    @Autowired
    protected EpisodeService episodeApiService;

    public Episode getById(String seriesId, String episodeId) {
        return episodeApiService.getEpisodeById(seriesId, episodeId);
    }
}
