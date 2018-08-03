package com.nbc.testautomation.reporting.logging;

/**
 * Class-wrapper for provide logging. Any other logging provider can be used (Log4j, Logback, etc.) - the goal of this call is to provide common interface and encapsulate direct interaction with particular logger implementation
 */
public class Logger {

    protected Class<?> loggerName;

    protected LoggingProvider loggingProvider = new Sl4jLoggingProvider();

    public Logger(Class<?> loggerName) {
        this.loggerName = loggerName;
    }

    public void info(String message) {
        loggingProvider.info(loggerName, message);
    }

}
