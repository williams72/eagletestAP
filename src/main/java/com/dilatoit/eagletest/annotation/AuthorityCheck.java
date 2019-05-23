package com.dilatoit.eagletest.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * simple authority check
 * @author xueshan.wei
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthorityCheck {
	//PermissionEnum permission() default PermissionEnum.PERMISSION_GENERAL;
    String[] permission() default "";
}
