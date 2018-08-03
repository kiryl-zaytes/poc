package com.nbc.testautomation.chillertv.businessobject;

/**
 * Episode object of application domain model. Used for storing properties of any particular episode: title, description, etc.
 */
public class Episode {

    private String id;

    private String title;

    private String subTitle;

    private String longDescription;

    private String shortDescription;

    private String imageUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Episode)) return false;

        Episode episode = (Episode) o;

        if (id != null ? !id.equals(episode.id) : episode.id != null) return false;
        if (title != null ? !title.equals(episode.title) : episode.title != null) return false;
        if (subTitle != null ? !subTitle.equals(episode.subTitle) : episode.subTitle != null) return false;
        if (longDescription != null ? !longDescription.equals(episode.longDescription) : episode.longDescription != null)
            return false;
        if (shortDescription != null ? !shortDescription.equals(episode.shortDescription) : episode.shortDescription != null)
            return false;
        return imageUrl != null ? imageUrl.equals(episode.imageUrl) : episode.imageUrl == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (subTitle != null ? subTitle.hashCode() : 0);
        result = 31 * result + (longDescription != null ? longDescription.hashCode() : 0);
        result = 31 * result + (shortDescription != null ? shortDescription.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
