package com.dilatoit.eagletest.api.task;


import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.api.base.BaseController;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.exception.ex.api.ApiBusinessException;
import com.dilatoit.eagletest.model.EtMobile;
import com.dilatoit.eagletest.service.impl.EgMobileService;
import com.dilatoit.eagletest.util.GsonUtils;
import com.dilatoit.eagletest.validate.api.ApiResult;
import com.dilatoit.engine.exception.EngineException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Salt on 2017/7/13.
 */
@Controller("apiReportController")
@Api(value = "report", description = "报告相关")
@RequestMapping("/api")
@Scope("prototype")
public class ReportController extends BaseController {

    @Autowired
    EgMobileService egMobileService;
    /**
     *
     * @param taskId
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/task/{taskId}/report", method = RequestMethod.GET)
    @ApiImplicitParam(paramType = "path", name = "taskId",value = "任务id",required = true,dataType = "Integer")
    @ApiOperation(value = "查询任务报告", notes = "查询任务报告", httpMethod = "GET", response = ApiResult.class)
    @AuthorityCheck
    public void queryTaskReport(@PathVariable Integer taskId)throws ApiBusinessException {
        String report = null;
        try{
            report = serviceManager.getTaskService().queryTaskResult(taskId);
        }catch (EngineException e){
            throw new ApiBusinessException(e.getEe());
        }catch (DataBaseException e){
            e.printStackTrace();
        }
        GsonUtils gsonUtils = new GsonUtils();
        this.renderResult("查询报告成功",gsonUtils.toMap(report));

    }

    /**
     *
     * @param taskId
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/task/{taskId}/mobilereport/{mobileId}", method = RequestMethod.GET)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "taskId",value = "任务id",required = true,dataType = "Integer"),
                        @ApiImplicitParam(paramType = "path", name = "mobileId",value = "设备id",required = true,dataType = "Integer")})
    @ApiOperation(value = "查询设备报告", notes = "查询设备报告", httpMethod = "GET", response = ApiResult.class)
    @AuthorityCheck
    public void queryMobileReport(@PathVariable Integer taskId, @PathVariable Integer mobileId)throws ApiBusinessException {
        String report = null;
        String serialNumber = null;
        try{
            EtMobile etMobile = egMobileService.queryById(mobileId);
            if(etMobile != null){
                serialNumber = etMobile.getSerialNumber();
            }
            report = serviceManager.getTaskService().queryTaskMobileResult(taskId, serialNumber);
        }catch (EngineException e){
            throw new ApiBusinessException(e.getEe());
        }catch (DataBaseException e){
            e.printStackTrace();
        }
        GsonUtils gsonUtils = new GsonUtils();
        this.renderResult("查询报告成功", gsonUtils.toMap(report));

    }
}
