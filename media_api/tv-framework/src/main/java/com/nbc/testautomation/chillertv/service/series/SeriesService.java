package com.nbc.testautomation.chillertv.service.series;

import com.nbc.testautomation.chillertv.businessobject.Series;

/**
 * Service for retrieving the data about series via UI or API
 */
public interface SeriesService {

    Series getSeriesById(String seriesId);
}
