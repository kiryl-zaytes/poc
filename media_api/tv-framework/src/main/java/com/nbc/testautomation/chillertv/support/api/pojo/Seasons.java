package com.nbc.testautomation.chillertv.support.api.pojo;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "uuid",
        "itemType",
        "revision",
        "title",
        "subhead",
        "shortDescription",
        "mediumDescription",
        "longDescription",
        "published",
        "links",
        "productionNumber",
        "seasonNumber",
        "seasonStartDate",
        "seasonEndDate",
        "_links"
})
public class Seasons {

    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("itemType")
    private String itemType;
    @JsonProperty("revision")
    private Integer revision;
    @JsonProperty("title")
    private String title;
    @JsonProperty("subhead")
    private String subhead;
    @JsonProperty("shortDescription")
    private String shortDescription;
    @JsonProperty("mediumDescription")
    private String mediumDescription;
    @JsonProperty("longDescription")
    private String longDescription;
    @JsonProperty("published")
    private Boolean published;
    @JsonProperty("links")
    private List<Link> links = new ArrayList<Link>();
    @JsonProperty("productionNumber")
    private Integer productionNumber;
    @JsonProperty("seasonNumber")
    private Integer seasonNumber;
    @JsonProperty("seasonStartDate")
    private Integer seasonStartDate;
    @JsonProperty("seasonEndDate")
    private Integer seasonEndDate;
    @JsonProperty("_links")
    private Links Links;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The uuid
     */
    @JsonProperty("uuid")
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid The uuid
     */
    @JsonProperty("uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return The itemType
     */
    @JsonProperty("itemType")
    public String getItemType() {
        return itemType;
    }

    /**
     * @param itemType The itemType
     */
    @JsonProperty("itemType")
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    /**
     * @return The revision
     */
    @JsonProperty("revision")
    public Integer getRevision() {
        return revision;
    }

    /**
     * @param revision The revision
     */
    @JsonProperty("revision")
    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    /**
     * @return The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The subhead
     */
    @JsonProperty("subhead")
    public String getSubhead() {
        return subhead;
    }

    /**
     * @param subhead The subhead
     */
    @JsonProperty("subhead")
    public void setSubhead(String subhead) {
        this.subhead = subhead;
    }

    /**
     * @return The shortDescription
     */
    @JsonProperty("shortDescription")
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * @param shortDescription The shortDescription
     */
    @JsonProperty("shortDescription")
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * @return The mediumDescription
     */
    @JsonProperty("mediumDescription")
    public String getMediumDescription() {
        return mediumDescription;
    }

    /**
     * @param mediumDescription The mediumDescription
     */
    @JsonProperty("mediumDescription")
    public void setMediumDescription(String mediumDescription) {
        this.mediumDescription = mediumDescription;
    }

    /**
     * @return The longDescription
     */
    @JsonProperty("longDescription")
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * @param longDescription The longDescription
     */
    @JsonProperty("longDescription")
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    /**
     * @return The published
     */
    @JsonProperty("published")
    public Boolean getPublished() {
        return published;
    }

    /**
     * @param published The published
     */
    @JsonProperty("published")
    public void setPublished(Boolean published) {
        this.published = published;
    }

    /**
     * @return The links
     */
    @JsonProperty("links")
    public List<Link> getLinks() {
        return links;
    }

    /**
     * @param links The links
     */
    @JsonProperty("links")
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    /**
     * @return The productionNumber
     */
    @JsonProperty("productionNumber")
    public Integer getProductionNumber() {
        return productionNumber;
    }

    /**
     * @param productionNumber The productionNumber
     */
    @JsonProperty("productionNumber")
    public void setProductionNumber(Integer productionNumber) {
        this.productionNumber = productionNumber;
    }

    /**
     * @return The seasonNumber
     */
    @JsonProperty("seasonNumber")
    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    /**
     * @param seasonNumber The seasonNumber
     */
    @JsonProperty("seasonNumber")
    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    /**
     * @return The seasonStartDate
     */
    @JsonProperty("seasonStartDate")
    public Integer getSeasonStartDate() {
        return seasonStartDate;
    }

    /**
     * @param seasonStartDate The seasonStartDate
     */
    @JsonProperty("seasonStartDate")
    public void setSeasonStartDate(Integer seasonStartDate) {
        this.seasonStartDate = seasonStartDate;
    }

    /**
     * @return The seasonEndDate
     */
    @JsonProperty("seasonEndDate")
    public Integer getSeasonEndDate() {
        return seasonEndDate;
    }

    /**
     * @param seasonEndDate The seasonEndDate
     */
    @JsonProperty("seasonEndDate")
    public void setSeasonEndDate(Integer seasonEndDate) {
        this.seasonEndDate = seasonEndDate;
    }


    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
