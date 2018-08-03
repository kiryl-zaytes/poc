package tech.viacom.conman.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kiryl_zayets on 2/26/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
                           "deviceId",
                           "ended",
                           "estimatedEnd",
                           "id",
                           "providerId",
                           "requested",
                           "userProviderId"
                   })
public class StreamModel {

    @JsonProperty("deviceId")
    public String deviceId;
    @JsonProperty("ended")
    public Ended ended;
    @JsonProperty("estimatedEnd")
    public String estimatedEnd;
    @JsonProperty("id")
    public String id;
    @JsonProperty("providerId")
    public String providerId;
    @JsonProperty("requested")
    public String requested;
    @JsonProperty("userProviderId")
    public String userProviderId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public StreamModel withDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public StreamModel withEnded(Ended ended) {
        this.ended = ended;
        return this;
    }

    public StreamModel withEstimatedEnd(String estimatedEnd) {
        this.estimatedEnd = estimatedEnd;
        return this;
    }

    public StreamModel withId(String id) {
        this.id = id;
        return this;
    }

    public StreamModel withProviderId(String providerId) {
        this.providerId = providerId;
        return this;
    }

    public StreamModel withRequested(String requested) {
        this.requested = requested;
        return this;
    }

    public StreamModel withUserProviderId(String userProviderId) {
        this.userProviderId = userProviderId;
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

    public StreamModel withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }
}
