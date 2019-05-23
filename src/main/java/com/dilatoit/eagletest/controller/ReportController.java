package com.dilatoit.eagletest.controller;

import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtProject;
import com.dilatoit.eagletest.model.EtProjectUser;
import com.dilatoit.eagletest.model.EtTask;
import com.dilatoit.eagletest.model.EtUser;
import com.dilatoit.engine.enums.EngineEnum;
import com.dilatoit.engine.exception.EngineException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by xueshan.wei on 4/7/2017.
 */
@Controller
@RequestMapping
public class ReportController extends BaseController {

    /**
     * 任务报告
     * @param projectId
     * @param taskId
     * @return
     * @throws EngineException
     * @throws DataBaseException
     * @throws BusinessException
     */
    @RequestMapping(value = "/project/{projectId}/task/{taskId}/report")
    public ModelAndView queryTaskResult(@PathVariable Integer projectId, @PathVariable Integer taskId)
            throws EngineException, DataBaseException, BusinessException{
        ModelAndView mv = new ModelAndView("report/task_result_report");
        //加载当前项目信息
        EtProject currentProject = serviceManager.getProjectService().queryById(projectId);
        mv.addObject("currentProject", currentProject);
        //加载当前任务信息
        EtTask currentTask = serviceManager.getTaskService().queryById(taskId);
        mv.addObject("currentTask", currentTask);

        //加载当前任务结果
        if(currentTask.getEngine() == EngineEnum.ENGINE_ETE.value()){
            Map taskResult = gson.fromJson(currentTask.getResult(), Map.class);
            mv.addObject("smtResult", taskResult);
        }else {
            String result = serviceManager.getTaskService().queryTaskResult(taskId);
            Map taskResult = gson.fromJson(result, Map.class);
            mv.addObject("taskResult", taskResult);
            mv.addObject("result", result);
            System.out.println(result);
        }
        return mv;
    }

    /**
     * 终端详情报告
     * @param projectId
     * @param taskId
     * @param serialNumber
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/project/{projectId}/task/{taskId}/mobile/{serialNumber}/report")
    public ModelAndView queryTaskMobileResult(@PathVariable Integer projectId, @PathVariable Integer taskId,
                                              @PathVariable String serialNumber) throws BusinessException{
        ModelAndView mv = new ModelAndView("report/task_mobile_result_report");
        //加载当前项目信息
        EtProject currentProject = null;
        try{
            currentProject = serviceManager.getProjectService().queryById(projectId);
            mv.addObject("currentProject", currentProject);

            //存储当前任务信息
            EtTask currentTask = serviceManager.getTaskService().queryById(taskId);
            mv.addObject("currentTask", currentTask);
        }catch (DataBaseException dbe){
            throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }

        //存储当前查询的是哪个手机
        mv.addObject("currentPhone", serialNumber);
        //得到当前引擎的uri
        String engineBaseUri = serviceManager.getCommonsService().getEngineBaseUri();
        mv.addObject("engineBaseUri", engineBaseUri);
        //查询当前手机执行结果
        String result = null;
        String resultMobile = null;
        try {

            result = serviceManager.getTaskService().queryTaskResult(taskId);
            resultMobile = serviceManager.getTaskService().queryTaskMobileResult(taskId, serialNumber);
        } catch (EngineException e) {
            throw new BusinessException(ExceptionEnum.INNER_SERVER_ERROR);
        } catch (DataBaseException e) {
            throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
        Map taskResult = gson.fromJson(result, Map.class);
        Map taskMobileResult = gson.fromJson(resultMobile, Map.class);
        mv.addObject("taskResult", taskResult);
        mv.addObject("taskMobileResult", taskMobileResult);
        mv.addObject("resultMobile", resultMobile);
        System.out.println("resultMobile:" + resultMobile);
        return mv;
    }
}
