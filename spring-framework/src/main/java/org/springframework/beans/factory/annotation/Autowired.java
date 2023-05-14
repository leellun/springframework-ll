package org.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @author leellun
 * date: 2020-1-1 17:11
 * desc:
 **/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {

    boolean required() default true;
//    String value() default "";
}
