package com.nbc.testautomation.chillertv.data;

import com.nbc.testautomation.chillertv.businessobject.Season;


/**
 * Interface for provide functionality of retrieving test data from some storage: in-memory database, text file,
 * comma-separated file (CSV), Google Sheet, etc.
 */
public interface SeasonRepository {

    Season getById(String seasonId, String seriesId);
}
