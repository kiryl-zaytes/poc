package com.nbc.testautomation.reporting.logging;

import org.slf4j.LoggerFactory;

/**
 * SL4J logger implementation
 */
public class Sl4jLoggingProvider implements LoggingProvider {

    public void info(Class<?> loggerName, String message) {
        org.slf4j.Logger loggingProvider = LoggerFactory.getLogger(loggerName);
        loggingProvider.info(message);
    }
}
