
package com.nbc.testautomation.chillertv.support.api.pojo.season;

import java.util.HashMap;
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
        "title",
        "vocabularyType",
        "description",
        "revision",
        "weight",
        "_link",
        "href"
})
public class Category {

    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("itemType")
    private String itemType;
    @JsonProperty("title")
    private String title;
    @JsonProperty("vocabularyType")
    private String vocabularyType;
    @JsonProperty("description")
    private String description;
    @JsonProperty("revision")
    private Integer revision;
    @JsonProperty("weight")
    private Integer weight;
    @JsonProperty("link")
    private Link Link;
    @JsonProperty("href")
    private String href;
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
     * @return The vocabularyType
     */
    @JsonProperty("vocabularyType")
    public String getVocabularyType() {
        return vocabularyType;
    }

    /**
     * @param vocabularyType The vocabularyType
     */
    @JsonProperty("vocabularyType")
    public void setVocabularyType(String vocabularyType) {
        this.vocabularyType = vocabularyType;
    }

    /**
     * @return The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
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
     * @return The weight
     */
    @JsonProperty("weight")
    public Integer getWeight() {
        return weight;
    }

    /**
     * @param weight The weight
     */
    @JsonProperty("weight")
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * @return The Links
     */
    @JsonProperty("_links")
    public Link getLinks() {
        return Link;
    }

    /**
     * @param Link The link
     */
    @JsonProperty("link")
    public void setLinks(Link Links) {
        this.Link = Links;
    }

    /**
     * @return The href
     */
    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    /**
     * @param href The href
     */

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
