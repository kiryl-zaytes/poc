package com.nbc.testautomation.chillertv.service;

import com.nbc.testautomation.chillertv.businessobject.Episode;
import com.nbc.testautomation.chillertv.businessobject.Season;
import com.nbc.testautomation.chillertv.page.EpisodeDetailsThumbnailBlock;
import com.nbc.testautomation.chillertv.page.SeasonDetailsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link SeasonService} for retrieving the data about season from UI
 */
@Component
@Scope("prototype")
public class SeasonUiService implements SeasonService{

    @Autowired
    protected SeasonDetailsPage seasonDetailsPage;


    public Season getSeasonById(String seasonId, String seriesId) {
        String seasonTitle;
        Set<Episode> episodes = new HashSet<Episode>();

        seasonDetailsPage.navigate(seasonId, seriesId);

        seasonTitle = seasonDetailsPage.getSeasonDetailsBlock().getSeasonTitle().getText();

        for (EpisodeDetailsThumbnailBlock episodeDetailsThumbnailBlock : seasonDetailsPage.getSeasonDetailsBlock().getEpisodeDetailsThumbnailBlock()) {
            Episode episode = new Episode();

            episode.setTitle(episodeDetailsThumbnailBlock.getEpisodeTitle().getText());
            episode.setShortDescription(episodeDetailsThumbnailBlock.getEpisodeShortDescriptions().getText());
            episode.setImageUrl(episodeDetailsThumbnailBlock.getEpisodeImage().getSource().toString());

            episodes.add(episode);
        }

        Season season = new Season();
        season.setId(seasonId);
        season.setTitle(seasonTitle);
        season.setEpisodes(episodes);

        return season;
    }

}
