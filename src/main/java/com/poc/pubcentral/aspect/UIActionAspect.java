package com.poc.pubcentral.aspect;

import ch.qos.logback.classic.Logger;
import com.poc.pubcentral.constant.LoggerPatterns;
import com.poc.pubcentral.utils.LogUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kiryl_zayets on 9/16/15.
 */

@Aspect
@Configuration
public class UIActionAspect {
    Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @Autowired LogUtils logUtils;

    @Before("pageMethods() && args(params,..)")
    public void beforeUIInteraction(JoinPoint joinPoint, Object params) {
        String pattern = String.format(LoggerPatterns.ACTION_MESSAGE,
                joinPoint.getTarget().getClass().getSuperclass()
                        .getSimpleName(),
                joinPoint.getSignature().getName(), params);
        logger.info(pattern);
    }

    @After("pageMethods()")
    public void afterUIInteraction(JoinPoint joinPoint) {
        String pattern = String.format(LoggerPatterns.ACTION_FINESHED,
                joinPoint.getTarget().getClass().getSuperclass()
                        .getSimpleName(),
                joinPoint.getSignature().getName());
        logUtils.screenAndLog(pattern);
    }

    @Pointcut("execution(* *(..) )&& " +
                      "within(com.nbcuni.pubcentral.page..*)|| " +
                      "within(com.nbcuni.pubcentral.page.content..*)|| " +
                      "within(com.nbcuni.pubcentral.page.content.drupal..*)")
    public void pageMethods() {}

}
