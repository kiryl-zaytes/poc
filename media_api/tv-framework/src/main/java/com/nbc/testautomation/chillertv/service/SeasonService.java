package com.nbc.testautomation.chillertv.service;

import com.nbc.testautomation.chillertv.businessobject.Season;

/**
 * Service for retrieving the data about season via UI or API
 */
public interface SeasonService {

    Season getSeasonById(String seasonId, String seriesId);
}
