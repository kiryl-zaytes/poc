package com.poc.pubcentral.tests.contenttypes;

import com.poc.pubcentral.bo.*;
import com.poc.pubcentral.bo.dao.DAO;
import com.poc.pubcentral.tests.base.BaseTest;
import com.poc.pubcentral.page.content.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Test channel reference piece of content.
 * Creates several content types (series, event, season, episode and image)
 * Checks mapping for Season -> Series, Season -> Event, Episode -> Series + Event
 * Image -> Series + Season + Episode.
 * Checks node id's after each CT is created to be sure that mapping took place.
 */
public class MappingPieceOfContent extends BaseTest {

    @Autowired Series series;
    @Autowired Event event;
    @Autowired Season season;
    @Autowired Episode episode;
    @Autowired Image image;
    @Autowired ContentList contentList;
    @Autowired DAO dao;

    SeriesPojo seriesPojo;
    EventPojo eventPojo;
    SeasonPojo seasonPojo;
    EpisodePojo episodePojo;

    @BeforeClass
    public void createContent() {
        seriesPojo = dao.getById(SeriesPojo.class, 3);
        eventPojo = dao.getById(EventPojo.class, 1);
        seasonPojo = dao.getById(SeasonPojo.class, 1);
        episodePojo = dao.getById(EpisodePojo.class, 1);
        series.create(seriesPojo);
        seriesPojo.setNodeNumber(series.getNodeId());
        event.create(eventPojo);
        eventPojo.setNodeNumber(event.getNodeId());
    }

    @Test(description = "Verify mapping SEASON -> SERIES", priority = 1)
    public void mapSeriesToSeason () {
        seasonPojo.setProgramReference(seriesPojo.getTitle());
        String message = season.create(seasonPojo);
        Assert.assertEquals(
                "Status message\nSeason " + seasonPojo.getTitle() +
                        " has been created.", message);
        Assert.assertEquals(seriesPojo.getNodeNumber(), season.getChannelReferenceSuquence());
        contentList.delete(seasonPojo);
    }

    @Test(description = "Verify mapping SEASON -> EVENT", priority = 2)
    public void mapEventToSeason () {
        seasonPojo.setProgramReference(eventPojo.getTitle());
        String message = season.create(seasonPojo);
        seasonPojo.setNodeNumber(season.getNodeId());
        Assert.assertEquals(
                "Status message\nSeason " + seasonPojo.getTitle() +
                        " has been created.", message);
        Assert.assertEquals(eventPojo.getNodeNumber(), season.getChannelReferenceSuquence());
    }

    @Test(description = "Verify mapping EPISODE -> SERIES -> SEASON", priority = 3)
    public void mapEpisodeToSeries() {
        episodePojo.setSeriesReference(seriesPojo.getTitle());
        episodePojo.setSeasonReference(seasonPojo.getTitle());
        String message = episode.create(episodePojo);
        episodePojo.setNodeNumber(seriesPojo.getNodeNumber()+seasonPojo.getNodeNumber());
        Assert.assertEquals(
                "Status message\nEpisode " + episodePojo.getTitle() +
                        " has been created.", message);
        Assert.assertEquals(episodePojo.getNodeNumber(), episode.getChannelReferenceSuquence());
        episodePojo.setNodeNumber(episodePojo.getNodeNumber() + episode.getNodeId());
    }

    @Test(description = "Verify mapping IMAGE --> Series + Season + Episode", priority = 4)
    public void mapImageToSeries(){
        ImagePojo imgPojo = dao.getById(ImagePojo.class, 1);
        imgPojo.setSeries(seriesPojo.getTitle());
        imgPojo.setSeason(seasonPojo.getTitle());
        imgPojo.setEpisode(episodePojo.getTitle());
        imgPojo.setNodeNumber(episodePojo.getNodeNumber());
        image.create(imgPojo);
        Assert.assertEquals(imgPojo.getNodeNumber(), image.getChannelReferenceSuquence());
    }
}
