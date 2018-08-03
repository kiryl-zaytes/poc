package uk.ee.framework.utils;

import ch.qos.logback.classic.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import uk.ee.framework.post_processor.Loggable;


@Aspect
@Configuration
public class UIActionAspect {
    @Loggable protected Logger logger;
//    @Autowired LogUtils logUtils;

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
        logger.info(pattern);
//        logUtils.screenAndLog(pattern);
    }

    @Pointcut("execution(* *(..) )&& " +
                      "within(uk.ee.framework.pages..*)|| " +
                      "within(uk.ee.framework.pages.my_ee..*) ")
    public void pageMethods() {}

}