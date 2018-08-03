package com.nbc.testautomation.saucelabs;

import com.saucelabs.saucerest.SauceREST;

public interface SauceLabsRestAware {

    SauceREST getSauceREST();

    String getSessionId();
}
