package com.dilatoit.eagletest.controller;

import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtProject;
import com.dilatoit.eagletest.model.EtRealMobile;
import com.dilatoit.eagletest.model.EtUser;
import com.dilatoit.eagletest.model.EtUserConfig;
import com.dilatoit.eagletest.util.DataPage;
import com.dilatoit.engine.exception.EngineException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Salt on 2017/9/18.
 */

@Controller
@RequestMapping
public class PyLibController extends BaseController {
    @ModelAttribute
    public void loadNeedData(HttpSession session, Model model) throws BusinessException, EngineException, DataBaseException {
        //加载当前用户信息
        EtUser currentUser = (EtUser) session.getAttribute("currentUser");
        //用户未登录不需要加载
        if(currentUser != null){
            //加载用户当前正在调试的手机
            List<EtRealMobile> currentRms = serviceManager.getRealMobileService().currentRealMobiles(currentUser.getId());
            model.addAttribute("currentRms", currentRms);
            //加载用户信息
            EtUser userDetail = serviceManager.getUserService().queryUserById(currentUser.getId());
            model.addAttribute("userDetail", userDetail);
            //加载用户的最近三个项目
            EtUserConfig userConfig = userDetail.getEtUserConfig();
            List<String> pids = userConfig.someRecentProject();
            List<EtProject> recentProjects = serviceManager.getProjectService().querySomeProject(pids);
            model.addAttribute("recentProjects", recentProjects);
        }
    }

    @RequestMapping(value = "/python/libraries", method = RequestMethod.GET)
    @AuthorityCheck
    public ModelAndView getAllLibraries(@RequestParam(defaultValue = "1") Integer offset, @RequestParam(defaultValue = "10") Integer limit) throws EngineException, BusinessException, DataBaseException{
        ModelAndView mv = new ModelAndView("system/sys_pythonlib_manager");
       /* DataPage<EtProject> page = new DataPage<EtProject>();
        page.setOffset(offset);
        page.setLimit(limit);

        serviceManager.getProjectService().page(page);
        mv.addObject("page", page);*/
        return mv;
    }

    @RequestMapping(value = "/python/library/create", method = RequestMethod.GET)
    @AuthorityCheck
    public ModelAndView createLibrary() throws EngineException, BusinessException, DataBaseException{
        ModelAndView mv = new ModelAndView("system/sys_pythonlib_create");
       /* DataPage<EtProject> page = new DataPage<EtProject>();
        page.setOffset(offset);
        page.setLimit(limit);

        serviceManager.getProjectService().page(page);
        mv.addObject("page", page);*/
        return mv;
    }
}
