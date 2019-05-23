package com.dilatoit.eagletest.controller;


import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.annotation.SystemControllerLog;
import com.dilatoit.eagletest.enums.log.SystemLog;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.*;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;
import com.dilatoit.engine.exception.EngineException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by beishan on 2016/11/15.
 */
@Controller
@RequestMapping
public class VersionController extends BaseController {
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
     * 查看某个项目下的所有app
     * @param projectId
     * @param offset
     * @param limit
     * @return
     * @throws EngineException
     * @throws DataBaseException
     * @throws BusinessException
     */
    @RequestMapping(value = "/project/{projectId}/versions", method = RequestMethod.GET)
    @AuthorityCheck
    public ModelAndView queryPage(@PathVariable Integer projectId, @RequestParam(defaultValue = "1") Integer offset,
                                  @RequestParam(defaultValue = "10") Integer limit) throws EngineException, DataBaseException, BusinessException{
        ModelAndView mv = new ModelAndView("project/project_version");
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
        //加载当前所有version
        DataPage<EtVersion> page = new DataPage<EtVersion>();
        page.setOffsetLimit(offset, limit);
        Conditions conditions = new Conditions();
        conditions.addCondition("etProject.id", projectId, Conditions.Operator.EQUAL);
        serviceManager.getVersionService().page(page, conditions);
        mv.addObject("page", page);
        return mv;
    }

    /**
     * 增加一个版本
     * @param projectId
     * @param version
     * @return
     * @throws EngineException
     * @throws DataBaseException
     * @throws BusinessException
     */
    @RequestMapping(value = "/project/{projectId}/version", method = RequestMethod.POST)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.VERSION_CREATE)
    public String createVersion(@PathVariable Integer projectId, EtVersion version) throws EngineException, DataBaseException, BusinessException{
        serviceManager.getVersionService().addVersion(version, projectId);
        return "redirect:/project/" + projectId + "/versions";
    }
    @RequestMapping(value = "/project/{projectId}/version/{versionId}")
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.VERSION_UPDATE_STATUS)
    public void changeVersionStatus(@PathVariable Integer projectId, @PathVariable Integer versionId,
            @RequestParam Integer status) throws DataBaseException, BusinessException{
        serviceManager.getVersionService().changeVersionStatus(versionId, status);
        this.render("{\"status\":\"success\"}");
    }

}
