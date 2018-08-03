package com.nbc.testautomation.chillertv.support.api.pojo;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "_links",
        "id",
        "name",
        "type",
        "airDate",
        "time",
        "length",
        "longDescription",
        "media"
})
public class VideoDetails {

    @JsonProperty("_links")
    private com.nbc.testautomation.chillertv.support.api.pojo.Links Links;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("airDate")
    private String airDate;
    @JsonProperty("time")
    private String time;
    @JsonProperty("length")
    private String length;
    @JsonProperty("longDescription")
    private String longDescription;
    @JsonProperty("media")
    private Media media;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The Links
     */
    @JsonProperty("_links")
    public com.nbc.testautomation.chillertv.support.api.pojo.Links getLinks() {
        return Links;
    }

    /**
     * @param Links The _links
     */
    @JsonProperty("_links")
    public void setLinks(com.nbc.testautomation.chillertv.support.api.pojo.Links Links) {
        this.Links = Links;
    }

    /**
     * @return The id
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The airDate
     */
    @JsonProperty("airDate")
    public String getAirDate() {
        return airDate;
    }

    /**
     * @param airDate The airDate
     */
    @JsonProperty("airDate")
    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    /**
     * @return The time
     */
    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    /**
     * @param time The time
     */
    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return The length
     */
    @JsonProperty("length")
    public String getLength() {
        return length;
    }

    /**
     * @param length The length
     */
    @JsonProperty("length")
    public void setLength(String length) {
        this.length = length;
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
     * @return The media
     */
    @JsonProperty("media")
    public Media getMedia() {
        return media;
    }

    /**
     * @param media The media
     */
    @JsonProperty("media")
    public void setMedia(Media media) {
        this.media = media;
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
