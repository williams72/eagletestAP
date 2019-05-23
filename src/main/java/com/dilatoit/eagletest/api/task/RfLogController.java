package com.dilatoit.eagletest.api.task;

import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.api.base.BaseController;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.exception.ex.api.ApiBusinessException;
import com.dilatoit.eagletest.model.EtTask;
import com.dilatoit.eagletest.util.FileUtil;
import com.dilatoit.eagletest.util.GsonUtils;
import com.dilatoit.eagletest.util.Tools;
import com.dilatoit.eagletest.validate.api.ApiResult;
import com.dilatoit.engine.exception.EngineException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.Map;

/**
 * Created by Salt on 2017/9/20.
 */
@Controller("apiRfLogController")
@Api(value = "RfLog", description = "rf日志相关")
@RequestMapping("/api")
public class RfLogController extends BaseController {

    @RequestMapping(value = "/rflog", method = RequestMethod.GET)
    @ApiOperation(value = "获取实时日志文件地址", notes = "从百度服务器获取实时日志文件地址", httpMethod = "GET", response = ApiResult.class)

    @AuthorityCheck
    public void getRfRealtimeLog(@RequestParam String taskId, @RequestParam String serialNum)throws ApiBusinessException, DataBaseException{

        EtTask etTask = serviceManager.getTaskService().queryById(Integer.parseInt(taskId));
        String result;
        try{
            result = serviceManager.getTaskService().queryTaskMobileRealtimeLog(etTask.getTaskId(), serialNum);
        }catch (EngineException e){
            throw new ApiBusinessException(ExceptionEnum.INNER_SERVER_ERROR);
        }

        JSONObject resulJsonObject = JSONObject.fromObject(result);
        if(resulJsonObject.get("status").equals("success")){
            JSONArray jsonArray = resulJsonObject.getJSONObject("logDetail").getJSONArray(serialNum);
            if(!FileUtil.mtcServerFileIsExist((String) jsonArray.get(0))){
                resulJsonObject.getJSONObject("logDetail").getJSONArray(serialNum).set(0, "");
            }
            if(!FileUtil.mtcServerFileIsExist((String) jsonArray.get(1))){
                resulJsonObject.getJSONObject("logDetail").getJSONArray(serialNum).set(1, "");
            }
        }
        this.renderResult("查询实时日志成功！", resulJsonObject);

    }

    @RequestMapping(value = "/rflog", method = RequestMethod.PUT)
    @ApiOperation(value = "更新实时日志文件", notes = "更新实时日志文件", httpMethod = "PUT", response = ApiResult.class)

    @AuthorityCheck
    public void updateRfRealtimeLog(@RequestParam String taskId, @RequestParam String serialNum, @RequestParam String logFile, @RequestParam String debugFile)throws ApiBusinessException{

        String logFileName = taskId + "-" + serialNum + "-log.txt";
        String debugFileName = taskId + "-" + serialNum + "-debug.txt";

        String localLogFilePath = Tools.getTempPath() + File.separator + "rf_log" + File.separator + logFileName;
        String localDebugFilePath = Tools.getTempPath() + File.separator + "rf_log" + File.separator + debugFileName;

        localLogFilePath = localLogFilePath.replace("\\", "/");
        localDebugFilePath = localDebugFilePath.replace("\\", "/");

        if(!logFile.equals("") && !debugFile.equals("")){
            FileUtil.refreshFile(localLogFilePath, logFile);
            FileUtil.refreshFile(localDebugFilePath, debugFile);
            String result = "{\"logFilePath\":\"" + localLogFilePath + "\",\"debugFilePath\":\"" + localDebugFilePath + "\"}";
            //System.out.println("更新后的日志文件：" + result);
            Map resultMap = GsonUtils.toMap(result);
            this.renderResult("更新实时日志文件成功", resultMap);
        }else if(!logFile.equals("") && debugFile.equals("")){
            FileUtil.refreshFile(localLogFilePath, logFile);
            String result = "{\"logFilePath\":\"" + localLogFilePath + "\",\"debugFilePath\":\"\"}";
            //System.out.println("更新后的日志文件：" + result);
            Map resultMap = GsonUtils.toMap(result);
            this.renderResult("更新log日志文件成功, debug文件不存在", resultMap);
        } else if(logFile.equals("") && !debugFile.equals("")){
            FileUtil.refreshFile(localDebugFilePath, debugFile);
            String result = "{\"logFilePath\":\"\",\"debugFilePath\":\"" + localDebugFilePath + "\"}";
            //System.out.println("更新后的日志文件：" + result);
            Map resultMap = GsonUtils.toMap(result);
            this.renderResult("更新debug日志文件成功, log文件不存在", resultMap);
        }else{
            this.renderResult("90000000", "实时日志文件不存在", null);
        }

    }


}
