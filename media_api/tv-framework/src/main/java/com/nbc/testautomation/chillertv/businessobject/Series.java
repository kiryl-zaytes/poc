package com.nbc.testautomation.chillertv.businessobject;

/**
 * Series object of application domain model. Used for storing properties of any particular series: title, description, image source.
 */
public class Series {

    private String id;

    private String seriesTitle;

    private String seriesLongDescription;

    private String imageUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeriesTitle() {
        return seriesTitle;
    }

    public void setSeriesTitle(String title) {
        this.seriesTitle = seriesTitle;
    }

    public String getSeriesLongDescription() {
        return seriesLongDescription;
    }

    public void setLongDescription(String seriesLongDescription) {
        this.seriesLongDescription = seriesLongDescription;
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
        if (!(o instanceof Series)) return false;

        Series series = (Series) o;

        if (id != null ? !id.equals(series.id) : series.id != null) return false;
        if (seriesTitle != null ? !seriesTitle.equals(series.seriesTitle) : series.seriesTitle != null) return false;
        if (seriesLongDescription != null ? !seriesLongDescription.equals(series.seriesLongDescription) : series.seriesLongDescription != null)
            return false;
        return !(imageUrl != null ? !imageUrl.equals(series.imageUrl) : series.imageUrl != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (seriesTitle != null ? seriesTitle.hashCode() : 0);
        result = 31 * result + (seriesLongDescription != null ? seriesLongDescription.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Series{" +
                "id='" + id + '\'' +
                ", seriesTitle='" + seriesTitle + '\'' +
                ", seriesLongDescription='" + seriesLongDescription + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

}
