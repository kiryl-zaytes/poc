package com.poc.pubcentral.common.driver.bpp;


import com.poc.pubcentral.common.driver.annotations.PageMarker;
import com.poc.pubcentral.common.driver.configuration.SeleniumContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

/**
 * Created by kiryl_zayets on 6/30/15.
 */
public class PagePostProcessor implements BeanPostProcessor {

    @Autowired
    ConfigurableListableBeanFactory configurableListableBeanFactory;

    @Override
    public Object postProcessBeforeInitialization(Object o,
            String s) throws BeansException {
        PageMarker page = o.getClass().getSuperclass().getAnnotation
                (PageMarker.class);
        if (page != null) {
            Object beanDefinition = configurableListableBeanFactory.getBean
                    ("seleniumContext");
            WebDriver webDriver = ((SeleniumContext) beanDefinition)
                    .getDriver();
            PageFactory.initElements(new HtmlElementDecorator(webDriver), o);
        }

        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o,
            String s) throws BeansException {
        return o;
    }
}
