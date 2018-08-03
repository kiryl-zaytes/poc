package com.nbc.testautomation.chillertv.data;

import com.nbc.testautomation.chillertv.businessobject.Season;
import com.nbc.testautomation.chillertv.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;

public class ApiSeasonRepository implements SeasonRepository {

    @Autowired
    protected SeasonService seasonApiService;

    public Season getById(String seasonId, String seriesId) {
        return seasonApiService.getSeasonById(seasonId, seriesId);
    }
}
