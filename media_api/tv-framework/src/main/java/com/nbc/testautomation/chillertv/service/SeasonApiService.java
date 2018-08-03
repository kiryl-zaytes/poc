package com.nbc.testautomation.chillertv.service;

import com.nbc.testautomation.chillertv.businessobject.Season;
import com.nbc.testautomation.chillertv.support.ObjectConverter;
import com.nbc.testautomation.chillertv.support.api.BaseApiService;
import com.nbc.testautomation.chillertv.support.api.pojo.season.SeasonDetails;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link SeasonService} for retrieving the data about season from API
 */
@Component
@Scope("prototype")
public class SeasonApiService extends BaseApiService implements SeasonService {

    public Season getSeasonById(String seasonId, String seriesID) {
        String path = String.format(apiEndpoints.getSeasonDetails(), seasonId, seriesID);

        SeasonDetails seasonDetails = httpProvider.get(environmentConfiguration.getApiHost(), path, SeasonDetails.class);
        return new ObjectConverter().toSeason(seasonDetails);
    }
}
