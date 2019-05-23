package com.dilatoit.eagletest.aop;


import com.dilatoit.eagletest.annotation.PerformanceTime;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by xueshan.wei on 3/28/2017.
 */
@Aspect
@Component
public class PerformanceTimeAspect {
    private long beginTime;
    private long endTime;
    private String methodName;

    private static Logger LOGGER = Logger.getLogger(PerformanceTimeAspect.class);

    @Pointcut("@annotation(com.dilatoit.eagletest.annotation.PerformanceTime)")
    public void performanceTimePoint(){

    }

    @Before("performanceTimePoint()")
    public void before(JoinPoint joinPoint) throws Exception{
        beginTime = System.currentTimeMillis();
        methodName = getAnnotationValue(joinPoint);
        LOGGER.debug("[" + methodName + "]方法执行开始");
    }

    @After("performanceTimePoint()")
    public void after(JoinPoint joinPoint) throws Exception{
        endTime = System.currentTimeMillis();
        long duringTime = endTime - beginTime;
        LOGGER.debug("[方法-" + methodName + "-执行时间]-["+ duringTime +"]");
    }

    public static String getAnnotationValue(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        @SuppressWarnings("rawtypes")
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String permission = null;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                @SuppressWarnings("rawtypes")
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    permission = method.getAnnotation(PerformanceTime.class).value();
                    break;
                }
            }
        }
        return permission;
    }
}
