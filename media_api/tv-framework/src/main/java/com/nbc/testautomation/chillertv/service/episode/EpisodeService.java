package com.nbc.testautomation.chillertv.service.episode;

import com.nbc.testautomation.chillertv.businessobject.Episode;

/**
 * Service for retrieving the data about Episode via UI or API
 */
public interface EpisodeService {

    Episode getEpisodeById(String episodeId, String seriesId);
}
