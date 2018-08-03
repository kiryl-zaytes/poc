package uk.ee.framework.post_processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

public class LoggableBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(final Object o,
            String s) throws BeansException {
        ReflectionUtils.doWithFields(o.getClass(), field -> {
            ReflectionUtils.makeAccessible(field);
            if (field.getAnnotation(Loggable.class) != null) {
                Logger logger = LoggerFactory.getLogger(o.getClass());
                field.set(o, logger);
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
