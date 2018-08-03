package com.nbc.testautomation.chillertv.support.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Environment specific parameters.
 * <p/>
 * Defining as prototype to avoid collisions in multi threading, e.g. access to object while it's destroying, etc.
 */
@Component
@Scope("prototype")
public class EnvironmentConfiguration {

    @Value(value = "${application.url}")
    private String applicationUrl;

    @Value(value = "${api.host}")
    private String apiHost;

    public String getApplicationUrl() {
        return applicationUrl;
    }

    public void setApplicationUrl(String applicationUrl) {
        this.applicationUrl = applicationUrl;
    }

    public String getApiHost() {
        return apiHost;
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
