package com.nbc.testautomation.chillertv.data;

import com.nbc.testautomation.chillertv.businessobject.Series;
import com.nbc.testautomation.chillertv.service.series.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;

public class ApiSeriesRepository implements SeriesRepository {

    @Autowired
    protected SeriesService seriesApiService;

    public Series getById(String id) {
        return seriesApiService.getSeriesById(id);
    }
}
