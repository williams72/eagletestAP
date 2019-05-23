package com.dilatoit.eagletest.controller;


import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.annotation.SystemControllerLog;
import com.dilatoit.eagletest.dto.translate.WeaknetDTOTranslate;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.log.SystemLog;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.*;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;
import com.dilatoit.eagletest.validate.api.ApiResult;
import com.dilatoit.engine.engines.mtc.util.JsonTools;
import com.dilatoit.engine.enums.RealMobileTime;
import com.dilatoit.engine.exception.EngineException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by beishan on 2016/11/15.
 */
@Controller
@RequestMapping
public class RealMobileController extends BaseController {
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

    @RequestMapping(value = "/realmobilelogs", method = RequestMethod.GET)
    @AuthorityCheck
    public ModelAndView pageQuery(@RequestParam(defaultValue = "1") Integer offset, @RequestParam(defaultValue = "10") Integer limit)
            throws DataBaseException, BusinessException {
        ModelAndView mv = new ModelAndView("realmobile/realmobile_record");

        DataPage<EtRealMobile> page = new DataPage<EtRealMobile>();
        page.setOffsetLimit(offset, limit);
        Conditions conditions = new Conditions();
        conditions.addOrderBy("beginTime", false);
        serviceManager.getRealMobileService().page(page, conditions);
        mv.addObject("page", page);
        return mv;
    }


    /**
     * get all realmobiles
     *
     * @return ModelAndView
     * @throws EngineException
     */
    @RequestMapping(value = "realmobiles", method = RequestMethod.GET)
    @AuthorityCheck
    public ModelAndView getAllRealmobile() throws EngineException, DataBaseException {
        ModelAndView mv = new ModelAndView("realmobile/realmobile_library");
        //得到当前用户
        EtUser currentUser = (EtUser) session.getAttribute("currentUser");
        String result = serviceManager.getRealMobileService().realmobiles();
        //得到所有仓库手机
        Map realmobiles = this.gson.fromJson(result, Map.class);

        mv.addObject("realmobiles", realmobiles);
        return mv;
    }

    /**
     * rent a real mobile
     *
     * @param serialNumber
     * @param time
     * @throws EngineException
     * @throws DataBaseException
     */
    @RequestMapping(value = "/realmobile", method = RequestMethod.POST)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.REALMOBILE_RENT)
    public void createNewRealMobile(@RequestParam String serialNumber, @RequestParam String mobilename, @RequestParam int time) throws EngineException, DataBaseException {
        EtUser currentUser = (EtUser) session.getAttribute("currentUser");
        RealMobileTime rmt = RealMobileTime.TIME_1;
        switch (time) {
            case 1:
                rmt = RealMobileTime.TIME_1;
                break;
            case 2:
                rmt = RealMobileTime.TIME_2;
                break;
            case 3:
                rmt = RealMobileTime.TIME_3;
                break;
            default:
                //这里应该抛出异常
                break;
        }

        Integer realMobileId = serviceManager.getRealMobileService().httpRentRealMobile(currentUser.getId(), serialNumber, mobilename, rmt);
        Map<String, String> result = new HashMap<String, String>();
        result.put("status", "success");
        result.put("id", realMobileId.toString());
        this.renderObj(result);
    }

    /**
     * 进入某个正在调试的手机
     * api : /realmobile/{realMobileId} GET
     *
     * @param realMobileId
     * @return
     * @throws EngineException
     * @throws DataBaseException
     */
    @RequestMapping(value = "/realmobile/{realMobileId}", method = RequestMethod.GET)
    @AuthorityCheck
    public ModelAndView getOneRealMobile(@PathVariable String realMobileId) throws BusinessException {
        ModelAndView mv = new ModelAndView("realmobile/realMobile");
        //得到目标手机信息
        String result = null;
        try {
            result = serviceManager.getRealMobileService().httpGetRealMobileInfo(Integer.parseInt(realMobileId));
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new BusinessException(e.getEe());

        }
        EtRealMobile rm = null;
        List<EtWeaknet> weaknets = null;
        try {
            rm = serviceManager.getRealMobileService().queryById(Integer.parseInt(realMobileId));
            weaknets = serviceManager.getWeaknetService().queryAllEnable();
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
        Map realMobile = JsonTools.toMap(result);
        mv.addObject("realMobile", realMobile);
        mv.addObject("currentRm", rm);
        mv.addObject("weaknets", WeaknetDTOTranslate.translateList(weaknets));

        return mv;
    }

    /**
     * 续借手机
     * api : PUT /realmobile/{realMobileId}
     *
     * @param realMobileId
     * @throws EngineException
     * @throws DataBaseException
     */
    @RequestMapping(value = "/realmobile/{realMobileId}", method = RequestMethod.PUT)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.REALMOBILE_RENEW)
    public void renewalRealMobile(@PathVariable String realMobileId) throws EngineException, DataBaseException {
        System.out.println("rmid = " + realMobileId);
        String renewData = serviceManager.getRealMobileService().httpRenewalRealMobile(Integer.parseInt(realMobileId), null);
        this.render(renewData);
    }

    /**
     * 停止真机调试
     *
     * @param realMobileId
     * @throws EngineException
     * @throws DataBaseException
     */
    @RequestMapping(value = "/realmobile/{realMobileId}", method = RequestMethod.DELETE)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.REALMOBILE_STOP)
    public void stopOneRealMobile(@PathVariable String realMobileId) throws EngineException, DataBaseException, BusinessException {

        //清除网络模拟环境
        EtRealMobile etRealMobile = serviceManager.getRealMobileService().queryById(Integer.parseInt(realMobileId));
        boolean clearEnd = false;
        if(etRealMobile.getNetSimulation() != null){
            EtMobile etMobile = serviceManager.getRealMobileService().queryIpByRealMobileId(Integer.parseInt(realMobileId));
            try {
                clearEnd = serviceManager.getRealMobileService().clearNetAfterRemote(etMobile.getRealIp());
            } catch (BusinessException e) {
                e.printStackTrace();
                throw new BusinessException(e.getEe());
            }
        }else {
            clearEnd = true;
        }
        if (clearEnd) {
            try {
                serviceManager.getRealMobileService().httpStopRealMobile(Integer.parseInt(realMobileId));
            } catch (EngineException ee) {

            } catch (DataBaseException dbe) {

            }
            ApiResult apiResult = new ApiResult();
            apiResult.setCode("00000000");
            apiResult.setMsg("停止成功");
            this.renderObj(apiResult);
        } else {
            ApiResult apiResult = new ApiResult();
            apiResult.setCode("60000004");
            apiResult.setMsg("清理网络模拟环境出错，停止失败");
            this.renderObj(apiResult);
        }
    }
}
