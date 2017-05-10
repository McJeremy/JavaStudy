package com.xuzz.study.annotation;

import java.lang.annotation.*;

/**
 * Created by xuzz on 2016/12/13.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    /**
     * &#x4f9b;&#x5e94;&#x5546;&#x7f16;&#x53f7;
     * @return*/
    public int id() default -1;

    /**
     * 供应商名称
     * @return*/public String name() default "";

    /**
     * 供应商地址
     * @return*/public String address() default "";
}
