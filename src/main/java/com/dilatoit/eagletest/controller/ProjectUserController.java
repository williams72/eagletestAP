package com.dilatoit.eagletest.controller;

import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.annotation.SystemControllerLog;
import com.dilatoit.eagletest.enums.ProjectUserRole;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by beishan on 2016/11/24.
 */
@Controller
@RequestMapping
public class ProjectUserController extends BaseController {
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
     * project member manager
     * @param projectId
     * @param offset
     * @param limit
     * @return
     * @throws EngineException
     * @throws DataBaseException
     * @throws BusinessException
     */
    @RequestMapping(value = "/project/{projectId}/users")
    @AuthorityCheck
    public ModelAndView projectUsers(@PathVariable Integer projectId, @RequestParam(defaultValue = "1") Integer offset,
                                     @RequestParam(defaultValue = "10") Integer limit) throws EngineException, DataBaseException, BusinessException {
        ModelAndView mv = new ModelAndView("project/project_user");
        //加载当前项目信息
        EtProject currentProject = serviceManager.getProjectService().queryById(projectId);
        //加载所有用户信息
        List<EtUser> users = serviceManager.getUserService().queryAll();
        //加载当前登录用户在该项目中的用户
        EtProjectUser currentProjectUser = null;
        EtUser currentUser = (EtUser) session.getAttribute("currentUser");
        for(EtProjectUser pu : currentProject.getEtProjectUsers()){
            if(currentUser.getId().equals(pu.getEtUser().getId())){
                currentProjectUser = pu;
            }
        }
        mv.addObject("currentProjectUser", currentProjectUser);
        //加载项目成员列表
        DataPage<EtProjectUser> page = new DataPage<EtProjectUser>();
        page.setOffset(offset);
        page.setLimit(limit);
        Conditions conditions = new Conditions();
        conditions.addCondition("etProject.id", projectId, Conditions.Operator.EQUAL);
        serviceManager.getProjectUserService().page(page, conditions);

        //去除已经在本项目中的成员 从users中
        List<EtProjectUser> pusers = serviceManager.getProjectUserService().queryAllMemberByPid(projectId);
        List<EtUser> users1 = new ArrayList<EtUser>();
        if(users != null && users.size() > 0 && pusers != null && pusers.size() > 0){
            for(EtUser u : users){
                boolean isExist = false;
                for(EtProjectUser pu : pusers){
                    if(u.getId() == pu.getEtUser().getId()){
                        isExist = true;
                        break;
                    }
                }
                if(!isExist){
                    users1.add(u);
                }
            }
        }

        mv.addObject("currentProject", currentProject);
        mv.addObject("page", page);
        mv.addObject("users", users1);
        return mv;
    }

    /**
     * add a user to project
     * @param projectId
     * @param userId
     * @param roleValue
     * @throws EngineException
     * @throws BusinessException
     * @throws DataBaseException
     */
    @RequestMapping(value = "/project/{projectId}/user", method = RequestMethod.POST)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.PROJECT_USER_ADD)
    public String addProjectUser(@PathVariable Integer projectId, @RequestParam String userId, @RequestParam Integer roleValue) throws EngineException, BusinessException, DataBaseException {
        ProjectUserRole pur = null;
        //处理userId 因为前台传递过来的是 1,u1025.png（用户id,用户头像） 这样的参数
        String str[] = userId.split(",");
        Integer realUserId = Integer.parseInt(str[0]);
        switch (roleValue) {
            case 1:
                pur = ProjectUserRole.ADMIN;
                break;
            case 2:
                pur = ProjectUserRole.TESTER;
                break;
            case 3:
                pur = ProjectUserRole.VIEWER;
                break;
            default:
                pur = ProjectUserRole.VIEWER;
                break;
        }
        serviceManager.getProjectUserService().addUser(projectId, realUserId, pur);

        return "redirect:/project/" + projectId + "/users";
    }

    /**
     * remove a user form project
     * @param projectId
     * @param userId
     * @throws EngineException
     * @throws BusinessException
     * @throws DataBaseException
     */
    @RequestMapping(value = "/project/{projectId}/user", method = RequestMethod.DELETE)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.PROJECT_USER_REMOVE)
    public void removeProjectUser(@PathVariable Integer projectId, @RequestParam Integer userId) throws EngineException, BusinessException, DataBaseException {
        serviceManager.getProjectUserService().removeUser(projectId, userId);
        this.render("{\"status\":\"success\"}");
    }

    /**
     * change a user`s role in a project
     * @param projectId
     * @param userId
     * @param roleValue
     * @throws EngineException
     * @throws BusinessException
     * @throws DataBaseException
     */
    @RequestMapping(value = "/project/{projectId}/user/{userId}", method = RequestMethod.PUT)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.PROJECT_USER_CHANGE_ROLE)
    public void changeRole(@PathVariable Integer projectId, @PathVariable Integer userId, @RequestParam Integer roleValue)
            throws EngineException, BusinessException, DataBaseException {
        ProjectUserRole pur = null;
        switch (roleValue) {
            case 1:
                pur = ProjectUserRole.ADMIN;
                break;
            case 2:
                pur = ProjectUserRole.TESTER;
                break;
            case 3:
                pur = ProjectUserRole.VIEWER;
                break;
            default:
                pur = ProjectUserRole.VIEWER;
                break;
        }
        serviceManager.getProjectUserService().changeRole(projectId, userId, pur);
        this.render("{\"status\":\"success\"}");
    }
}
