package com.dilatoit.eagletest.controller;


import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.annotation.SystemControllerLog;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.log.SystemLog;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.*;
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
public class UserController extends BaseController {
    @ModelAttribute
    public void loadNeedData(HttpSession session, Model model) throws BusinessException, EngineException, DataBaseException {
        //加载当前用户信息
        EtUser currentUser = (EtUser) session.getAttribute("currentUser");
        //用户未登录不需要加载
        if (currentUser != null) {
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
     * 分页查询用户
     *
     * @param offset
     * @param limit
     * @return
     * @throws DataBaseException
     * @throws EngineException
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @AuthorityCheck
    public ModelAndView userList(@RequestParam(defaultValue = "1") Integer offset, @RequestParam(defaultValue = "10") Integer limit) throws DataBaseException, EngineException {
        ModelAndView mv = new ModelAndView("user/user_manager");
        DataPage<EtUser> page = new DataPage<EtUser>();
        page.setLimit(limit);
        page.setOffset(offset);
        serviceManager.getUserService().page(page);
        mv.addObject("page", page);
        return mv;
    }

    /**
     * 禁用用户
     *
     * @param userId
     * @throws DataBaseException
     * @throws BusinessException
     */
    @RequestMapping(value = "/useraccess/{userId}", method = RequestMethod.DELETE)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.USER_DISABLE)
    public void disableUser(@PathVariable Integer userId) throws DataBaseException, BusinessException {
        serviceManager.getUserService().disableUser(userId);
        this.render("\"status\":\"success\"");
    }

    /**
     * 生效用户
     *
     * @param userId
     * @throws DataBaseException
     * @throws BusinessException
     */
    @RequestMapping(value = "/useraccess/{userId}", method = RequestMethod.POST)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.USER_ENABLE)
    public void enableUser(@PathVariable Integer userId) throws DataBaseException, BusinessException {
        serviceManager.getUserService().enableUser(userId);
        this.render("\"status\":\"success\"");
    }

    /**
     * 新增用户
     *
     * @param username
     * @param email
     * @param password
     * @throws DataBaseException
     * @throws BusinessException
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.USER_ADD)
    public void addUser(@RequestParam String username, @RequestParam String email, @RequestParam String password) throws DataBaseException, BusinessException {

        EtUser user = new EtUser();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setAvatars("user_default.png");
        serviceManager.getUserService().addUser(user);
        this.render("\"status\":\"success\"");
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.USER_DELETE)
    public ModelAndView deleteUser(@RequestParam Integer userId) {
        ModelAndView mv = new ModelAndView();

        return mv;
    }

    /**
     * 查询单个用户信息
     *
     * @param userId
     * @throws DataBaseException
     */
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    @AuthorityCheck
    public ModelAndView queryUser(@PathVariable Integer userId) throws DataBaseException {
        ModelAndView mv = new ModelAndView("user/user_profile");
        List<EtProjectUser> projectUsers= serviceManager.getProjectUserService().queryAllProjectUserByUserId(userId);
        mv.addObject("projectUsers",projectUsers);
        //EtUser user = serviceManager.getUserService().queryUserById(userId);
        //this.renderObj(user);
        return mv;
    }

    /**
     * 管理员查询单个用户
     *
     * @param userId
     * @throws DataBaseException
     */
    @RequestMapping(value = "/system/user/{userId}", method = RequestMethod.GET)
    @AuthorityCheck
    public ModelAndView systemQueryUser(@PathVariable Integer userId) throws DataBaseException {
        ModelAndView mv = new ModelAndView("user/user_manager_detail");
        EtUser user = serviceManager.getUserService().queryUserById(userId);
        //this.renderObj(user);
        mv.addObject("systemUserDetail",user);
        return mv;
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.USER_UPDATE)
    public ModelAndView updateUser(EtUser user) {
        ModelAndView mv = new ModelAndView();


        return mv;
    }

    /**
     * 更改密码
     *
     * @param currentPwd
     * @param newPwd
     * @return
     */
    @RequestMapping(value = "password", method = RequestMethod.PUT)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.USER_UPDATE_PWD)
    public ModelAndView changePassword(@RequestParam String currentPwd, @RequestParam String newPwd) {
        ModelAndView mv = new ModelAndView();


        return mv;
    }

    /*@RequestMapping(value = "/api/users")
    public void userIsExist(@RequestHeader String querys) throws BusinessException {
        System.out.println("querys = " + querys);
        try {
            List<EtUser> users = serviceManager.getUserService().get(querys);
            renderObj(users);
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
    }*/

}
