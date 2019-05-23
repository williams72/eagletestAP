package com.dilatoit.eagletest.annotation;

import java.lang.annotation.*;

/**
 * 性能检测注解，用于测试某个方法的执行时间
 * Created by xueshan.wei on 3/28/2017.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PerformanceTime {
    String value() default "";
}
