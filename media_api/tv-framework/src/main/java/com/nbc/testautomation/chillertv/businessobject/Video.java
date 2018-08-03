package com.nbc.testautomation.chillertv.businessobject;

/**
 * Video object of application domain model. Used for storing properties of any particular video: title, description, etc.
 */
public class Video {

    private String id;

    private String title;

    private String longDescription;

    private String videoUrl;

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

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Video)) return false;

        Video video = (Video) o;

        if (id != null ? !id.equals(video.id) : video.id != null) return false;
        if (title != null ? !title.equals(video.title) : video.title != null) return false;
        if (longDescription != null ? !longDescription.equals(video.longDescription) : video.longDescription != null)
            return false;
        return !(videoUrl != null ? !videoUrl.equals(video.videoUrl) : video.videoUrl != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (longDescription != null ? longDescription.hashCode() : 0);
        result = 31 * result + (videoUrl != null ? videoUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                '}';
    }
}
