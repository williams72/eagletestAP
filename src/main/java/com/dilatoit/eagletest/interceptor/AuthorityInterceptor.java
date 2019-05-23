package com.dilatoit.eagletest.interceptor;


import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.authority.AuthorityVerify;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.exception.ex.AuthenticationException;
import com.dilatoit.eagletest.exception.ex.api.ApiBusinessException;
import com.dilatoit.eagletest.model.EtUser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by xueshan.wei on 12/7/2016.
 */
public class AuthorityInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private AuthorityVerify authorityVerify;
    private List<String> uncheckUrls;
    private List<String> createTaskStep;

    private static Logger LOGGER = Logger.getLogger(AuthorityInterceptor.class);

    public void setCreateTaskStep(List<String> createTaskStep) {
        this.createTaskStep = createTaskStep;
    }

    public void setUncheckUrls(List<String> uncheckUrls) {
        this.uncheckUrls = uncheckUrls;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());

        LOGGER.debug("当前路径为-" + url);
        if(uncheckUrls.contains(url)){
            return true;
        }
        HandlerMethod method = null;
        //处理Permission Annotation，实现方法级权限控制
        if (handler instanceof HandlerMethod){
            method = (HandlerMethod)handler;
        }else {
            return true;
        }

        AuthorityCheck authorityCheck = method.getMethodAnnotation(AuthorityCheck.class);


        //为空表示不需要权限效验
        if(authorityCheck == null){
            return true;
        }

        //验证是否登录
        HttpSession session = request.getSession();
        EtUser user = (EtUser) session.getAttribute("currentUser");
        if(user != null){
            //用户已登录，进行权限校验
            LOGGER.debug("用户已登录，进行权限校验");
            if(authorityVerify.hasPermission(authorityCheck.permission(), user.getId())){
                //用户拥有权限，放行
                LOGGER.debug("用户拥有权限，放行吧");
                return true;
            }
            LOGGER.debug("用户没有权限，返回错误提示");
            if(url.indexOf("/api/") != -1) {
                throw new ApiBusinessException(ExceptionEnum.NO_PERMISSION_ERROR);
            }else{
                throw new AuthenticationException(ExceptionEnum.NO_PERMISSION_ERROR);
            }
        }else{
            //判断是返回页面异常还是API异常
            if(url.indexOf("/api/") != -1){
                throw new ApiBusinessException(ExceptionEnum.USER_NOT_LOGIN);
            }else{
                LOGGER.debug("用户未登录，转到登录页面，并记录用户当前访问路径" + url);
                //用户未登录，转到登录页面，并记录用户当前访问路径

                //用户seesion 失效时处于创建任务的步骤中，登陆后返回第一步
                if(url.endsWith("createtask_2")){
                    url = url.replaceFirst("createtask_2", "createtask");
                }
                if(url.endsWith("createtask_3")){
                    url = url.replaceFirst("createtask_3", "createtask");
                }
                session.setAttribute("lastAccessPath", url);
                response.sendRedirect(contextPath + "/login");
                return false;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
