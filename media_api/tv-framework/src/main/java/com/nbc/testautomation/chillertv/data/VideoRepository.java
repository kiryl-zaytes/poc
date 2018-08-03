package com.nbc.testautomation.chillertv.data;

import com.nbc.testautomation.chillertv.businessobject.Video;

/**
 * Interface for provide functionality of retrieving test data from some storage: in-memory database, text file,
 * comma-separated file (CSV), Google Sheet, etc.
 */
public interface VideoRepository {

    Video getById(String id);
}
