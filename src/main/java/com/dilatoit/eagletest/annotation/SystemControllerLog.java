package com.dilatoit.eagletest.annotation;

import com.dilatoit.eagletest.enums.log.SystemLog;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解 拦截Controller
 * @author xueshan.wei
 *
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemControllerLog {
	SystemLog systemLog() default SystemLog.LOG_DEFAULT;

}
