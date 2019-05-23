package com.dilatoit.eagletest.controller;

import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.dto.WeaknetDTO;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtProject;
import com.dilatoit.eagletest.model.EtRealMobile;
import com.dilatoit.eagletest.model.EtUser;
import com.dilatoit.eagletest.model.EtUserConfig;
import com.dilatoit.eagletest.query.model.BaseQuery;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;
import com.dilatoit.engine.exception.EngineException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by xueshan.wei on 4/19/2017.
 */
@RequestMapping
@Controller
public class WeaknetController extends BaseController {
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

    /**
     * 转到弱网管理页面
     * @param baseQuery
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/weaknets")
    @AuthorityCheck
    public ModelAndView toWeakListPage(BaseQuery baseQuery) throws BusinessException{
        ModelAndView mv = new ModelAndView("system/sys_setting_weaknet");
        DataPage<WeaknetDTO> page = new DataPage<>();
        page.setOffsetLimit(baseQuery.getOffset(), baseQuery.getLimit());
        Conditions conditions = new Conditions();
        try {
            serviceManager.getWeaknetService().queryPage(page, conditions);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new BusinessException(e.getEe());
        }
        mv.addObject("page", page);
        return mv;
    }
}
