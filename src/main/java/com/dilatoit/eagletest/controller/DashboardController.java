package com.dilatoit.eagletest.controller;


import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.version.VersionStatus;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.*;
import com.dilatoit.engine.exception.EngineException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by xueshan.wei on 1/5/2017.
 */
@Controller
@RequestMapping
public class DashboardController extends BaseController{
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
     * 版本类型成功率
     * @throws BusinessException
     */
    @RequestMapping(value = "/project/{projectId}/versubrate")
    public void versionSubtaskSuccessRate(@PathVariable Integer projectId) throws BusinessException{
        try{
            Map result = serviceManager.getProjectDashboardService().rateOfVersionAndSubtaskType(projectId);
            this.renderObj(result);
        }catch (DataBaseException dbe){
            throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
    }
    @RequestMapping(value = "/project/{projectId}/dashboard")
    @AuthorityCheck
    public ModelAndView toDashboardPage(@PathVariable Integer projectId) throws BusinessException{
        ModelAndView mv = new ModelAndView("project/project_dashboard");
        try{
            //加载当前项目信息
            EtProject currentProject = serviceManager.getProjectService().queryById(projectId);
            mv.addObject("currentProject", currentProject);
            //加载当前登录用户在该项目中的用户
            EtProjectUser currentProjectUser = null;
            EtUser currentUser = (EtUser) session.getAttribute("currentUser");
            for(EtProjectUser pu : currentProject.getEtProjectUsers()){
                if(currentUser.getId().equals(pu.getEtUser().getId())){
                    currentProjectUser = pu;
                }
            }
            mv.addObject("currentProjectUser", currentProjectUser);
            //加载版本信息
            List<EtVersion> versions = serviceManager.getVersionService().queryAllByProId(projectId);
            int notReleaseVersion = 0;
            int releaseVersion = 0;
            int versionNum = 0;
            if(versions != null && versions.size() > 0){
                versionNum = versions.size();
                for(EtVersion version : versions){
                    if(version.getVersionStatus() == VersionStatus.IN_GA.value()){
                        releaseVersion ++;
                    }else {
                        notReleaseVersion ++;
                    }
                }
            }

            mv.addObject("versionNum", versionNum);
            mv.addObject("notReleaseVersion", notReleaseVersion);
        }catch (DataBaseException dbe){
            throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }

        return mv;
    }
}
