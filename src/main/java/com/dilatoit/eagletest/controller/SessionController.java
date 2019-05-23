package com.dilatoit.eagletest.controller;


import com.dilatoit.eagletest.enums.UserConfig;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.model.EtUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by beishan on 2016/11/15.
 */
@Controller
@RequestMapping
public class SessionController extends BaseController{
    @RequestMapping(value = "/login")
    public ModelAndView toLoginPage(){
        ModelAndView mv = new ModelAndView("login");

        return mv;
    }
    @RequestMapping(value = "/session", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam String account, @RequestParam String password) throws BusinessException {
        ModelAndView mv = new ModelAndView();
        EtUser user = null;
        try{
            user = serviceManager.getUserService().login(account, password);
        }catch (BusinessException be){
            //登录出错跳转回登录页面，并显示错误信息
            RequestContext requestContent = new RequestContext(request);
            mv.setViewName("login");
            mv.addObject("errorMessage", requestContent.getMessage("login.page.error.message"));
            return mv;
        }

        HttpSession session = request.getSession();
        session.setAttribute("currentUser", user);


        //验证用户是第一次登录还是，session 失效后再次登录，回到失效之前的路径
        String lastAccessPath = (String) session.getAttribute("lastAccessPath");
        if(lastAccessPath == null || lastAccessPath.equals("")){
            //读取该用户配置，得到上次工作的项目
            String lastProject = user.getEtUserConfig().getLastViewProject();

            if(UserConfig.DEFAULT_LAST_PROJECT.value().equals(lastProject)){
                //用户初次访问,跳转到所有项目页面
                mv.setViewName("redirect:/moreproject");
            }else{
                String ctp = this.request.getContextPath();
                //跳转到上次访问的项目
                mv.setViewName("redirect:/project/" + lastProject);
            }
        }else{
            //跳转到上次访问路径
            mv.setViewName("redirect:" + lastAccessPath);
        }
        return mv;
    }
    @RequestMapping(value = "/session", method = RequestMethod.DELETE)
    public ModelAndView logoutSession(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        session.removeAttribute("currentUser");
        return mv;
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:/login");
        HttpSession session = request.getSession();
        session.removeAttribute("currentUser");
        return mv;
    }
}
