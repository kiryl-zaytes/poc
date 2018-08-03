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
        "video",
        "relatedVideos",
        "heroImage"
})
public class Media {

    @JsonProperty("video")
    private VideoSource video;
    @JsonProperty("relatedVideos")
    private List<RelatedVideo> relatedVideos = new ArrayList<RelatedVideo>();
    @JsonProperty("heroImage")
    private HeroImage heroImage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The video
     */
    @JsonProperty("video")
    public VideoSource getVideo() {
        return video;
    }

    /**
     * @param video The video
     */
    @JsonProperty("video")
    public void setVideo(VideoSource video) {
        this.video = video;
    }

    /**
     * @return The relatedVideos
     */
    @JsonProperty("relatedVideos")
    public List<RelatedVideo> getRelatedVideos() {
        return relatedVideos;
    }

    /**
     * @param relatedVideos The relatedVideos
     */
    @JsonProperty("relatedVideos")
    public void setRelatedVideos(List<RelatedVideo> relatedVideos) {
        this.relatedVideos = relatedVideos;
    }

    /**
     * @return The heroImage
     */
    @JsonProperty("heroImage")
    public HeroImage getHeroImage() {
        return heroImage;
    }

    /**
     * @param heroImage The heroImage
     */
    @JsonProperty("heroImage")
    public void setHeroImage(HeroImage heroImage) {
        this.heroImage = heroImage;
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
