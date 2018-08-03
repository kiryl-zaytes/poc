package com.poc.pubcentral.bo;

import com.google.common.base.Objects;

/**
 * Created by kiryl_zayets on 10/10/15.
 */
public class SeriesPojo extends RelatedType {

    private String seriesType;
    private String scheduledDuration;
    private String programmingTimeFram;

    public SeriesPojo() {}

    public String getSeriesType() {
        return seriesType;
    }

    public void setSeriesType(String seriesType) {
        this.seriesType = seriesType;
    }

    public String getScheduledDuration() {
        return scheduledDuration;
    }

    public void setScheduledDuration(String scheduledDuration) {
        this.scheduledDuration = scheduledDuration;
    }

    public String getProgrammingTimeFram() {
        return programmingTimeFram;
    }

    public void setProgrammingTimeFram(String programmingTimeFram) {
        this.programmingTimeFram = programmingTimeFram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeriesPojo seriesPojo = (SeriesPojo) o;
        return Objects.equal(title, seriesPojo.title) &&
                Objects.equal(subhead, seriesPojo.subhead) &&
                Objects.equal(shortDescription, seriesPojo.shortDescription) &&
                Objects.equal(mediumDescription, seriesPojo
                        .mediumDescription) &&
                Objects.equal(longDescription, seriesPojo.longDescription) &&
                Objects.equal(genre, seriesPojo.genre) &&
                Objects.equal(rating, seriesPojo.rating) &&
                Objects.equal(unscripted, seriesPojo.unscripted) &&
                Objects.equal(programStatus, seriesPojo.programStatus) &&
                Objects.equal(syndicated, seriesPojo.syndicated) &&
                Objects.equal(seriesType, seriesPojo.seriesType) &&
                Objects.equal(relatedSeries, seriesPojo.relatedSeries) &&
                Objects.equal(scheduledDuration, seriesPojo
                        .scheduledDuration) &&
                Objects.equal(programmingTimeFram, seriesPojo
                        .programmingTimeFram) &&
                Objects.equal(categories, seriesPojo.categories) &&
                Objects.equal(tags, seriesPojo.tags) &&
                Objects.equal(externalLink, seriesPojo.externalLink);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title, subhead, shortDescription,
                mediumDescription, longDescription, genre, rating,
                unscripted, programStatus, syndicated, seriesType,
                relatedSeries, scheduledDuration, programmingTimeFram,
                categories, tags, externalLink);
    }

    @Override
    public String toString() {
        return "Series{" +
                "title='" + title + '\'' +
                ", subhead='" + subhead + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", mediumDescription='" + mediumDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", genre='" + genre + '\'' +
                ", rating='" + rating + '\'' +
                ", unscripted=" + unscripted +
                ", programStatus='" + programStatus + '\'' +
                ", syndicated=" + syndicated +
                ", seriesType='" + seriesType + '\'' +
                ", relatedSeries='" + relatedSeries + '\'' +
                ", scheduledDuration='" + scheduledDuration + '\'' +
                ", programmingTimeFram='" + programmingTimeFram + '\'' +
                ", categories='" + categories + '\'' +
                ", tags='" + tags + '\'' +
                ", externalLink='" + externalLink + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
