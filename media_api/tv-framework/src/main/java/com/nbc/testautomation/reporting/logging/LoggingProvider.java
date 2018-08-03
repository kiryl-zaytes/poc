package com.nbc.testautomation.reporting.logging;

/**
 * Interface for classes which provide particular implementations of loggers
 */
public interface LoggingProvider {

    void info(Class<?> loggerName, String message);
}
