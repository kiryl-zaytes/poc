package com.poc.pubcentral.bo;

import com.google.common.base.Objects;

/**
 * Created by kiryl_zayets on 11/10/15.
 */
public class EpisodePojo extends BaseType {

    private String seriesReference;
    private String seasonReference;
    private String episodeType;
    private String episodeNumber;
    private String tvRating;
    private String productionNumber;
    private String supplementaryAiring;

    public String getSeriesReference() {
        return seriesReference;
    }

    public void setSeriesReference(String seriesReference) {
        this.seriesReference = seriesReference;
    }

    public String getSeasonReference() {
        return seasonReference;
    }

    public void setSeasonReference(String seasonReference) {
        this.seasonReference = seasonReference;
    }

    public String getEpisodeType() {
        return episodeType;
    }

    public void setEpisodeType(String episodeType) {
        this.episodeType = episodeType;
    }

    public String getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(String episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getProductionNumber() {
        return productionNumber;
    }

    public void setProductionNumber(String productionNumber) {
        this.productionNumber = productionNumber;
    }

    public String getSupplementaryAiring() {
        return supplementaryAiring;
    }

    public void setSupplementaryAiring(String supplementaryAiring) {
        this.supplementaryAiring = supplementaryAiring;
    }

    public String getTvRating() {
        return tvRating;
    }

    public void setTvRating(String tvRating) {
        this.tvRating = tvRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EpisodePojo that = (EpisodePojo) o;
        return Objects.equal(seriesReference, that.seriesReference) &&
                Objects.equal(seasonReference, that.seasonReference) &&
                Objects.equal(episodeType, that.episodeType) &&
                Objects.equal(episodeNumber, that.episodeNumber) &&
                Objects.equal(tvRating, that.tvRating) &&
                Objects.equal(productionNumber, that.productionNumber) &&
                Objects.equal(supplementaryAiring, that.supplementaryAiring);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(seriesReference, seasonReference,
                episodeType, episodeNumber, tvRating, productionNumber, supplementaryAiring);
    }

    @Override
    public String toString() {
        return "EpisodePojo{" +
                "seriesReference='" + seriesReference + '\'' +
                ", seasonReference='" + seasonReference + '\'' +
                ", episodeType='" + episodeType + '\'' +
                ", episodeNumber='" + episodeNumber + '\'' +
                ", tvRating='" + tvRating + '\'' +
                ", productionNumber='" + productionNumber + '\'' +
                ", supplementaryAiring='" + supplementaryAiring + '\'' +
                '}';
    }
}
