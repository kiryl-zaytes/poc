package com.nbc.testautomation.chillertv.service.series;

import com.nbc.testautomation.chillertv.businessobject.Series;
import com.nbc.testautomation.chillertv.support.ObjectConverter;
import com.nbc.testautomation.chillertv.support.api.BaseApiService;
import com.nbc.testautomation.chillertv.support.api.pojo.SeriesDetails;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link SeriesService} for retrieving the data about series from API
 */
@Component
@Scope("prototype")
public class SeriesApiService extends BaseApiService implements SeriesService {

    public Series getSeriesById(String seriesId) {
        String path = String.format(apiEndpoints.getSeriesDetails(), seriesId);

        SeriesDetails seriesDetails = httpProvider.get(environmentConfiguration.getApiHost(), path, SeriesDetails.class);

        return new ObjectConverter().toSeries(seriesDetails);

    }
}
