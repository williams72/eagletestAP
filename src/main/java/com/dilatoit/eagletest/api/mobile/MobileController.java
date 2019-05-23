package com.dilatoit.eagletest.api.mobile;

import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.annotation.SystemControllerLog;
import com.dilatoit.eagletest.api.base.BaseController;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.log.SystemLog;
import com.dilatoit.eagletest.exception.ex.api.ApiBusinessException;
import com.dilatoit.eagletest.validate.api.ApiResult;

import com.dilatoit.engine.dto.MobileDTO;
import com.dilatoit.engine.enums.EngineEnum;
import com.dilatoit.engine.enums.MobileOsEnum;
import com.dilatoit.engine.exception.EngineException;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Created by xueshan.wei on 1/11/2017.
 */
@Api(value = "mobiles", description = "设备相关")
@RequestMapping("/api")
@Controller(value = "apiMobileController")
@Scope("prototype")
public class MobileController extends BaseController {
    /**
     * 查询所有手机
     * @throws ApiBusinessException
     */
    /*@RequestMapping(value = "/mobiles", method = RequestMethod.GET)
    @ApiOperation(value = "查询在线手机", response = ApiResult.class, httpMethod = "GET", notes = "根据条件查询在线设备：0 ：所有设备， 1：安卓设备，2：IOS设备")
    @ApiImplicitParam(name ="os",value="想要查询的设备，0 ：所有设备， 1：安卓设备，2：IOS设备",required = true, dataType = "Integer",paramType = "query")
    @AuthorityCheck(permission = {"mobile:query"})
    @SystemControllerLog(systemLog = SystemLog.MOBILE_QUERY)
    public void queryMobiles(@RequestParam(defaultValue = "0") Integer os) throws ApiBusinessException {
        String result = null;
        MobileOsEnum mobileOsType = null;
        if(MobileOsEnum.ANDROID.value() == os){
            mobileOsType = MobileOsEnum.ANDROID;
        }else if(MobileOsEnum.IOS.value() == os){
            mobileOsType = MobileOsEnum.IOS;
        }else{
            mobileOsType = MobileOsEnum.ALL;
        }
        try {
            result = serviceManager.getMobileService().httphttpGetMobileInfoByOS(mobileOsType);
            Map resultMap = gson.fromJson(result, Map.class);
            renderResult("查询所有在线设备成功", resultMap);
        }catch (EngineException ee){
            throw new ApiBusinessException(ee.getEe());
        }
    }*/

    @RequestMapping(value = "/mobiles", method = RequestMethod.GET)
    @ApiOperation(value = "根据引擎和系统类型查询手机", response = ApiResult.class, httpMethod = "GET", notes = "引擎：0 ETE, 1 MTC")
    @ApiImplicitParam(name ="os",value="想要查询的设备，0：全部，1：安卓设备，2：IOS设备",required = true, dataType = "Integer",paramType = "query")
    @AuthorityCheck(permission = {"mobile:query"})
    public void queryMobilesByEngineAndOS(@RequestParam Integer engine, @RequestParam Integer os)throws ApiBusinessException, EngineException{
        Gson gson = new Gson();
        List<MobileDTO> mobileList = null;
        MobileOsEnum mobileOsType = null;
        EngineEnum engineEnum = null;
        //设置引擎
        if(EngineEnum.ENGINE_ETE.value() == engine){
            engineEnum = EngineEnum.ENGINE_ETE;
        }else if(EngineEnum.ENGINE_MTCE.value() == engine){
            engineEnum = EngineEnum.ENGINE_MTCE;
        }else {
            engineEnum = EngineEnum.ENGINE_ALL;
        }
        //设置系统类型
        if(MobileOsEnum.ANDROID.value() == os){
            mobileOsType = MobileOsEnum.ANDROID;
        }else if(MobileOsEnum.IOS.value() == os){
            mobileOsType = MobileOsEnum.IOS;
        }else{
            mobileOsType = MobileOsEnum.ALL;
        }
        try{
            mobileList = serviceManager.getMobileService().httpGetMobileInfoByOS(engineEnum, mobileOsType);
            renderResult("根据引擎和设备系统查询手机成功", mobileList);
        }catch (EngineException e){
            throw new EngineException(e.getEe());
        }
    }

    /**
     * reboot a mobile
     * @param mobileId the mobile's id (serialNumber)
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/mobile/{mobileId}/power", method = RequestMethod.PUT)
    @ApiOperation(value = "重启设备", notes = "用于重启一个手机设备，需要传入设备标识",
            httpMethod = "PUT", response = ApiResult.class)
    @ApiImplicitParam(name ="mobileId",value="设备标识id",required = true, dataType = "String",paramType = "path")
    @SystemControllerLog(systemLog = SystemLog.MOBILE_REBOOT)
    @AuthorityCheck(permission = "mobile:update")
    public void rebootMobile(@PathVariable String mobileId) throws ApiBusinessException{
        try {
            serviceManager.getMobileService().httpReboot(mobileId);
            this.renderResult("重启设备成功");
        } catch (EngineException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
    }

    /**
     * mobile stop current task
     * @param mobileId
     * @param taskId
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/mobile/{mobileId}/task/{taskId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "停止当前任务", notes = "用于停止某个设备上当前正在运行的任务",
            response = ApiResult.class, httpMethod = "DELETE")
    @ApiImplicitParams({@ApiImplicitParam(name ="mobileId",value="设备标识id",required = true, dataType = "String",paramType = "path"),
            @ApiImplicitParam(name ="taskId",value="任务id",required = true, dataType = "String",paramType = "path")})
    @AuthorityCheck(permission = "mobileTask:delete")
    @SystemControllerLog(systemLog = SystemLog.MOBILE_STOP_TASK)
    public void stopCurrentTask(@PathVariable String mobileId, @PathVariable String taskId) throws ApiBusinessException{
        if(StringUtils.isNotBlank(mobileId) && StringUtils.isNotBlank(taskId)){
            try {
                serviceManager.getMobileService().httpStopCurrentTask(mobileId, taskId);
                this.renderResult("停止当前任务成功");
            } catch (EngineException e) {
                e.printStackTrace();
                throw new ApiBusinessException(e.getEe());
            }
        }else{
            throw new ApiBusinessException(ExceptionEnum.PARAM_ERROR);
        }
    }

    /**
     * stop mobile's all task
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/mobile/{mobileId}/tasks", method = RequestMethod.DELETE)
    @ApiOperation(value = "停止所有任务", notes = "用于停止当前手机上的所有任务，包括队列中的任务",
            response = ApiResult.class, httpMethod = "DELETE")
    @ApiImplicitParam(name="mobileId",value="设备标识id",required = true,dataType = "String",paramType = "path")
    @AuthorityCheck(permission = "mobileTask:delete")
    @SystemControllerLog(systemLog = SystemLog.MOBILE_STOP_TASK)
    public void stopAllTask(@PathVariable String mobileId) throws ApiBusinessException{
        if(StringUtils.isNotBlank(mobileId)){
            try {
                serviceManager.getMobileService().httpStopAllTask(mobileId);
            } catch (EngineException e) {
                e.printStackTrace();
                throw new ApiBusinessException(e.getEe());
            }
            this.renderResult("停止所有任务成功");
        }else{
            throw new ApiBusinessException(ExceptionEnum.PARAM_ERROR);
        }
    }
}
