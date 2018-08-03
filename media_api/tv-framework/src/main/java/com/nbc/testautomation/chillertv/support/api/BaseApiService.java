package com.nbc.testautomation.chillertv.support.api;

import com.nbc.testautomation.chillertv.support.configuration.EnvironmentConfiguration;
import com.nbc.testautomation.http.HttpProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by mk on 12/31/15.
 */
public class BaseApiService {

    @Autowired
    @Qualifier("httpProvider")
    protected HttpProvider httpProvider;

    @Autowired
    protected EnvironmentConfiguration environmentConfiguration;

    @Autowired
    protected ApiEndpoints apiEndpoints;
}
