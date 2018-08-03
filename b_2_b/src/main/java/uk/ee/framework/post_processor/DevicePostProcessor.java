package uk.ee.framework.post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by kiryl_zayets on 6/2/16.
 */
public class DevicePostProcessor implements BeanPostProcessor {

    @Autowired
    ConfigurableListableBeanFactory configurableListableBeanFactory;

    @Override
    public Object postProcessBeforeInitialization(Object o,
            String s) throws BeansException {
        String packageName = o.getClass().getSuperclass().getPackage()
                .getName();
        String runType = System.getProperty("type");
        if (null != runType && runType.contains("mobile")) {
            if (packageName.contains("pages")) {
                String className = o.getClass().getSimpleName();
                if (!className.equals("BasePage") &&
                        (!className.contains("Mobile"))) {
                    try {
                        return configurableListableBeanFactory.getBean(
                                s + "Mobile");
                    } catch (BeansException e) {
                        System.out.print("");
                    }
                }
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
