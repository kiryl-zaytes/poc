package com.poc.pubcentral.bo;

import com.google.common.base.Objects;

/**
 * Created by kiryl_zayets on 10/17/15.
 */
public class Article {

    private int id;
    private String title;
    private String body;
    private String image;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equal(id, article.id) &&
                Objects.equal(title, article.title) &&
                Objects.equal(body, article.body) &&
                Objects.equal(image, article.image);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, title, body, image);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
