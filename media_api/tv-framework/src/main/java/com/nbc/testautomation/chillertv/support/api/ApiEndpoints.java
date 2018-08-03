package com.nbc.testautomation.chillertv.support.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Paths of API endpoints.
 * <p>
 * Defining as prototype to avoid collisions in multi threading, e.g. access to object while it's destroying, etc.
 */
@Component
@Scope("prototype")
public class ApiEndpoints {

    @Value(value = "${video.details}")
    private String videoDetails;

    public String getVideoDetails() {
        return videoDetails;
    }

    public void setVideoDetails(String videoDetails) {
        this.videoDetails = videoDetails;
    }

    @Value(value = "${series.details}")
    private String seriesDetails;

    public String getSeriesDetails() {
        return seriesDetails;
    }

    public void setSeriesDetails(String seriesDetails) {
        this.seriesDetails = seriesDetails;
    }


    @Value(value = "${episode.details}")
    private String episodeDetails;

    public String getEpisodeDetails() {
        return episodeDetails;
    }

    public void setEpisodeDetails(String episodeDetails) {
        this.episodeDetails = episodeDetails;
    }

    @Value(value = "${event.details}")
    private String eventDetails;

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    @Value(value = "${season.details}")
    private String seasonDetails;

    public String getSeasonDetails() {
        return seasonDetails;
    }

    public void setSeasonDetails(String seasonDetails) {
        this.seasonDetails = seasonDetails;
    }


}
