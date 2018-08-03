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
        "contentRating",
        "episodeNumber",
        "episodeType",
        "datePublished",
        "secondaryEpisodeNumber",
        "supplementaryAiring",
        "productionNumber",
        "_embedded",
        "_links"
})
public class EpisodeDetails {

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
    @JsonProperty("contentRating")
    private String contentRating;
    @JsonProperty("episodeNumber")
    private Integer episodeNumber;
    @JsonProperty("episodeType")
    private String episodeType;
    @JsonProperty("datePublished")
    private Integer datePublished;
    @JsonProperty("secondaryEpisodeNumber")
    private Integer secondaryEpisodeNumber;
    @JsonProperty("supplementaryAiring")
    private Integer supplementaryAiring;
    @JsonProperty("productionNumber")
    private Integer productionNumber;
    @JsonProperty("_embedded")
    private com.nbc.testautomation.chillertv.support.api.pojo.Embedded Embedded;
    @JsonProperty("_links")
    private Links Links;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *     The uuid
     */
    @JsonProperty("uuid")
    public String getUuid() {
        return uuid;
    }

    /**
     *
     * @param uuid
     *     The uuid
     */
    @JsonProperty("uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     *
     * @return
     *     The itemType
     */
    @JsonProperty("itemType")
    public String getItemType() {
        return itemType;
    }

    /**
     *
     * @param itemType
     *     The itemType
     */
    @JsonProperty("itemType")
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    /**
     *
     * @return
     *     The revision
     */
    @JsonProperty("revision")
    public Integer getRevision() {
        return revision;
    }

    /**
     *
     * @param revision
     *     The revision
     */
    @JsonProperty("revision")
    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    /**
     *
     * @return
     *     The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     *     The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     *     The subhead
     */
    @JsonProperty("subhead")
    public String getSubhead() {
        return subhead;
    }

    /**
     *
     * @param subhead
     *     The subhead
     */
    @JsonProperty("subhead")
    public void setSubhead(String subhead) {
        this.subhead = subhead;
    }

    /**
     *
     * @return
     *     The shortDescription
     */
    @JsonProperty("shortDescription")
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     *
     * @param shortDescription
     *     The shortDescription
     */
    @JsonProperty("shortDescription")
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     *
     * @return
     *     The mediumDescription
     */
    @JsonProperty("mediumDescription")
    public String getMediumDescription() {
        return mediumDescription;
    }

    /**
     *
     * @param mediumDescription
     *     The mediumDescription
     */
    @JsonProperty("mediumDescription")
    public void setMediumDescription(String mediumDescription) {
        this.mediumDescription = mediumDescription;
    }

    /**
     *
     * @return
     *     The longDescription
     */
    @JsonProperty("longDescription")
    public String getLongDescription() {
        return longDescription;
    }

    /**
     *
     * @param longDescription
     *     The longDescription
     */
    @JsonProperty("longDescription")
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    /**
     *
     * @return
     *     The published
     */
    @JsonProperty("published")
    public Boolean getPublished() {
        return published;
    }

    /**
     *
     * @param published
     *     The published
     */
    @JsonProperty("published")
    public void setPublished(Boolean published) {
        this.published = published;
    }


    /**
     *
     * @return
     *     The contentRating
     */
    @JsonProperty("contentRating")
    public String getContentRating() {
        return contentRating;
    }

    /**
     *
     * @param contentRating
     *     The contentRating
     */
    @JsonProperty("contentRating")
    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    /**
     *
     * @return
     *     The episodeNumber
     */
    @JsonProperty("episodeNumber")
    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    /**
     *
     * @param episodeNumber
     *     The episodeNumber
     */
    @JsonProperty("episodeNumber")
    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    /**
     *
     * @return
     *     The episodeType
     */
    @JsonProperty("episodeType")
    public String getEpisodeType() {
        return episodeType;
    }

    /**
     *
     * @param episodeType
     *     The episodeType
     */
    @JsonProperty("episodeType")
    public void setEpisodeType(String episodeType) {
        this.episodeType = episodeType;
    }

    /**
     *
     * @return
     *     The datePublished
     */
    @JsonProperty("datePublished")
    public Integer getDatePublished() {
        return datePublished;
    }

    /**
     *
     * @param datePublished
     *     The datePublished
     */
    @JsonProperty("datePublished")
    public void setDatePublished(Integer datePublished) {
        this.datePublished = datePublished;
    }

    /**
     *
     * @return
     *     The secondaryEpisodeNumber
     */
    @JsonProperty("secondaryEpisodeNumber")
    public Integer getSecondaryEpisodeNumber() {
        return secondaryEpisodeNumber;
    }

    /**
     *
     * @param secondaryEpisodeNumber
     *     The secondaryEpisodeNumber
     */
    @JsonProperty("secondaryEpisodeNumber")
    public void setSecondaryEpisodeNumber(Integer secondaryEpisodeNumber) {
        this.secondaryEpisodeNumber = secondaryEpisodeNumber;
    }

    /**
     *
     * @return
     *     The supplementaryAiring
     */
    @JsonProperty("supplementaryAiring")
    public Integer getSupplementaryAiring() {
        return supplementaryAiring;
    }

    /**
     *
     * @param supplementaryAiring
     *     The supplementaryAiring
     */
    @JsonProperty("supplementaryAiring")
    public void setSupplementaryAiring(Integer supplementaryAiring) {
        this.supplementaryAiring = supplementaryAiring;
    }

    /**
     *
     * @return
     *     The productionNumber
     */
    @JsonProperty("productionNumber")
    public Integer getProductionNumber() {
        return productionNumber;
    }

    /**
     *
     * @param productionNumber
     *     The productionNumber
     */
    @JsonProperty("productionNumber")
    public void setProductionNumber(Integer productionNumber) {
        this.productionNumber = productionNumber;
    }

    /**
     *
     * @return
     *     The Embedded
     */
    @JsonProperty("_embedded")
    public com.nbc.testautomation.chillertv.support.api.pojo.Embedded getEmbedded() {
        return Embedded;
    }

    /**
     *
     * @param Embedded
     *     The _embedded
     */
    @JsonProperty("_embedded")
    public void setEmbedded(com.nbc.testautomation.chillertv.support.api.pojo.Embedded Embedded) {
        this.Embedded = Embedded;
    }

    /**
     *
     * @return
     *     The Links
     */
    @JsonProperty("_links")
    public Links getLinks() {
        return Links;
    }

    /**
     *
     * @param Links
     *     The _links
     */
    @JsonProperty("_links")
    public void setLinks(Links Links) {
        this.Links = Links;
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
