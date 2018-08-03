package uk.ee.framework.driver;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by kiryl_zayets on 6/1/16.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface Mobile {

    String id() default "";

    String css() default "";

    String xpath() default "";
}
