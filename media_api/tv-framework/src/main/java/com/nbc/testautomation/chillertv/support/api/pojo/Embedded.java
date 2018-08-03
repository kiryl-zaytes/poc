
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
        "seasons",
        "images",
        "categories",
        "tags",
        "program"
})
public class Embedded {


    @JsonProperty("images")
    private List<Image> images = new ArrayList<Image>();
    @JsonProperty("categories")
    private List<Category> categories = new ArrayList<Category>();
    @JsonProperty("tags")
    private List<Tag> tags = new ArrayList<Tag>();
    @JsonProperty("seasons")
    private List<Season> seasons = new ArrayList<Season>();
    @JsonProperty("program")
    private Program program;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    /**
     * @return The seasons
     */
    @JsonProperty("seasons")
    public List<Season> getSeasons() {
        return seasons;
    }

    /**
     * @param seasons The seasons
     */
    @JsonProperty("seasons")
    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
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
