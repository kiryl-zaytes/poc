package com.poc.pubcentral.bo;

/**
 * Created by kiryl_zayets on 10/19/15.
 */
public class EventPojo extends RelatedType {

    private String eventType;
    private String releaseYear;
    private String airTimes;


    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getAirTimes() {
        return airTimes;
    }

    public void setAirTimes(String airTimes) {
        this.airTimes = airTimes;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subhead='" + subhead + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", mediumDescription='" + mediumDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", genre='" + genre + '\'' +
                ", rating='" + rating + '\'' +
                ", unscripted=" + unscripted +
                ", programStatus='" + programStatus + '\'' +
                ", syndicated=" + syndicated +
                ", eventType='" + eventType + '\'' +
                ", relatedSeries='" + relatedSeries + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", airTimes='" + airTimes + '\'' +
                ", categories='" + categories + '\'' +
                ", tags='" + tags + '\'' +
                ", externalLink='" + externalLink + '\'' +
                '}';
    }
}
