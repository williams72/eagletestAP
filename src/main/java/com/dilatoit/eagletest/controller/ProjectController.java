package com.dilatoit.eagletest.controller;


import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.annotation.SystemControllerLog;
import com.dilatoit.eagletest.enums.log.SystemLog;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

/**
 * Created by beishan on 2016/11/15.
 */
@Controller
@RequestMapping
public class ProjectController extends BaseController {
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
    @RequestMapping(value = "/moreproject")
    @AuthorityCheck
    public ModelAndView moreProject() throws EngineException, DataBaseException, BusinessException{
        ModelAndView mv = new ModelAndView("project/project_all");
        EtUser currentUser = (EtUser) session.getAttribute("currentUser");
        currentUser = serviceManager.getUserService().queryUserById(currentUser.getId());
        List<EtProject> projects = currentUser.getEtProjects();
        Collections.reverse(projects);
        /*Conditions conditions = new Conditions();
        conditions.addCondition("");
        List<EtProject> projects = serviceManager.getProjectService().queryAll();*/
        mv.addObject("projects", projects);
        return mv;
    }
    /**
     * 转到项目创建页面
     * @return
     */
    @RequestMapping(value = "/projectcreate", method = RequestMethod.GET)
    @AuthorityCheck
    public ModelAndView pageToCreate() throws BusinessException, EngineException, DataBaseException{
        ModelAndView mv = new ModelAndView("system/sys_project_create");
        //添加所有用户信息
        List<EtUser> users = serviceManager.getUserService().queryAll();
        mv.addObject("users", users);
        return mv;
    }
    /**
     * 显示项目列表
     * @return
     * @throws EngineException
     * @throws DataBaseException
     */
    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    @AuthorityCheck
    public ModelAndView getAllProjects(@RequestParam(defaultValue = "1") Integer offset, @RequestParam(defaultValue = "10") Integer limit) throws EngineException, BusinessException, DataBaseException{
        ModelAndView mv = new ModelAndView("system/sys_project_manager");
        DataPage<EtProject> page = new DataPage<EtProject>();
        page.setOffset(offset);
        page.setLimit(limit);

        serviceManager.getProjectService().page(page);
        mv.addObject("page", page);
        return mv;
    }

    /**
     * create a new project
     * api : POST /project
     * @throws EngineException
     * @throws DataBaseException
     */
    @RequestMapping(value = "/project", method = RequestMethod.POST)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.PROJECT_CREATE)
    public void createProject(EtProject project, @RequestParam Integer userId) throws BusinessException, DataBaseException{

        //获取创建人 主要用于设置项目创建者
        //EtUser user = (EtUser) session.getAttribute("currentUser");
        //创建项目 并 设置项目管理员
        Integer projectId = serviceManager.getProjectService().addProject(project, userId);

        EtProject newPro = serviceManager.getProjectService().queryById(projectId);
        this.renderObj(newPro);

    }

    /**
     * delete a project
     * api : DELETE /project/{projectId}
     * @param projectId
     * @throws EngineException
     * @throws DataBaseException
     */
    @RequestMapping(value = "/project/{projectId}", method = RequestMethod.DELETE)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.PROJECT_DELETE)
    public void deleteProject(@PathVariable Integer projectId) throws EngineException, DataBaseException{

    }

    /**
     * query a project
     * api : GET /project/{projectId}
     * @param projectId
     * @throws EngineException
     * @throws DataBaseException
     */
    @RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
    @AuthorityCheck
    public ModelAndView queryProject(@PathVariable Integer projectId) throws EngineException, DataBaseException{
        ModelAndView mv = new ModelAndView("redirect:/project/" + projectId + "/tasks");
        //记住当前浏览的项目，以便下次登陆后直接进入到上次浏览的项目
        EtUser currentUser = (EtUser) session.getAttribute("currentUser");
        EtUser needUpdateUser = serviceManager.getUserService().queryUserById(currentUser.getId());
        needUpdateUser.getEtUserConfig().setLastViewProject(projectId.toString());
        needUpdateUser.getEtUserConfig().updateRecentProject(projectId.toString());
        serviceManager.getUserService().updateUser(needUpdateUser);
        return mv;
    }

    /**
     * update a project
     * api : PUT /project/{projectId}
     * @param projectId
     * @throws EngineException
     * @throws DataBaseException
     */
    @RequestMapping(value = "/project/{projectId}", method = RequestMethod.PUT)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.PROJECT_UPDATE)
    public void updateProject(@PathVariable Integer projectId) throws EngineException, DataBaseException{

    }

}
