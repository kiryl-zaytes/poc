
package com.nbc.testautomation.chillertv.support.api.pojo;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "links",
        "id",
        "startDate",
        "endDate",
        "numberOfEpisodes"
})
public class Season {

    @JsonProperty("links")
    private Links Links;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("numberOfEpisodes")
    private Integer numberOfEpisodes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The Links
     */
    @JsonProperty("links")
    public Links getLinks() {
        return Links;
    }

    /**
     * @param Links The links
     */
    @JsonProperty("links")
    public void setLinks(Links Links) {
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
     * @return The startDate
     */
    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate The startDate
     */
    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return The endDate
     */
    @JsonProperty("endDate")
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate The endDate
     */
    @JsonProperty("endDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return The numberOfEpisodes
     */
    @JsonProperty("numberOfEpisodes")
    public Integer getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    /**
     * @param numberOfEpisodes The numberOfEpisodes
     */
    @JsonProperty("numberOfEpisodes")
    public void setNumberOfEpisodes(Integer numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
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
