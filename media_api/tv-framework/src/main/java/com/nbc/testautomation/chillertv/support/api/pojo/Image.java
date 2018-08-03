
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
        "uuid",
        "title",
        "itemType",
        "href",
        "imageStyle",
        "alt",
        "caption",
        "copyright",
        "credit",
        "description",
        "highRes",
        "source",
        "published",
        "revision",
        "_embedded",
        "_links"
})
public class Image {

    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("title")
    private String title;
    @JsonProperty("itemType")
    private String itemType;
    @JsonProperty("href")
    private String href;
    @JsonProperty("imageStyle")
    private List<ImageStyle> imageStyle = new ArrayList<ImageStyle>();
    @JsonProperty("alt")
    private String alt;
    @JsonProperty("caption")
    private String caption;
    @JsonProperty("copyright")
    private String copyright;
    @JsonProperty("credit")
    private String credit;
    @JsonProperty("description")
    private String description;
    @JsonProperty("highRes")
    private Boolean highRes;
    @JsonProperty("source")
    private String source;
    @JsonProperty("published")
    private Boolean published;
    @JsonProperty("revision")
    private Integer revision;
    @JsonProperty("_embedded")
    private Embedded Embedded;
    @JsonProperty("_links")
    private Links Links;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The uuid
     */
    @JsonProperty("uuid")
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid The uuid
     */
    @JsonProperty("uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
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
     * @return The itemType
     */
    @JsonProperty("itemType")
    public String getItemType() {
        return itemType;
    }

    /**
     * @param itemType The itemType
     */
    @JsonProperty("itemType")
    public void setItemType(String itemType) {
        this.itemType = itemType;
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
     * @return The imageStyle
     */
    @JsonProperty("imageStyle")
    public List<ImageStyle> getImageStyle() {
        return imageStyle;
    }

    /**
     * @param imageStyle The imageStyle
     */
    @JsonProperty("imageStyle")
    public void setImageStyle(List<ImageStyle> imageStyle) {
        this.imageStyle = imageStyle;
    }

    /**
     * @return The alt
     */
    @JsonProperty("alt")
    public String getAlt() {
        return alt;
    }

    /**
     * @param alt The alt
     */
    @JsonProperty("alt")
    public void setAlt(String alt) {
        this.alt = alt;
    }

    /**
     * @return The caption
     */
    @JsonProperty("caption")
    public String getCaption() {
        return caption;
    }

    /**
     * @param caption The caption
     */
    @JsonProperty("caption")
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * @return The copyright
     */
    @JsonProperty("copyright")
    public String getCopyright() {
        return copyright;
    }

    /**
     * @param copyright The copyright
     */
    @JsonProperty("copyright")
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     * @return The credit
     */
    @JsonProperty("credit")
    public String getCredit() {
        return credit;
    }

    /**
     * @param credit The credit
     */
    @JsonProperty("credit")
    public void setCredit(String credit) {
        this.credit = credit;
    }

    /**
     * @return The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The highRes
     */
    @JsonProperty("highRes")
    public Boolean getHighRes() {
        return highRes;
    }

    /**
     * @param highRes The highRes
     */
    @JsonProperty("highRes")
    public void setHighRes(Boolean highRes) {
        this.highRes = highRes;
    }

    /**
     * @return The source
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * @param source The source
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return The published
     */
    @JsonProperty("published")
    public Boolean getPublished() {
        return published;
    }

    /**
     * @param published The published
     */
    @JsonProperty("published")
    public void setPublished(Boolean published) {
        this.published = published;
    }

    /**
     * @return The revision
     */
    @JsonProperty("revision")
    public Integer getRevision() {
        return revision;
    }

    /**
     * @param revision The revision
     */
    @JsonProperty("revision")
    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    /**
     * @return The Embedded
     */
    @JsonProperty("_embedded")
    public Embedded getEmbedded() {
        return Embedded;
    }

    /**
     * @param Embedded The _embedded
     */
    @JsonProperty("_embedded")
    public void setEmbedded(Embedded Embedded) {
        this.Embedded = Embedded;
    }

    /**
     * @return The Links
     */
    @JsonProperty("_links")
    public Links getLinks() {
        return Links;
    }

    /**
     * @param Links The _links
     */
    @JsonProperty("_links")
    public void setLinks(Links Links) {
        this.Links = Links;
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
