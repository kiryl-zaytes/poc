package com.poc.pubcentral.page;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by kiryl_zayets on 10/13/15.
 */
@Component
public class PageMapping {

    @Value("${app.url}")
    public String BASE;

    @Value("${app.login}")
    public String LOGIN;

    @Value("${app.user}")
    public String USER;

    @Value("${app.extend}")
    public String EXTEND;

    @Value("${app.single_import}")
    public String SINGLE_IMPORT;

    @Value("${app.people}")
    public String ADD_PEOPLE;

    @Value("${app.taxonomy}")
    public String TAXONOMY;

    @Value("${app.aws}")
    public String AWS;

    @Value("${app.create.article}")
    public String CREATE_ARTICLE;

    @Value("${app.create.event}")
    public String CREATE_EVENT;

    @Value("${app.create.series}")
    public String CREATE_SERIES;

    @Value("${app.create.season}")
    public String CREATE_SEASON;

    @Value("${app.create.episode}")
    public String CREATE_EPISODE;

    @Value("${app.create.image}")
    public String CREATE_IMAGE;

    @Value("${app.content}")
    public String CONTENT;

    @Value("${app.asset.library}")
    public String ASSET_LIBRARY;

};
