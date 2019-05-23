package com.dilatoit.eagletest.aop;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.authority.util.AuthorityTools;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtResPer;
import com.dilatoit.eagletest.model.EtRole;
import com.dilatoit.eagletest.model.EtUser;
import com.dilatoit.eagletest.service.impl.ServiceManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthorityAspect {
    @Autowired
    private ServiceManager serviceManager;

    @Pointcut("@annotation(com.dilatoit.eagletest.annotation.A2)")
    public void authorityPoint() {

    }

    @Before("authorityPoint()")
    public void doAuthorityBefore(JoinPoint joinPoint) throws Exception {
        String [] permissions = getAnnotationPermission(joinPoint);
        if(hasPermission(permissions, 14)){
            System.out.println("有权限-------");
        }else{
            System.out.println("没有权限-----");
        }

    }

    public boolean hasPermission(String [] permissions, Integer userId) throws DataBaseException {
        EtUser user = serviceManager.getUserService().queryUserById(userId);
        if(permissions != null && permissions.length > 0){
            //得到该用户的所有权限
            List<String> u_permissions = new ArrayList<String>();
            for(EtRole role : user.getEtRoles()){
                for(EtResPer resPer : role.getResPers()){
                    u_permissions.add(resPer.getResourcePermission());
                    //System.out.println("用户拥有的权限：" + resPer.getResourcePermission());
                }
            }

            for(String permission : permissions){
                //System.out.println(permission);
                //System.out.println("解析权限------------------");
                List<String> ps = AuthorityTools.parsePermission(permission);

                for(String p : ps){
                    //System.out.println("当前检查权限：" + p);
                    if(!u_permissions.contains(p)){
                        return false;
                    }
                }
            }
            return true;
        }
        return true;
    }

    public static String[] getAnnotationPermission(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        @SuppressWarnings("rawtypes")
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String permissions[] = null;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                @SuppressWarnings("rawtypes")
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    permissions = method.getAnnotation(AuthorityCheck.class).permission();
                    break;
                }
            }
        }
        return permissions;
    }
}
