package com.nbc.testautomation.chillertv.service.episode;

import com.nbc.testautomation.chillertv.businessobject.Episode;
import com.nbc.testautomation.chillertv.page.EpisodeDetailsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link EpisodeService} for retrieving the data about episode details from UI
 */
@Component
@Scope("prototype")
public class EpisodeUiService implements EpisodeService {

    @Autowired
    protected EpisodeDetailsPage episodeDetailsPage;


    public Episode getEpisodeById(String episodeId, String seriesId) {
        String episodeTitle;
        String episodeSubHeading;
        String episodeImage;
        String episodeLongDescription;

        episodeDetailsPage.navigate(episodeId, seriesId);
        episodeTitle = episodeDetailsPage.getEpisodeDetailsBlock().getEpisodeTitle().getText();
        episodeSubHeading = episodeDetailsPage.getEpisodeDetailsBlock().getEpisodeSubHeading().getText();
        episodeImage = episodeDetailsPage.getEpisodeDetailsBlock().getEpisodeImage().getSource().toString();
        episodeLongDescription = episodeDetailsPage.getEpisodeDetailsBlock().getEpisodeLongDescription().getText();

        Episode episode = new Episode();
        episode.setId(episodeId);
        episode.setTitle(episodeTitle);
        episode.setImageUrl(episodeImage);
        episode.setLongDescription(episodeLongDescription);

        return episode;
    }
}
