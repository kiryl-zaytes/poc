
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
        "text",
        "href",
        "self",
        "categories",
        "tags",
        "parentUuids",
        "relatedSeries"
})
public class Link {

    @JsonProperty("text")
    private String text;
    @JsonProperty("href")
    private String href;
    @JsonProperty("self")
    private Self self;
    @JsonProperty("categories")
    private List<Category> categories = new ArrayList<Category>();
    @JsonProperty("tags")
    private List<Tag> tags = new ArrayList<Tag>();
    @JsonProperty("parentUuids")
    private List<ParentUuid> parentUuids = new ArrayList<ParentUuid>();
    @JsonProperty("relatedSeries")
    private List<RelatedSeries> relatedSeries = new ArrayList<RelatedSeries>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The text
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * @param text The text
     */
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
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
    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * @return The self
     */
    @JsonProperty("self")
    public Self getSelf() {
        return self;
    }

    /**
     * @param self The self
     */
    @JsonProperty("self")
    public void setSelf(Self self) {
        this.self = self;
    }

    /**
     * @return The categories
     */
    @JsonProperty("categories")
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * @param categories The categories
     */
    @JsonProperty("categories")
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /**
     * @return The tags
     */
    @JsonProperty("tags")
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * @param tags The tags
     */
    @JsonProperty("tags")
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     * @return The parentUuids
     */
    @JsonProperty("parentUuids")
    public List<ParentUuid> getParentUuids() {
        return parentUuids;
    }

    /**
     * @param parentUuids The parentUuids
     */
    @JsonProperty("parentUuids")
    public void setParentUuids(List<ParentUuid> parentUuids) {
        this.parentUuids = parentUuids;
    }

    /**
     * @return The relatedSeries
     */
    @JsonProperty("relatedSeries")
    public List<RelatedSeries> getRelatedSeries() {
        return relatedSeries;
    }

    /**
     * @param relatedSeries The relatedSeries
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
