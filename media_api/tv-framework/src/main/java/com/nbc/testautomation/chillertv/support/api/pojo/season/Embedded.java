
package com.nbc.testautomation.chillertv.support.api.pojo.season;

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
        "images",
        "categories",
        "tag",
        "program"
})
public class Embedded {

    @JsonProperty("images")
    private List<Image> images = new ArrayList<Image>();
    @JsonProperty("categories")
    private List<Category> categories = new ArrayList<Category>();
    @JsonProperty("tag")
    private List<Tag> tag = new ArrayList<Tag>();
    @JsonProperty("program")
    private Program program;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     * @return The tag
     */
    @JsonProperty("tag")
    public List<Tag> getTags() {
        return tag;
    }

    /**
     * @param tag The tag
     */
    @JsonProperty("tag")
    public void setTags(List<Tag> tags) {
        this.tag = tags;
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
