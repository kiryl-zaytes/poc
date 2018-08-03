package com.nbc.testautomation.chillertv.businessobject;

import java.util.HashSet;
import java.util.Set;

/**
 * Season object of application domain model. Used for storing properties of any particular season: title, description, etc.
 */
public class Season {

    private String id;

    private String title;

    Set<Episode> episodes = new HashSet<Episode>();

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

    public Set<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Set<Episode> episodes) {
        this.episodes = episodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Season)) return false;

        Season season = (Season) o;

        if (id != null ? !id.equals(season.id) : season.id != null) return false;
        if (title != null ? !title.equals(season.title) : season.title != null) return false;
        return episodes != null ? episodes.equals(season.episodes) : season.episodes == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (episodes != null ? episodes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Season{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", episodes=" + episodes +
                '}';
    }
}
