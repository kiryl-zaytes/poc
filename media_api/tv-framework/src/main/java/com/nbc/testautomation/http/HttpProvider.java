package com.nbc.testautomation.http;

/**
 * Created by mk on 12/31/15.
 */
public interface HttpProvider {

    <T> T get(String host, String path, Class<T> returnType);
}
