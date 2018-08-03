package com.nbc.testautomation.chillertv.data;

import com.nbc.testautomation.chillertv.businessobject.Episode;

/**
 * Interface for provide functionality of retrieving test data from some storage: in-memory database, text file,
 * comma-separated file (CSV), Google Sheet, etc.
 */
public interface EpisodeRepository {

    Episode getById(String seriesId, String episodeId);

}
