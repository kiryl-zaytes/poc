package com.nbc.testautomation.reporting;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for defining ID of test case for mapping with test management system
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface TestCase {

    /**
     * Test Case ID
     *
     * @return Test Case ID
     */
    String[] id();
}
