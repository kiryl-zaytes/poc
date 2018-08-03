package com.poc.pubcentral.bo;

import com.google.common.base.Objects;

/**
 * Class gets all the form elements that need to be filled out from the episode page
 */
public class ImagePojo extends BaseType {

	public ImagePojo(){}

	private int id;
	private String title;
	private String caption;
	private String description;
	private String categories;
	private String tags;
	private String altText;
	private String credit;
	private String copyright;
	private String source;
	private String series;
	private String season;
	private String episode;
	private String hiRes;
	private String publisherId;
	private String createDate;
	private String createTime;
	private String channelReference;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	private String fileName;

	public String getHiRes() {
		return hiRes;
	}

	public void setHiRes(String hiRes) {
		this.hiRes = hiRes;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}
	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getAltText() {
		return altText;
	}

	public void setAltText(String altText) {
		this.altText = altText;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}
	public String getEpisode() {
		return episode;
	}

	public void setEpisode(String episode) {
		this.episode = episode;
	}

	public String getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	/**
	 * If there's a new imagePojo object, this method compares the two to make sure
	 * values are the same in both of those.
	 */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImagePojo imagePojo = (ImagePojo) o;
        return  Objects.equal(id, imagePojo.id) &&
        		Objects.equal(title, imagePojo.title) &&
        		Objects.equal(caption, imagePojo.caption) &&
        		Objects.equal(description, imagePojo.description) &&
                Objects.equal(categories, imagePojo.categories) &&
                Objects.equal(altText, imagePojo.altText) &&
                Objects.equal(credit, imagePojo.credit) &&
                Objects.equal(copyright, imagePojo.copyright) &&
                Objects.equal(source, imagePojo.source) &&
                Objects.equal(series, imagePojo.series) &&
                Objects.equal(season, imagePojo.season) &&
                Objects.equal(episode, imagePojo.episode) &&
                Objects.equal(hiRes, imagePojo.hiRes) &&
                Objects.equal(publisherId, imagePojo.publisherId) &&
                Objects.equal(createDate, imagePojo.createDate) &&
                Objects.equal(createTime, imagePojo.createTime) &&
                Objects.equal(tags, imagePojo.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title, caption, description, altText, credit, copyright,
                categories, tags, source, series, season, hiRes, createDate, createTime, publisherId);
    }

    /**
     * Converts the DB objects toString for ease of logging
     */
    @Override
    public String toString() {
        return "SeasonPojo{" +
                ", title='" + title + '\'' +
                ", categories='" + categories + '\'' +
                ", tags='" + tags + '\'' +
                ", caption='" + caption + '\'' +
                ", description='" + description + '\'' +
                ", altText='" + altText + '\'' +
                ", credit='" + credit + '\'' +
                ", copyright='" + copyright + '\'' +
                ", source='" + source + '\'' +
                ", seriesOrEvents='" + series + '\'' +
                ", season='" + season + '\'' +
                ", episode='" + episode + '\'' +
                ", hiRes='" + hiRes + '\'' +
                ", publisherId='" + publisherId + '\'' +
                ", createDate='" + createDate + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public String getChannelReference() {
		return channelReference;
	}

	public void setChannelReference(String channelReference) {
		this.channelReference = channelReference;
	}
}
