
package com.nbc.testautomation.chillertv.support.api.pojo;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "title",
        "src"
})
public class HeroImage {

    @JsonProperty("title")
    private String title;
    @JsonProperty("src")
    private Src src;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The src
     */
    @JsonProperty("src")
    public Src getSrc() {
        return src;
    }

    /**
     *
     * @param src
     *     The src
     */
    @JsonProperty("src")
    public void setSrc(Src src) {
        this.src = src;
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
