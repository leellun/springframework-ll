package org.springframework.web.annotation;

import java.lang.annotation.*;

/**
 * @author leellun
 * @date 2020/2/7 19:42
 * @desc
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestParam {

    String value() default "";
}
