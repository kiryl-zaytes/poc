package com.nbc.testautomation.chillertv.service.episode;

import com.nbc.testautomation.chillertv.businessobject.Episode;
import com.nbc.testautomation.chillertv.support.ObjectConverter;
import com.nbc.testautomation.chillertv.support.api.pojo.EpisodeDetails;
import org.springframework.context.annotation.Scope;
import com.nbc.testautomation.chillertv.support.api.BaseApiService;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link EpisodeService} for retrieving the data about Episode from API
 */
@Component
@Scope("prototype")
public class EpisodeApiService extends BaseApiService implements EpisodeService {

    public Episode getEpisodeById(String episodeId, String seriesId) {

        String path = String.format(apiEndpoints.getEpisodeDetails(), episodeId, seriesId);

        EpisodeDetails episodeDetails = httpProvider.get(environmentConfiguration.getApiHost(), path, EpisodeDetails.class);

        return new ObjectConverter().toEpisode(episodeDetails);
    }
}
