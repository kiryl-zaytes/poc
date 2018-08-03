
package com.nbc.testautomation.chillertv.support.api.pojo.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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
    "genre",
    "contentRating",
    "unscripted",
    "syndicated",
    "seriesType",
    "airTimes `9pm cst`",
    "channelOriginal",
    "eventType",
    "programStatus",
    "releaseYear",
    "seriesEpisodeLength",
    "daypart",
    "_embedded"
    //"_links"
})
public class EventDetails {

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
    @JsonProperty("genre")
    private List<String> genre = new ArrayList<String>();
    @JsonProperty("contentRating")
    private String contentRating;
    @JsonProperty("unscripted")
    private Boolean unscripted;
    @JsonProperty("syndicated")
    private Boolean syndicated;
    @JsonProperty("seriesType")
    private String seriesType;
    @JsonProperty("airTimes `9pm cst`")
    private Object airTimes9pmCst;
    @JsonProperty("channelOriginal")
    private Boolean channelOriginal;
    @JsonProperty("eventType")
    private String eventType;
    @JsonProperty("programStatus")
    private String programStatus;
    @JsonProperty("releaseYear")
    private Integer releaseYear;
    @JsonProperty("seriesEpisodeLength")
    private Integer seriesEpisodeLength;
    @JsonProperty("daypart")
    private String daypart;
    @JsonProperty("_embedded")
    private com.nbc.testautomation.chillertv.support.api.pojo.event.Embedded Embedded;
    /*@JsonProperty("_links")
    private Links___ Links;*/
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
     *     The links
     */
    @JsonProperty("links")
    public List<Link> getLinks() {
        return links;
    }

    /**
     * 
     * @param links
     *     The links
     */
    @JsonProperty("links")
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    /**
     * 
     * @return
     *     The genre
     */
    @JsonProperty("genre")
    public List<String> getGenre() {
        return genre;
    }

    /**
     * 
     * @param genre
     *     The genre
     */
    @JsonProperty("genre")
    public void setGenre(List<String> genre) {
        this.genre = genre;
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
     *     The unscripted
     */
    @JsonProperty("unscripted")
    public Boolean getUnscripted() {
        return unscripted;
    }

    /**
     * 
     * @param unscripted
     *     The unscripted
     */
    @JsonProperty("unscripted")
    public void setUnscripted(Boolean unscripted) {
        this.unscripted = unscripted;
    }

    /**
     * 
     * @return
     *     The syndicated
     */
    @JsonProperty("syndicated")
    public Boolean getSyndicated() {
        return syndicated;
    }

    /**
     * 
     * @param syndicated
     *     The syndicated
     */
    @JsonProperty("syndicated")
    public void setSyndicated(Boolean syndicated) {
        this.syndicated = syndicated;
    }

    /**
     * 
     * @return
     *     The seriesType
     */
    @JsonProperty("seriesType")
    public String getSeriesType() {
        return seriesType;
    }

    /**
     * 
     * @param seriesType
     *     The seriesType
     */
    @JsonProperty("seriesType")
    public void setSeriesType(String seriesType) {
        this.seriesType = seriesType;
    }

    /**
     * 
     * @return
     *     The airTimes9pmCst
     */
    @JsonProperty("airTimes `9pm cst`")
    public Object getAirTimes9pmCst() {
        return airTimes9pmCst;
    }

    /**
     * 
     * @param airTimes9pmCst
     *     The airTimes `9pm cst`
     */
    @JsonProperty("airTimes `9pm cst`")
    public void setAirTimes9pmCst(Object airTimes9pmCst) {
        this.airTimes9pmCst = airTimes9pmCst;
    }

    /**
     * 
     * @return
     *     The channelOriginal
     */
    @JsonProperty("channelOriginal")
    public Boolean getChannelOriginal() {
        return channelOriginal;
    }

    /**
     * 
     * @param channelOriginal
     *     The channelOriginal
     */
    @JsonProperty("channelOriginal")
    public void setChannelOriginal(Boolean channelOriginal) {
        this.channelOriginal = channelOriginal;
    }

    /**
     * 
     * @return
     *     The eventType
     */
    @JsonProperty("eventType")
    public String getEventType() {
        return eventType;
    }

    /**
     * 
     * @param eventType
     *     The eventType
     */
    @JsonProperty("eventType")
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * 
     * @return
     *     The programStatus
     */
    @JsonProperty("programStatus")
    public String getProgramStatus() {
        return programStatus;
    }

    /**
     * 
     * @param programStatus
     *     The programStatus
     */
    @JsonProperty("programStatus")
    public void setProgramStatus(String programStatus) {
        this.programStatus = programStatus;
    }

    /**
     * 
     * @return
     *     The releaseYear
     */
    @JsonProperty("releaseYear")
    public Integer getReleaseYear() {
        return releaseYear;
    }

    /**
     * 
     * @param releaseYear
     *     The releaseYear
     */
    @JsonProperty("releaseYear")
    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    /**
     * 
     * @return
     *     The seriesEpisodeLength
     */
    @JsonProperty("seriesEpisodeLength")
    public Integer getSeriesEpisodeLength() {
        return seriesEpisodeLength;
    }

    /**
     * 
     * @param seriesEpisodeLength
     *     The seriesEpisodeLength
     */
    @JsonProperty("seriesEpisodeLength")
    public void setSeriesEpisodeLength(Integer seriesEpisodeLength) {
        this.seriesEpisodeLength = seriesEpisodeLength;
    }

    /**
     * 
     * @return
     *     The daypart
     */
    @JsonProperty("daypart")
    public String getDaypart() {
        return daypart;
    }

    /**
     * 
     * @param daypart
     *     The daypart
     */
    @JsonProperty("daypart")
    public void setDaypart(String daypart) {
        this.daypart = daypart;
    }

    /**
     * 
     * @return
     *     The Embedded
     */
    @JsonProperty("_embedded")
    public com.nbc.testautomation.chillertv.support.api.pojo.event.Embedded getEmbedded() {
        return Embedded;
    }

    /**
     * 
     * @param Embedded
     *     The _embedded
     */
    @JsonProperty("_embedded")
    public void setEmbedded(com.nbc.testautomation.chillertv.support.api.pojo.event.Embedded Embedded) {
        this.Embedded = Embedded;
    }

    /**
     * 
     * @return
     *     The Links
     */
    /*@JsonProperty("_links")
    public Links___ getLinks() {
        return Links;
    }*/

    /**
     * 
     * @param Links
     *     The _links
     */
    /*@JsonProperty("_links")
    public void setLinks(Links___ Links) {
        this.Links = Links;
    }*/

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
