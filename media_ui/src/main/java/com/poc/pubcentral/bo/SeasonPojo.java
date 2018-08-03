package com.poc.pubcentral.bo;

import com.google.common.base.Objects;

/**
 * Created by kiryl_zayets on 10/27/15.
 */
public class SeasonPojo extends BaseType {

    private int productionNumber;
    private int seasonNumber;
    private String seasonDate;
    private String programReference;


    public int getProductionNumber() {
        return productionNumber;
    }

    public void setProductionNumber(int productionNumber) {
        this.productionNumber = productionNumber;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public String getSeasonDate() {
        return seasonDate;
    }

    public void setSeasonDate(String seasonDate) {
        this.seasonDate = seasonDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeasonPojo that = (SeasonPojo) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(productionNumber, that.productionNumber) &&
                Objects.equal(seasonNumber, that.seasonNumber) &&
                Objects.equal(title, that.title) &&
                Objects.equal(subhead, that.subhead) &&
                Objects.equal(shortDescription, that.shortDescription) &&
                Objects.equal(mediumDescription, that.mediumDescription) &&
                Objects.equal(longDescription, that.longDescription) &&
                Objects.equal(seasonDate, that.seasonDate) &&
                Objects.equal(categories, that.categories) &&
                Objects.equal(tags, that.tags) &&
                Objects.equal(externalLink, that.externalLink);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, title, subhead, shortDescription,
                mediumDescription, longDescription,
                productionNumber, seasonNumber, seasonDate, categories, tags,
                externalLink);
    }

    @Override
    public String toString() {
        return "SeasonPojo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subhead='" + subhead + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", mediumDescription='" + mediumDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", productionNumber=" + productionNumber +
                ", seasonNumber=" + seasonNumber +
                ", seasonDate=" + seasonDate +
                ", categories='" + categories + '\'' +
                ", tags='" + tags + '\'' +
                ", externalLink='" + externalLink + '\'' +
                '}';
    }

    public String getProgramReference() {
        return programReference;
    }

    public void setProgramReference(String programReference) {
        this.programReference = programReference;
    }
}
