package com.dilatoit.eagletest.api.task;


import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.annotation.PerformanceTime;
import com.dilatoit.eagletest.annotation.SystemControllerLog;
import com.dilatoit.eagletest.api.base.BaseController;
import com.dilatoit.eagletest.dto.TaskDTO;
import com.dilatoit.eagletest.dto.translate.TaskDTOTranslate;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.log.SystemLog;
import com.dilatoit.eagletest.enums.task.SmartTraversalEnum;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.exception.ex.api.ApiBusinessException;
import com.dilatoit.eagletest.model.EtTask;
import com.dilatoit.eagletest.query.model.BaseQuery;
import com.dilatoit.eagletest.util.DataPage;
import com.dilatoit.eagletest.util.Tools;
import com.dilatoit.eagletest.validate.api.ApiResult;
import com.dilatoit.eagletest.validate.formtask.Task;
import com.dilatoit.engine.enums.EngineEnum;
import com.dilatoit.engine.exception.EngineException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by xueshan.wei on 3/20/2017.
 */
@Controller("apiTaskController")
@Api(value = "task", description = "任务相关")
@RequestMapping(value = "/api")
@Scope("prototype")
public class TaskController extends BaseController {
    /**
     * 用json格式提交任务
     * @param projectId
     * @param userId
     * @param task
     * @throws EngineException
     * @throws BusinessException
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/project/{projectId}/taskjson", method = RequestMethod.POST)
    @ApiOperation(value = "创建json任务", notes = "创建json任务，如有脚本测试需先上传脚本文件获取脚本url", httpMethod = "POST",
            response = ApiResult.class)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "projectId",value = "项目id",required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "userId",value = "用户id", required = true, dataType = "Integer")})
    @SystemControllerLog(systemLog = SystemLog.TASK_CREATE)
    @AuthorityCheck
    @PerformanceTime("创建任务方法")
    public void createJsonTask(@PathVariable Integer projectId,@RequestParam Integer userId, @Valid @RequestBody Task task) throws EngineException, BusinessException, ApiBusinessException {

        if(task != null){

            // TODO: 3/28/2017 这里需要做提交任务处理
            try {
                serviceManager.getTaskService().submitTask(projectId, userId, task);
            } catch (EngineException e) {
                e.printStackTrace();
                throw new EngineException(e.getEe());
            }catch (BusinessException ee){
                ee.printStackTrace();
                throw new BusinessException(ee.getEe());
            }
            this.renderResult("新建任务数据传输成功", task);
        }else{
            throw new ApiBusinessException(ExceptionEnum.NUll_OBJECT_ERROR);
        }
    }

    @RequestMapping(value = "/project/{projectId}/taskform",method = RequestMethod.POST)
    @ApiOperation(value = "创建form任务", notes = "创建form任务，可以直接上传文件", httpMethod = "POST", response = ApiResult.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "projectId", value = "项目id", required = true, dataType = "Integer",paramType = "path"),
                        @ApiImplicitParam(name = "taskName", value = "任务名", required = true, dataType = "String",paramType = "query"),
                        @ApiImplicitParam(name = "appId", value = "appId", required = true, dataType = "Integer",paramType = "query"),
                        @ApiImplicitParam(name = "isReboot", value = "重启(0:未选中, 1:选中)", required = true, dataType = "String",paramType = "query"),
                        @ApiImplicitParam(name = "isNetSimulation", value = "网络模拟(0:未选中, 1:选中)", required = true, dataType = "String",paramType = "query"),
                        @ApiImplicitParam(name = "netSimulationType", value = "网络模拟类型", required = true, dataType = "String",paramType = "query"),
                        @ApiImplicitParam(name = "compatibilityTest", value = "兼容测试(0:未选中, 1:选中)", required = true, dataType = "String",paramType = "query"),
                        @ApiImplicitParam(name = "compatibilityTime", value = "兼容测试时间(分钟)", required = true, dataType = "Integer",paramType = "query"),
                        @ApiImplicitParam(name = "compatibilityType", value = "兼容测试类型(0:Monkey,1:SmartMonkey)", required = true, dataType = "String",paramType = "query"),
                        @ApiImplicitParam(name = "scriptTest", value = "脚本测试(0:未选中, 1:选中)", required = true, dataType = "String",paramType = "query"),
                        @ApiImplicitParam(name = "scriptType", value = "脚本测试类型(0:appium, 1:robotium, 2:uiautomator, 3:robotFramework)", required = true, dataType = "String",paramType = "query"),
                        @ApiImplicitParam(name = "scriptFile", value = "脚本文件", dataType = "CommonsMultipartFile", paramType = "query"),
                        @ApiImplicitParam(name = "traversalTest", value = "遍历测试(0:未选中, 1:选中)", required = true, dataType = "String",paramType = "query"),
                        @ApiImplicitParam(name = "traversalTime", value = "遍历测试时间(分钟)", required = true, dataType = "Integer",paramType = "query"),
                        @ApiImplicitParam(name = "smartTraversalTest", value = "智能遍历(0:未选中, 1:选中)", required = true, dataType = "String",paramType = "query"),
                        @ApiImplicitParam(name = "mobile[]", value = "设备", required = true, dataType = "String",paramType = "query")})
    @SystemControllerLog(systemLog = SystemLog.TASK_CREATE)
    @PerformanceTime("创建任务方法")
    @AuthorityCheck
    public void createFormTask(@PathVariable Integer projectId, @RequestParam Integer userId, @RequestParam String taskName,
                               @RequestParam Integer appId, @RequestParam String isReboot, @RequestParam String isNetSimulation,
                               @RequestParam String netSimulationType, @RequestParam String compatibilityTest, @RequestParam Integer compatibilityTime,
                               @RequestParam Integer  compatibilityType, @RequestParam String scriptTest, @RequestParam Integer scriptType,
                               @RequestParam(value = "scriptFile") MultipartFile scriptFile, @RequestParam String traversalTest, @RequestParam Integer traversalTime,
                               @RequestParam String smartTraversalTest, @RequestParam(value = "mobile[]") String [] mobiles) throws EngineException, DataBaseException, ApiBusinessException, BusinessException{
        Task task = new Task();
        //设置参数
        task.setTaskName(taskName);
        task.setAppId(appId);
        task.setIsReboot(isReboot);
        task.setIsNetSimulation(isNetSimulation);
        task.setNetSimulationType(netSimulationType);
        task.setCompatibilityTest(compatibilityTest);
        task.setCompatibilityTime(compatibilityTime);
        task.setCompatibilityType(compatibilityType);
        task.setScriptTest(scriptTest);
        task.setScriptType(scriptType);
        if(scriptFile != null){
            String path = System.getProperty("user.home");
            String fileName = "temp" + scriptFile.getOriginalFilename();
            path = path + "/" + fileName;
            File localFile = new File(path);
            try {
                scriptFile.transferTo(localFile);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ApiBusinessException(ExceptionEnum.APP_SAVE_ERROR);
            }
            try{
                String key = Tools.getUuid() + fileName.substring(fileName.lastIndexOf("."));
                String result = serviceManager.getCommonsService().uploadCaseFile("file", localFile, key);
                Map r = gson.fromJson(result, Map.class);
                String scriptUrl = (String) r.get("url");
                task.setScriptUrl(scriptUrl);
            }catch (BusinessException e){
                throw new ApiBusinessException(ExceptionEnum.MTC_CONFIG_API_ERROR);
            }
        }
        task.setTraversalTest(traversalTest);
        task.setTraversalTime(traversalTime);
        task.setSmartTraversalTest(smartTraversalTest);
        if(String.valueOf(SmartTraversalEnum.YES.value()).equals(task.getSmartTraversalTest())){
            task.setEngine(EngineEnum.ENGINE_ETE.value());
        }else if(String.valueOf(SmartTraversalEnum.NO.value()).equals(task.getSmartTraversalTest())){
            task.setEngine(EngineEnum.ENGINE_MTCE.value());
        }else {
            task.setEngine(EngineEnum.ENGINE_ALL.value());
        }
        int taskId;
        try{
             taskId = serviceManager.getTaskService().createTask(projectId, userId, task, mobiles);
            System.out.println(task.toString());
        }catch (EngineException e) {
            throw new ApiBusinessException(e.getEe());
        }
        this.renderResult("新建任务数据传输成功", taskId);

    }

    /**
     * sotp a task
     * @param projectId
     * @param taskId
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/project/{projectId}/task/{taskId}", method = RequestMethod.PUT)
    @ApiOperation(value = "停止任务", notes = "用于停止一个任务",
            response = ApiResult.class, httpMethod = "PUT")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "projectId",value = "项目id",required = true,dataType = "Integer"),
                        @ApiImplicitParam(paramType = "path", name = "taskId",value = "任务id",required = true,dataType = "Integer")})
    @SystemControllerLog(systemLog = SystemLog.TASK_STOP)
    @AuthorityCheck(permission = "task:update")
    public void stopTask(@PathVariable Integer projectId, @PathVariable Integer taskId) throws ApiBusinessException{
        try {
            serviceManager.getTaskService().stopTask(taskId);
            this.renderResult("停止任务成功");
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
    }

    @RequestMapping(value = "/project/{projectId}/tasks", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询项目任务信息", notes = "分页查询项目下的所有任务的信息", httpMethod = "PUT")
    @ApiImplicitParam(paramType = "path", name = "projectId", value = "项目id", required = true)
    //@AuthorityCheck
    public void getProjectTasksByPage(@PathVariable Integer projectId, BaseQuery baseQuery) throws ApiBusinessException{
        DataPage<EtTask> page = new DataPage<>();
        page.setOffsetLimit(baseQuery.getOffset(), baseQuery.getLimit());
        try {
            serviceManager.getTaskService().synoTaskStatus();
            serviceManager.getTaskService().queryTasksByProjectIdApi(page, projectId);
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }catch (Exception e){
            throw new ApiBusinessException(ExceptionEnum.TASK_SYNOSTATUES_ERROR);
        }
        DataPage<TaskDTO> pageNew = new DataPage<>();
        pageNew.setOffsetLimit(baseQuery.getOffset(), baseQuery.getLimit());
        pageNew.setRows(page.getRows());
        pageNew.setData(TaskDTOTranslate.translateList(page.getData()));
        renderResult("查询成功！", pageNew);
    }

    @RequestMapping(value = "/project/tasks",method = RequestMethod.GET)
    @ApiOperation(value = "查询一组任务", response = ApiResult.class, httpMethod = "GET", notes = "返回任务的信息")
    public void getTaskListById(@RequestParam(value = "ids[]") List<Integer> ids) throws ApiBusinessException{
        List<EtTask> etTaskList = null;
        try {
            serviceManager.getTaskService().synoTaskStatus();
            etTaskList = serviceManager.getTaskService().queryListTaskById(ids);
            List<TaskDTO> taskDTOList = TaskDTOTranslate.translateList(etTaskList);
            renderResult("查询多个任务信息成功",taskDTOList);
        } catch (DataBaseException e) {
            e.printStackTrace();
        } catch (Exception e){
            throw new ApiBusinessException(ExceptionEnum.TASK_SYNOSTATUES_ERROR);
        }
    }
}
