package com.nbc.testautomation.chillertv.service.series;

import com.nbc.testautomation.chillertv.businessobject.Series;
import com.nbc.testautomation.chillertv.page.SeriesDetailsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link SeriesService} for retrieving the data about series from UI
 */
@Component
@Scope("prototype")
public class SeriesUiService implements SeriesService {

    @Autowired
    protected SeriesDetailsPage seriesDetailsPage;

    public Series getSeriesById(String seriesId) {
        String seriesTitle;
        String seriesImage;
        String seriesLongDescription;

        seriesDetailsPage.navigate(seriesId);
        seriesTitle = seriesDetailsPage.getSeriesDetailsBlock().getSeriesTitle().getText();
        seriesImage = seriesDetailsPage.getSeriesDetailsBlock().getSeriesImage().getSource().toString();
        seriesLongDescription = seriesDetailsPage.getSeriesDetailsBlock().getSeriesLongDescription().getText();

        Series series = new Series();
        series.setId(seriesId);
        series.setSeriesTitle(seriesTitle);
        series.setImageUrl(seriesImage);
        series.setLongDescription(seriesLongDescription);

        return series;
    }
}
