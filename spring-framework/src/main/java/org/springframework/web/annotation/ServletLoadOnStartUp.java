package org.springframework.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author leellun
 * @date 2020/4/14 2:06
 * @desc
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ServletLoadOnStartUp {

    int loadOnStartUp() default 0;
}
