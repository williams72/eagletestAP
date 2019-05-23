package com.dilatoit.eagletest.api.realmobile;

import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.annotation.SystemControllerLog;
import com.dilatoit.eagletest.api.model.ApiRealMobile;
import com.dilatoit.eagletest.api.base.BaseController;
import com.dilatoit.eagletest.enums.log.SystemLog;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.exception.ex.api.ApiBusinessException;
import com.dilatoit.eagletest.model.EtRealMobile;
import com.dilatoit.eagletest.model.EtUser;
import com.dilatoit.eagletest.validate.api.ApiResult;
import com.dilatoit.eagletest.validate.api.remotemobile.RentRm;

import com.dilatoit.engine.enums.RealMobileTime;
import com.dilatoit.engine.exception.EngineException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by xueshan.wei on 3/17/2017.
 */
@Api(value = "realmobile", description = "远程真机相关")
@Controller(value = "apiRealmobileController")
@RequestMapping(value = "/api")
@Scope("prototype")
public class RealmobileController extends BaseController {

    /**
     * 停止真机调试 
     * @param rmid
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/remotemobile/{rmid}", method = RequestMethod.DELETE)
    @ApiOperation(value = "停止真机调试", notes = "",
            httpMethod = "DELETE", response = ApiResult.class)
    @ApiImplicitParam(name = "rmid",value = "realMobileId实际的设备id",required = true,dataType = "Integer",paramType = "path")
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.REALMOBILE_STOP)
    public void sotpRm(@PathVariable Integer rmid) throws ApiBusinessException{
        try {
            serviceManager.getRealMobileService().httpStopRealMobile(rmid);
            renderResult("停止调试成功");
        }catch(BusinessException e){
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
        catch (EngineException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
    }

    /**
     * 续借远程真机
     * @param rmid
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/remotemobile/{rmid}", method = RequestMethod.PUT)
    @ApiOperation(value = "续借某个远程真机", notes = "这里续借的时间是一开始申请借用真机的时间",
            httpMethod = "PUT", response = ApiResult.class)
    @ApiImplicitParam(name = "rmid",value = "realMobileId实际的设备id",required = true,dataType = "Integer",paramType = "path")
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.REALMOBILE_RENEW)
    public void renewRm(@PathVariable Integer rmid) throws ApiBusinessException{
        try {
            serviceManager.getRealMobileService().httpRenewalRealMobile(rmid, null);
            renderResult("续借远程真机成功");
        } catch (EngineException e) {
            e.printStackTrace();
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
    }
    /**
     * 查询某个远程真机的信息
     * @param rmid
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/remotemobile/{rmid}", method = RequestMethod.GET)
    @ApiOperation(value = "查询某个真机的信息", notes = "用于查询某个真机的信息，返回真机的相关信息,比如剩余时间、调试地址",
            httpMethod = "GET", response = ApiRealMobile.class)
    @ApiImplicitParam(name = "rmid",value = "realMobileId实际的设备id",required = true,dataType = "Integer",paramType = "path")
    @AuthorityCheck
    public void getRmInfo(@PathVariable Integer rmid) throws ApiBusinessException{
        // TODO: 2017/3/30 there need some service method to do this
        try {
            ApiRealMobile realMobile = serviceManager.getRealMobileService().queryRealMobileInfo(rmid);
            renderResult("查询成功", realMobile);
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
    }

    /**
     * 借用远程真机
     * @param rentRm
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/remotemobile", method = RequestMethod.POST)
    @ApiOperation(value = "借用远程真机", notes = "用于借用一台远程真机",
            httpMethod = "POST", response = ApiResult.class)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.REALMOBILE_RENT)
    public void rentRm(@Valid @RequestBody RentRm rentRm) throws ApiBusinessException{
        EtUser currentUser = getCurrentUser();
        RealMobileTime rmt = RealMobileTime.TIME_1;
        switch(rentRm.getTime()){
            case 1: rmt = RealMobileTime.TIME_1;break;
            case 2: rmt = RealMobileTime.TIME_2;break;
            case 3: rmt = RealMobileTime.TIME_3;break;
            default:
                //这里应该抛出异常
                break;
        }

        try {
            // TODO: 2017/3/30 这两个方法都需要重新写 
            Integer realMobileId = serviceManager.getRealMobileService()
                    .httpRentRealMobile(currentUser.getId(), rentRm.getSn(), rentRm.getMobileName(), rmt);
            if(realMobileId == 0){
                //真机借用失败
            }
            EtRealMobile realMobile = serviceManager.getRealMobileService()
                    .queryById(realMobileId);
            //转换到数据输出类
            ApiRealMobile apiRealMobile = new ApiRealMobile(realMobile.getId(),
                    realMobile.getSerialNumber(),
                    realMobile.getBeginTime(),
                    realMobile.getMobileName());
            renderResult("借用真机成功",apiRealMobile);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        } catch (EngineException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
    }

    /**
     * 查询所有在线的远程真机
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/remotemobiles", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有在线的远程真机", notes = "用于查询所有在线的真机",
            httpMethod = "GET", response = ApiResult.class)
    @AuthorityCheck
    public void queryAllRms() throws ApiBusinessException{
        try {
            String rms = serviceManager.getRealMobileService().realmobiles();
            Map rmsMap = gson.fromJson(rms, Map.class);
            renderResult("查询所有在线远程真机成功", rmsMap);
        } catch (EngineException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
    }

    /**
     * 停止某台手机上的所有调试任务
     * @param sid
     * @throws ApiBusinessException
     */
    // TODO: 5/11/2017 这里需要增加 判断 1、该调试是否存在  2、该调试是否已经关闭 3、以上两种情况出现时应该基于相应的提示
    @ApiOperation(value = "停止所有调试任务", notes = "用于停止某台远程真机上的所有调试任务，包括预约中的任务")
    @ApiImplicitParam(name = "sid",value = "mobileId|设备id",required = true,dataType = "String",paramType = "query")
    @RequestMapping(value = "/remotemobile", method = RequestMethod.DELETE)
    @SystemControllerLog(systemLog = SystemLog.REALMOBILE_SYS_STOP)
    @AuthorityCheck(permission = "realmobile:delete")
    public void realmobileStopAll(@RequestParam String sid) throws ApiBusinessException{
        try {
            String result = serviceManager.getRealMobileService().httpStopAllRealmobile(sid);
            System.out.println(result);
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
        this.renderResult("停止所有调试任务成功", sid);
    }

    /**
     * 设置真机调试的网络模拟
     * @param rmid
     * @param nsid
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/remotemobile/{rmid}/netsimulation", method = RequestMethod.POST)
    @ApiOperation(value = "设置网络模拟", notes = "", httpMethod = "POST", response = ApiResult.class)
    public void addNetSimulation(@PathVariable Integer rmid, @RequestParam Integer nsid)throws ApiBusinessException{
        try{
            serviceManager.getRealMobileService().addNetSimulation(rmid, nsid);
        } catch (BusinessException e){
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
        this.renderResult("设置网络模拟成功!", rmid);
    }

    /**
     * 停止真机调试的网络模拟
     * @param rmid
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/remotemobile/{rmid}/netsimulation", method = RequestMethod.DELETE)
    @ApiOperation(value = "停止网络模拟", notes = "", httpMethod = "DELETE", response = ApiResult.class)
    public void deleteNetSimulation(@PathVariable Integer rmid)throws ApiBusinessException{
        try{
            serviceManager.getRealMobileService().deleteSimulation(rmid);
        } catch (BusinessException e){
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
        this.renderResult("停止网络模拟成功!", rmid);
    }

    /**
     * 查询网络模拟状态
     * @param rmid
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/remotemobile/{rmid}/netsimulation", method = RequestMethod.GET)
    @ApiOperation(value = "查询网络模拟状态", notes = "", httpMethod = "GET", response = ApiResult.class)
    public void queryNetSimulation(@PathVariable Integer rmid)throws ApiBusinessException{
        try{
            serviceManager.getRealMobileService().queryNetSimulation(rmid);
        } catch (BusinessException e){
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
        this.renderResult("查询网络模拟成功!", rmid);
    }

}
