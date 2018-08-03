
package com.nbc.testautomation.chillertv.support.api.pojo;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "parentUuid",
        "title",
        "href"
})
public class ParentUuid {

    @JsonProperty("parentUuid")
    private String parentUuid;
    @JsonProperty("title")
    private String title;
    @JsonProperty("href")
    private String href;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The parentUuid
     */
    @JsonProperty("parentUuid")
    public String getParentUuid() {
        return parentUuid;
    }

    /**
     * @param parentUuid The parentUuid
     */
    @JsonProperty("parentUuid")
    public void setParentUuid(String parentUuid) {
        this.parentUuid = parentUuid;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
