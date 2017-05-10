package com.xuzz.study.annotation;

import java.lang.annotation.*;

/**
 * Created by xuzz on 2016/12/13.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
