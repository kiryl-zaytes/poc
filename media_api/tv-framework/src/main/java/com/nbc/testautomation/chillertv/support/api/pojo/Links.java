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
        "self",
        "relatedSeries",
        "parentUuids",
        "categories",
        "tags",
        "images",
        "program"

})
public class Links {

    @JsonProperty("self")
    private Self self;
    @JsonProperty("relatedSeries")
    private List<RelatedSeries> relatedSeries = new ArrayList<RelatedSeries>();
    @JsonProperty("parentUuids")
    private List<ParentUuid> parentUuids = new ArrayList<ParentUuid>();
    @JsonProperty("categories")
    private List<Category> categories = new ArrayList<Category>();
    @JsonProperty("tags")
    private List<Tag> tags = new ArrayList<Tag>();
    @JsonProperty("images")
    private List<Image> images = new ArrayList<Image>();
    @JsonProperty("program")
    private Program program;


    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     * @return The relatedSeries
     */
    @JsonProperty("relatedSeries")
    public List<RelatedSeries> getRelatedSeries() {
        return relatedSeries;
    }

    /**
     * @param relatedSeries The relatedSeries
     */
    @JsonProperty("relatedSeries")
    public void setRelatedSeries(List<RelatedSeries> relatedSeries) {
        this.relatedSeries = relatedSeries;
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
     * @return The images
     */
    @JsonProperty("images")
    public List<Image> getImages() {
        return images;
    }

    /**
     * @param images The images
     */
    @JsonProperty("images")
    public void setImages(List<Image> images) {
        this.images = images;
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
     * @return The program
     */
    @JsonProperty("program")
    public Program getProgram() {
        return program;
    }

    /**
     * @param program The program
     */
    @JsonProperty("program")
    public void setProgram(Program program) {
        this.program = program;
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
