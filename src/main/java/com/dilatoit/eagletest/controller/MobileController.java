package com.dilatoit.eagletest.controller;


import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.annotation.SystemControllerLog;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.log.SystemLog;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtProject;
import com.dilatoit.eagletest.model.EtRealMobile;
import com.dilatoit.eagletest.model.EtUser;
import com.dilatoit.eagletest.model.EtUserConfig;
import com.dilatoit.engine.enums.MobileOsEnum;
import com.dilatoit.engine.exception.EngineException;
import com.google.gson.Gson;
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
public class MobileController extends BaseController {
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
     * 设备管理
     * @return
     * @throws EngineException
     * @throws DataBaseException
     */
    @RequestMapping(value = "/mobiles", method = RequestMethod.GET)
    @AuthorityCheck(permission = {"mobile:query"})
    public ModelAndView mobileList() throws EngineException, DataBaseException{
        ModelAndView mv = new ModelAndView("system/sys_mobile_manager");
        Gson gson = new Gson();
        String mobiles = serviceManager.getMobileService().httpGetMobileInfo();
        //Map mobiles = gson.fromJson(result, Map.class);
        mv.addObject("mobiles", mobiles);
        return mv;
    }
    @RequestMapping(value = "/mobiles/{mobileType}")
    public void queryMobiles(@PathVariable String mobileType) throws BusinessException{
        MobileOsEnum mobileOsType = null;
        if("all".equals(mobileType)){
            mobileOsType = MobileOsEnum.ALL;
        }else if("android".equals(mobileType)){
            mobileOsType = MobileOsEnum.ANDROID;
        }else if("ios".equals(mobileType)){
            mobileOsType = MobileOsEnum.IOS;
        }else{
            throw new BusinessException(ExceptionEnum.PARAM_ERROR);
        }
        String mobiles = null;
        try {
            mobiles = serviceManager.getMobileService().httphttpGetMobileInfoByOS(mobileOsType);
        } catch (EngineException e) {
            throw new BusinessException(ExceptionEnum.INNER_SERVER_ERROR);
        }
        this.render(mobiles);
    }

    /**
     * rename mobile
     * @param serialNumber
     * @param name
     * @throws EngineException
     */
    @RequestMapping(value = "/mobile/{serialNumber}", method = RequestMethod.PUT)
    @AuthorityCheck(permission = {"mobile:update"})
    @SystemControllerLog(systemLog = SystemLog.MOBILE_RENAME)
    public void mobileRename(@PathVariable String serialNumber, @RequestParam String name)
                        throws EngineException{
        String result = serviceManager.getMobileService().httpRename(serialNumber, name);
        this.render("{\"status\":\"success\"}");
    }

    /**
     * reboot mobile
     * @param serialNumber
     * @throws EngineException
     */
    @RequestMapping(value = "/mobilereboot", method = RequestMethod.POST)
    @AuthorityCheck(permission = {"mobile:update"})
    @SystemControllerLog(systemLog = SystemLog.MOBILE_REBOOT)
    public void mobileReboot(@RequestParam String serialNumber) throws EngineException{
        String result = serviceManager.getMobileService().httpReboot(serialNumber);
    }

    @RequestMapping(value = "/mobiletask/{serialNumber}", method = RequestMethod.DELETE)
    @AuthorityCheck(permission = {"mobileTask:update"})
    @SystemControllerLog(systemLog = SystemLog.MOBILE_STOP_TASK)
    public void mobileTaskStop(@PathVariable String serialNumber) throws BusinessException{
        try {
            serviceManager.getMobileService().httpStopAllTask(serialNumber);
            this.render("{\"status\":\"success\"}");
        } catch (EngineException ee) {
            throw new BusinessException(ExceptionEnum.INNER_SERVER_ERROR);
        }
    }
}
