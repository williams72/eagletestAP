package com.dilatoit.eagletest.aop;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dilatoit.eagletest.annotation.SystemControllerLog;
import com.dilatoit.eagletest.enums.LogTypeEnum;
import com.dilatoit.eagletest.enums.log.SystemLog;
import com.dilatoit.eagletest.model.EtLog;
import com.dilatoit.eagletest.model.EtUser;
import com.dilatoit.eagletest.service.impl.ServiceManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import org.springframework.web.servlet.support.RequestContext;

@Aspect
@Component
public class SystemLogAspect {
	@Autowired
	ServiceManager serviceManager;
	@Pointcut("@annotation(com.dilatoit.eagletest.annotation.SystemServiceLog)")
	public void serviceAspect(){
		
	}
	
	@Pointcut("@annotation(com.dilatoit.eagletest.annotation.SystemControllerLog)")
	public void controllerAspect(){
		
	}
	
	@Before("serviceAspect()")
	public void doServiceBefore(JoinPoint joinPoint) throws Exception{
		
	}
	
	@Before("controllerAspect()")
	public void doControllerBefore(JoinPoint joinPoint) throws Exception{
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		RequestContext requestContext = new RequestContext(request);
		HttpSession session = request.getSession();
		EtUser user = (EtUser) session.getAttribute("currentUser");
		
		String operator = "no user";
		String ip = "";
		String param = "";
		String url = "";

		if(user != null){
			operator = user.getUsername();
		}
		//get the log detail
		ip = request.getRemoteAddr();
		SystemLog systemLog = getControllerMethodDescription(joinPoint);
		param = "";
		url = request.getServletPath();
		//Object[] args = joinPoint.getArgs();
		/*for(Object obj : args){
			param += obj.toString();
		}*/
		EtLog log = new EtLog();

		log.setIp(ip);
		log.setOperationCode(systemLog.getCode());
		log.setOperation(requestContext.getMessage(systemLog.getCode()));
		log.setOperator(operator);
		log.setOperateTime(new Date());
		log.setParam(param);
		log.setUrl(url);
        log.setLogType(LogTypeEnum.LOG_OPERATE.value());
		//write log to db
		serviceManager.getLogService().save(log);
	}
	
	
	@After("controllerAspect()")
	public void doControllerAfter(JoinPoint joinPoint) throws Exception{

	}

     /**
      * 获取注解中对方法的描述信息 用于Controller层注解  
      * @param joinPoint
      * @return method description
      * @throws Exception
      */
     @SuppressWarnings("rawtypes")
	public static SystemLog getControllerMethodDescription(JoinPoint joinPoint) throws Exception{
    	 String targetName = joinPoint.getTarget().getClass().getName();
         String methodName = joinPoint.getSignature().getName();
         Object[] arguments = joinPoint.getArgs();
         Class targetClass = Class.forName(targetName);
         Method[] methods = targetClass.getMethods();
         SystemLog systemLog = null;
         for (Method method : methods) {
             if (method.getName().equals(methodName)) {
                 Class[] clazzs = method.getParameterTypes();
                 if (clazzs.length == arguments.length) {
					 systemLog = method.getAnnotation(SystemControllerLog.class).systemLog();
                     break;    
                 }
             }
         }
         return systemLog;
     }
}
