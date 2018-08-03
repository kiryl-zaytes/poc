package com.poc.pubcentral.common.driver.bpp;

import com.poc.pubcentral.common.driver.annotations.CustomCapabilities;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * Created by kiryl_zayets on 6/28/15.
 */
public class CapabilitiesPostProcessor implements BeanPostProcessor {

    @Autowired
    ConfigurableListableBeanFactory factory;

    @Autowired
    ApplicationContext context;

    @Override
    public Object postProcessBeforeInitialization(Object o,
            String s) throws BeansException {
        Field[] fields = o.getClass().getSuperclass().getDeclaredFields();
        for (Field field : fields) {
            CustomCapabilities customCapabilities = field.getAnnotation
                    (CustomCapabilities.class);
            if (customCapabilities != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, o, context.getBean(System
                        .getProperty("browser")));
            }
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o,
            String s) throws BeansException {
        return o;
    }
}
