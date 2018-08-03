package tech.viacom.conman.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kiryl_zayets on 2/26/17.
 */
public class Ended {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
                               "present"
                       })

    @JsonProperty("present")
    public boolean present;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    public Ended withPresent(boolean present) {
        this.present = present;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Ended withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
