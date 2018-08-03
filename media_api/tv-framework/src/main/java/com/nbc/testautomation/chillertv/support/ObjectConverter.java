package com.nbc.testautomation.chillertv.support;

import com.nbc.testautomation.chillertv.businessobject.*;
import com.nbc.testautomation.chillertv.support.api.pojo.EpisodeDetails;
import com.nbc.testautomation.chillertv.support.api.pojo.Image;
import com.nbc.testautomation.chillertv.support.api.pojo.SeriesDetails;
import com.nbc.testautomation.chillertv.support.api.pojo.VideoDetails;
import com.nbc.testautomation.chillertv.support.api.pojo.event.EventDetails;
import com.nbc.testautomation.chillertv.support.api.pojo.season.SeasonDetails;

import java.util.ArrayList;
import java.util.List;

//import com.nbc.testautomation.webdriver.element.Image;

/**
 * Created by mk on 12/31/15.
 */
public class ObjectConverter {

    public Video toVideo(VideoDetails objectToConvert) {
        Video video = new Video();

        video.setId(objectToConvert.getId().toString());
        video.setTitle(objectToConvert.getName());
        video.setVideoUrl(objectToConvert.getMedia().getVideo().getSrc());
        video.setLongDescription(objectToConvert.getLongDescription());

        return video;
    }

    public Series toSeries(SeriesDetails objectToConvert) {
        Series series = new Series();
        List<Image> imageSource = new ArrayList<Image>();
        imageSource = objectToConvert.getEmbedded().getImages();
        series.setId(objectToConvert.getUuid().toString());
        series.setSeriesTitle(objectToConvert.getTitle());
        series.setImageUrl(imageSource.get(0).getHref());
        series.setLongDescription(objectToConvert.getLongDescription());
        return series;
    }

    public Episode toEpisode(EpisodeDetails objectToConvert) {
        Episode episode = new Episode();
        List<Image> imageSource = new ArrayList<Image>();
        imageSource = objectToConvert.getEmbedded().getImages();

        episode.setId(objectToConvert.getUuid().toString());
        episode.setTitle(objectToConvert.getTitle());
        episode.setImageUrl(imageSource.get(0).getHref());
        episode.setLongDescription(objectToConvert.getLongDescription());
        return episode;
    }

    public Event toEvent(EventDetails objectToConvert) {
        Event event = new Event();

        event.setId(objectToConvert.getUuid().toString());
        event.setTitle(objectToConvert.getTitle());
        event.setImageUrl(objectToConvert.getEmbedded().getImages().get(0).getHref());
        event.setLongDescription(objectToConvert.getLongDescription());

        return event;
    }

    public Season toSeason(SeasonDetails objectToConvert) {

        Season season = new Season();

        season.setId(objectToConvert.getUuid().toString());
        season.setTitle(objectToConvert.getTitle());

        return season;
    }


}

