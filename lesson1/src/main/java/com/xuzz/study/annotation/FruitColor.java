package com.xuzz.study.annotation;

import java.lang.annotation.*;

/**
 * Created by xuzz on 2016/12/13.
 */
@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitColor {
    public enum Color{BULE,RED,GREEN};
    Color fruitColor() default Color.RED;
}
