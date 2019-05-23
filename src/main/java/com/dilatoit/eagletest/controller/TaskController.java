package com.dilatoit.eagletest.controller;

import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.annotation.SystemControllerLog;
import com.dilatoit.eagletest.dto.translate.WeaknetDTOTranslate;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.log.SystemLog;
import com.dilatoit.eagletest.enums.task.SmartTraversalEnum;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.exception.ex.api.ApiBusinessException;
import com.dilatoit.eagletest.model.*;
import com.dilatoit.eagletest.util.*;
import com.dilatoit.eagletest.validate.formtask.Task;
import com.dilatoit.engine.enums.EngineEnum;
import com.dilatoit.engine.exception.EngineException;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by beishan on 2016/11/15.
 */
@Controller
@RequestMapping
public class TaskController extends BaseController {

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
     * 终端详情报告
     * @param projectId
     * @param taskId
     * @param serialNumber
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/project/{projectId}/task/{taskId}/mobile/{serialNumber}")
    @AuthorityCheck
    public ModelAndView queryTaskMobileResult(@PathVariable Integer projectId, @PathVariable Integer taskId,
                                              @PathVariable String serialNumber) throws BusinessException{
        ModelAndView mv = new ModelAndView("task/task_mobile_result");
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
        //加载当前登录用户在该项目中的用户
        EtProjectUser currentProjectUser = null;
        EtUser currentUser = (EtUser) session.getAttribute("currentUser");
        for(EtProjectUser pu : currentProject.getEtProjectUsers()){
            if(currentUser.getId().equals(pu.getEtUser().getId())){
                currentProjectUser = pu;
            }
        }
        mv.addObject("currentProjectUser", currentProjectUser);
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

    /**
     * 智能遍历终端详情
     * @param projectId
     * @param taskId
     * @param resultUrl
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/project/{projectId}/task/{taskId}/smarttraversal")
    @AuthorityCheck
    public ModelAndView querySmartTraversalResult(@PathVariable Integer projectId, @PathVariable Integer taskId,
                                                   String resultUrl)throws BusinessException{
        ModelAndView mv = new ModelAndView("task/task_result_smarttraversal");
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
        //加载当前登录用户在该项目中的用户
        EtProjectUser currentProjectUser = null;
        EtUser currentUser = (EtUser) session.getAttribute("currentUser");
        for(EtProjectUser pu : currentProject.getEtProjectUsers()){
            if(currentUser.getId().equals(pu.getEtUser().getId())){
                currentProjectUser = pu;
            }
        }
        mv.addObject("currentProjectUser", currentProjectUser);

        mv.addObject("stResultUrl", resultUrl);
        return mv;
    }

    /**
     * stop all task
     * @param serialNumber
     * @throws BusinessException
     * @throws DataBaseException
     */
    @RequestMapping(value = "/mobile/{serialNumber}/stopAll")
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.MOBILE_STOP_TASK)
    public void stopAllTask(@PathVariable String serialNumber) throws BusinessException, DataBaseException{
        try{
            serviceManager.getMobileService().httpStopAllTask(serialNumber);
            this.render("\"status\":\"success\"");
        }catch(EngineException ee){
            throw new BusinessException(ExceptionEnum.INNER_SERVER_ERROR);
        }
    }
    /**
     * stop current task
     * @param projectId
     * @param taskId
     * @param serialNumber
     * @return
     * @throws BusinessException
     * @throws DataBaseException
     */
    @RequestMapping(value = "/project/{projectId}/task/{taskId}/stop", method = RequestMethod.DELETE)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.TASK_STOP)
    public void stopTask(@PathVariable Integer projectId, @PathVariable String taskId, @RequestParam String serialNumber)
            throws BusinessException, DataBaseException{
        try {
            //EtTask task = serviceManager.getTaskService().queryById(taskId);
            serviceManager.getMobileService().httpStopCurrentTask(serialNumber, taskId);
            this.render("\"status\":\"success\"");
        }catch (EngineException ee){
            throw new BusinessException(ExceptionEnum.INNER_SERVER_ERROR);
        }
        //return "redirect:/project/" + projectId + "/tasks";
    }

    @RequestMapping(value = "/project/{projectId}/createtask")
    @AuthorityCheck
    public ModelAndView toCreateTaskStep1(@PathVariable Integer projectId) throws EngineException, DataBaseException, BusinessException{
        ModelAndView mv = new ModelAndView("task/task_create_step1");
        //得到当前用户信息
        EtUser currentUser = (EtUser) session.getAttribute("currentUser");

        //加载当前项目信息
        EtProject currentProject = serviceManager.getProjectService().queryById(projectId);
        mv.addObject("currentProject", currentProject);

        //加载所有的运行包
        List<EtApp> apps = serviceManager.getAppService().queryAll();
        mv.addObject("apps", apps);

        //加载所有可用弱网设置类型
        List<EtWeaknet> weaknets = serviceManager.getWeaknetService().queryAllEnable();
        mv.addObject("weaknets", WeaknetDTOTranslate.translateList(weaknets));

        return mv;
    }

    @RequestMapping(value = "/project/{projectId}/createtask_2")
    @AuthorityCheck
    public ModelAndView toCreateTaskStep2(@PathVariable Integer projectId, Task task) throws EngineException, DataBaseException, BusinessException, IOException {
        ModelAndView mv = new ModelAndView("task/task_create_step2");
        Gson gson = new Gson();
        System.out.println(gson.toJson(task));

        //加载当前项目信息
        EtProject currentProject = serviceManager.getProjectService().queryById(projectId);
        mv.addObject("currentProject", currentProject);
        //加载当前正在调试的手机
        List<EtRealMobile> currentRms = serviceManager.getRealMobileService().currentRealMobiles(1);
        mv.addObject("currentRms", currentRms);
        //获取项目类型
        int projectType = currentProject.getProjectType();
        //获取引擎值
        if(String.valueOf(SmartTraversalEnum.YES.value()).equals(task.getSmartTraversalTest())){
            task.setEngine(EngineEnum.ENGINE_ETE.value());
        }else if(String.valueOf(SmartTraversalEnum.NO.value()).equals(task.getSmartTraversalTest())){
            task.setEngine(EngineEnum.ENGINE_MTCE.value());
        }else {
            task.setEngine(EngineEnum.ENGINE_ALL.value());
        }
        mv.addObject("projectType", projectType);
        mv.addObject("engine", task.getEngine());
        session.setAttribute("currentCreateTask", task);

        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        // 检查form是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                // 由CommonsMultipartFile继承而来,拥有上面的方法.
                MultipartFile scriptFile = multiRequest.getFile(iter.next());
                //上传scriptFile
                if (scriptFile != null && scriptFile.getSize() > 0) {
                    String tempFilePath = Tools.getTempPath() + File.separator + "script_file";
                    File tempFile;
                    try {
                        tempFile = FileUtil.transferFile(scriptFile, new File(tempFilePath));
                    }catch (IOException e){
                        throw new BusinessException(ExceptionEnum.TASK_SCRIPTFILE_SAVE_ERROR);
                    }

                    String result = serviceManager.getCommonsService().uploadCaseFile("file", tempFile, tempFile.getName());
                    System.out.println("上传文件结果 为：" + result);
                    Map r = gson.fromJson(result, Map.class);
                    String scriptUrl = (String) r.get("url");
                    task.setScriptUrl(scriptUrl);
                }
            }

        }
        //定义重复提交字符
        int taskResubmit = 0;
        session.setAttribute("taskResubmit", taskResubmit);

        return mv;
    }

    @RequestMapping(value = "/project/{projectId}/createtask_3")
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.TASK_CREATE)
    public ModelAndView toCreateTaskStep3(@PathVariable Integer projectId, @RequestParam(value = "mobile[]") String [] mobiles) throws EngineException, DataBaseException, BusinessException{
        //判断是否重复提交
        int taskResubmit = (Integer) session.getAttribute("taskResubmit");
        if(taskResubmit == 0){
            ModelAndView mv = new ModelAndView("task/task_create_step3");
            //得到当前用户信息
            EtUser currentUser = (EtUser) session.getAttribute("currentUser");

            //加载当前项目信息
            EtProject currentProject = serviceManager.getProjectService().queryById(projectId);
            mv.addObject("currentProject", currentProject);

            //shenzingjgz装提交任务都需要做

            Task task = (Task) session.getAttribute("currentCreateTask");

            Integer taskId = serviceManager.getTaskService().createTask(projectId, currentUser.getId(), task, mobiles);

            EtTask newTask = serviceManager.getTaskService().queryById(taskId);

            mv.addObject("newTask", newTask);

            taskResubmit = 1;
            session.setAttribute("taskResubmit", taskResubmit);

            return mv;
        }else {
            return new ModelAndView("redirect:/project/" + projectId + "/tasks");
        }
    }


    @RequestMapping(value = "/project/{projectId}/tasks")
    @AuthorityCheck
    public ModelAndView queryTaskPage(@PathVariable Integer projectId, @RequestParam(defaultValue = "1") Integer offset,
                                      @RequestParam(defaultValue = "10") Integer limit)
            throws DataBaseException, BusinessException, EngineException{
        ModelAndView mv = new ModelAndView("project/project_task");
        //加载当前项目信息
        EtProject currentProject = serviceManager.getProjectService().queryById(projectId);

        //加载当前登录用户在该项目中的用户
        EtProjectUser currentProjectUser = null;
        EtUser currentUser = (EtUser) session.getAttribute("currentUser");
        for(EtProjectUser pu : currentProject.getEtProjectUsers()){
            if(currentUser.getId().equals(pu.getEtUser().getId())){
                currentProjectUser = pu;
            }
        }
        mv.addObject("currentProjectUser", currentProjectUser);
        //加载任务列表
        DataPage<EtTask> page = new DataPage<EtTask>();
        page.setLimit(limit);
        page.setOffset(offset);
        Conditions conditions = new Conditions();
        conditions.addOrderBy("id", false);
        conditions.addCondition("etProject.id", projectId, Conditions.Operator.EQUAL);
        serviceManager.getTaskService().page(page, conditions);
        mv.addObject("currentProject", currentProject);
        mv.addObject("page", page);

        List<Map> taskResultList = new ArrayList<Map>();
        Map taskResult;
        for(int i = 0; i < page.getData().size(); i++ ){
            taskResult = gson.fromJson(page.getData().get(i).getResult(), Map.class);
            taskResultList.add(taskResult);
        }
        mv.addObject("taskResultList", taskResultList);

        List<Map> taskParamList = new ArrayList<Map>();
        Map taskParamMap;
        for(int i = 0; i < page.getData().size(); i++ ){
            taskParamMap = gson.fromJson(page.getData().get(i).getTaskParam(), Map.class);
            taskParamList.add(taskParamMap);
        }
        mv.addObject("taskParamList", taskParamList);

        List<Integer> idList = new ArrayList<Integer>();
        for(int i = 0; i < page.getData().size(); i++ ){
            idList.add(page.getData().get(i).getId());
        }
        String ids = GsonUtils.toJsonString(idList);
        ids = ids.substring(1, ids.length() - 1);
        ids = ids.trim();
        mv.addObject("idList", ids);

        return mv;
    }

    /**
     * 任务报告
     * @param projectId
     * @param taskId
     * @return
     * @throws EngineException
     * @throws DataBaseException
     * @throws BusinessException
     */
    @RequestMapping(value = "/project/{projectId}/task/{taskId}")
    @AuthorityCheck
    public ModelAndView queryTaskResult(@PathVariable Integer projectId, @PathVariable Integer taskId)
            throws EngineException, DataBaseException, BusinessException{
        ModelAndView mv = new ModelAndView("task/task_result");
        //加载当前项目信息
        EtProject currentProject = serviceManager.getProjectService().queryById(projectId);
        mv.addObject("currentProject", currentProject);
        //加载当前任务信息
        EtTask currentTask = serviceManager.getTaskService().queryById(taskId);
        mv.addObject("currentTask", currentTask);
        //加载当前登录用户在该项目中的用户
        EtProjectUser currentProjectUser = null;
        EtUser currentUser = (EtUser) session.getAttribute("currentUser");
        for(EtProjectUser pu : currentProject.getEtProjectUsers()){
            if(currentUser.getId().equals(pu.getEtUser().getId())){
                currentProjectUser = pu;
            }
        }
        mv.addObject("currentProjectUser", currentProjectUser);
        //加载当前任务结果
        if(currentTask.getEngine() == EngineEnum.ENGINE_ETE.value()){
            /*List<EtSmartTraversalTask> smartTraversalTasks = serviceManager.getSmartTraversalTaskService().queryAllByParrentTaskId(taskId);
            mv.addObject("smartTraversalTasks",smartTraversalTasks);*/
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

    @RequestMapping(value = "/project/{projectId}/task/{taskId}/realtimelog")
    @AuthorityCheck
    public ModelAndView queryTaskRealTimeLog(@PathVariable Integer projectId, @PathVariable Integer taskId, @RequestParam(required = false) String serialNum)throws BusinessException, DataBaseException{
        ModelAndView mv = new ModelAndView("task/task_mobile_realtimelog");

        //加载当前项目信息
        EtProject currentProject = serviceManager.getProjectService().queryById(projectId);
        mv.addObject("currentProject", currentProject);
        //加载当前任务信息
        EtTask currentTask = serviceManager.getTaskService().queryById(taskId);
        mv.addObject("currentTask", currentTask);

        Map taskParam = GsonUtils.toMap(currentTask.getTaskParam());
        List mobileList = (List)taskParam.get("mobiles");
        Map currentMobile = null;
        if(serialNum == null || serialNum.equals("")){
            currentMobile = (Map) mobileList.get(0);
        }else {
            for(Object item : mobileList){
                if(((Map) item).get("sn").equals(serialNum)){
                    currentMobile = (Map) item;
                }
            }
        }
        //加载当前手机和列表参数

        mv.addObject("currentMobile", currentMobile);
        mv.addObject("mobileList", mobileList);

        return mv;
    }

    /**
     * 查看截图
     * @param taskId
     * @param serialno
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/screenshot")
    public ModelAndView screenShot(String taskId, String serialno) throws BusinessException {
        ModelAndView mv = new ModelAndView("task/screenshot");
        List<String> screenshots = serviceManager.getScreenShotService().queryScreenShot(taskId, serialno);
        mv.addObject("screenshots", screenshots);
        return mv;
    }

}
