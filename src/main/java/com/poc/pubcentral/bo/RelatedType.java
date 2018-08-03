package com.poc.pubcentral.bo;

/**
 * Created by kiryl_zayets on 10/28/15.
 */
public class RelatedType extends BaseType {

    protected String genre;
    protected String rating;
    protected Boolean unscripted;
    protected String programStatus;
    protected Boolean syndicated;
    protected String relatedSeries;


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Boolean getUnscripted() {
        return unscripted;
    }

    public void setUnscripted(Boolean unscripted) {
        this.unscripted = unscripted;
    }

    public String getProgramStatus() {
        return programStatus;
    }

    public void setProgramStatus(String programStatus) {
        this.programStatus = programStatus;
    }

    public Boolean getSyndicated() {
        return syndicated;
    }

    public void setSyndicated(Boolean syndicated) {
        this.syndicated = syndicated;
    }


    public String getRelatedSeries() {
        return relatedSeries;
    }

    public void setRelatedSeries(String relatedSeries) {
        this.relatedSeries = relatedSeries;
    }
}
