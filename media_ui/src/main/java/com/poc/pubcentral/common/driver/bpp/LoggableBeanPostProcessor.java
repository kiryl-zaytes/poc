package com.poc.pubcentral.common.driver.bpp;

import com.poc.pubcentral.common.driver.annotations.Loggable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * Created by kiryl_zayets on 7/29/15.
 */
public class LoggableBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(final Object o,
            String s) throws BeansException {
        ReflectionUtils.doWithFields(o.getClass(), new ReflectionUtils
                .FieldCallback() {
            @Override
            @SuppressWarnings("unchecked")
            public void doWith(Field field) throws IllegalArgumentException,
                    IllegalAccessException {
                ReflectionUtils.makeAccessible(field);
                if (field.getAnnotation(Loggable.class) != null) {
                    Logger logger = LoggerFactory.getLogger(o.getClass());
                    field.set(o, logger);
                }
            }
        });
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o,
            String s) throws BeansException {
        return o;
    }
}
