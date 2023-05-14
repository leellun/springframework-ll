package org.springframework.stereotype;

import java.lang.annotation.*;

/**
 * @author leellun
 * date: 2020-1-1 17:11
 * desc:
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Service {

    String value() default "";
}
