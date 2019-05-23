package com.dilatoit.eagletest.service.impl;

import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.common.ModelFiledBooleanEnum;
import com.dilatoit.eagletest.enums.task.*;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.*;
import com.dilatoit.eagletest.service.*;
import com.dilatoit.eagletest.util.*;
import com.dilatoit.engine.dto.translate.EngineTaskTranslate;
import com.dilatoit.eagletest.validate.formtask.Mobile;
import com.dilatoit.eagletest.validate.formtask.Task;
import com.dilatoit.engine.EngineManager;
import com.dilatoit.engine.TaskEngineManager;
import com.dilatoit.engine.dto.EngineCreateTaskResultDTO;
import com.dilatoit.engine.dto.EngineTaskDTO;
import com.dilatoit.engine.engines.ete.utils.SmartTraversal;
import com.dilatoit.engine.engines.ete.utils.SmartTraversalStatus;
import com.dilatoit.engine.engines.mtc.data.MtcTaskConversion;
import com.dilatoit.engine.enums.EngineEnum;
import com.dilatoit.engine.exception.EngineException;
import com.google.gson.Gson;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by beishan on 2016/11/13.
 */
@Service("taskService")
public class TaskServiceImpl extends BaseService<EtTask> implements TaskService {
    @Autowired
    private AppService appService;
    @Autowired
    private SubtaskService subtaskService;
    @Autowired
    private WeaknetService weaknetService;
    @Resource(name = "egMobileService")
    private MobileService mobileService;
    @Autowired
    private MtcTaskConversion taskConversion;
    @Autowired
    private CommonsService commonsService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private EngineManager engineManager;
    @Autowired
    private TaskEngineManager taskEngineManager;

    //@Autowired
    //private HttpServletRequest request;

    @Autowired
    private SmartTraversalTaskService smartTraversalTaskService;

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Override
    public void queryTasksByProjectId(DataPage<EtTask> page, int projectId) throws BusinessException {
        Conditions conditions = new Conditions();
        conditions.addCondition("etProject.id", projectId, Conditions.Operator.EQUAL);
        try {
            page(page, conditions);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new BusinessException(e.getEe());
        }
    }

    @Override
    public void queryTasksByProjectIdApi(DataPage<EtTask> page, int projectId) throws BusinessException {
        Conditions conditions = new Conditions();
        conditions.addCondition("etProject.id", projectId, Conditions.Operator.EQUAL);
        try {
            pageApi(page, conditions);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new BusinessException(e.getEe());
        }
    }

    @Override
    public List<EtTask> queryTasksByProjectId(int projectId) throws BusinessException {
        Conditions conditions = new Conditions();
        conditions.addCondition("etProject.id", projectId, Conditions.Operator.EQUAL);
        try {
            return baseDAO.queryByConditions(EtTask.class, conditions);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new BusinessException(e.getEe());
        }
    }

    public String stopTask(Integer taskId) throws BusinessException {
        try {
            EtTask task = queryById(taskId);
            if (task != null) {
                return this.enginePipe.taskPipe().stopTask(task.getTaskId());
            } else {
                throw new BusinessException(ExceptionEnum.NUll_OBJECT_ERROR);
            }
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        } catch (EngineException ee) {
            ee.printStackTrace();
            throw new BusinessException(ee.getEe());
        }
    }

    public EtTask queryById(Integer id) throws DataBaseException {
        return (EtTask) baseDAO.queryById(com.dilatoit.eagletest.model.EtTask.class, id);
    }

    @Override
    public List<EtTask> queryListTaskById(List<Integer> ids) throws DataBaseException {
        List<EtTask> etTaskList = null;
        if(ids != null){
            String sql = " where id in(:id)";
            etTaskList = baseDAO.queryBySqlInId(com.dilatoit.eagletest.model.EtTask.class, sql, ids.toArray());
            return etTaskList;
        }
        return null;
    }


    public void page(DataPage<EtTask> page) throws DataBaseException {
        Conditions conditions = new Conditions();
        page(page, conditions);
    }

    @Override
    public void pageApi(DataPage<EtTask> page, Conditions conditions) throws DataBaseException {
        baseDAO.page(page, com.dilatoit.eagletest.model.EtTask.class, conditions);
    }

    public void page(DataPage<EtTask> page, Conditions conditions) throws DataBaseException {
        try {
            synoTaskStatus();
        } catch (EngineException ee) {

        }
        baseDAO.page(page, com.dilatoit.eagletest.model.EtTask.class, conditions);
    }
    public void synoTaskStatus() throws EngineException, DataBaseException {
        Conditions conditions = new Conditions();
        System.out.println("同步任务。。。。。。。。。。。。。。。。。。");
        conditions.addCondition("syno", TaskSyno.SYNO_NO.value(), Conditions.Operator.EQUAL);
        List<EtTask> allTasks = baseDAO.queryByConditions(com.dilatoit.eagletest.model.EtTask.class, conditions);
        String result = null;
        Map mtcTask = null;
        Gson gson = new Gson();
        if (allTasks != null && allTasks.size() > 0) {
            for (EtTask task : allTasks) {
                EngineEnum engineEnum = null;
                if (task.getEngine() == EngineEnum.ENGINE_ETE.value()) {
                    engineEnum = EngineEnum.ENGINE_ETE;
                    //同步ETE引擎任务
                    SmartTraversal smartTraversal = null;
                    String smartTraversalResult = null;
                    try {
                        smartTraversalResult = taskEngineManager.queryTaskResult(engineEnum, task.getTaskId());
                        smartTraversal = gson.fromJson(smartTraversalResult, SmartTraversal.class);
                    } catch (EngineException e) {
                        e.printStackTrace();
                        LOGGER.error("[ET] 同步ETE任务出错...");
                    }
                    if (smartTraversal != null && (smartTraversal.getStatus() == SmartTraversalStatus.COMPLETED.value()
                            || smartTraversal.getStatus() == SmartTraversalStatus.CANCELLED.value())) {
                        //同步状态为已同步
                        task.setSyno(TaskSyno.SYNO_YES.value());
                        task.setResult(smartTraversalResult);
                        task.setStarttime(smartTraversal.getBeginTime());
                        task.setEndtime(smartTraversal.getCreateTime());
                        task.setFinalResult(smartTraversal.getResult());
                        task.setStatus(smartTraversal.getStatus());
                        baseDAO.update(task);
                    }

                } else {
                    //同步MTCE引擎任务
                    engineEnum = EngineEnum.ENGINE_MTCE;
                    result = taskEngineManager.queryTaskResult(engineEnum, task.getTaskId());
                    LOGGER.debug("[ET] MTC 任务同步结果为：" + result);
                    mtcTask = gson.fromJson(result, Map.class);
                    Map mtcResult = (Map) mtcTask.get("result");
                    Map mtcTaskInfo = (Map) mtcResult.get("taskInfo");
                    String mtcTaskStatus = (String) mtcTaskInfo.get("status");

                    TaskStatus taskStatus = null;
                    boolean isSynoed = false;
                    if ("等待中".equals(mtcTaskStatus)) {
                        taskStatus = TaskStatus.WAITING;
                    } else if ("执行中".equals(mtcTaskStatus)) {
                        taskStatus = TaskStatus.TESTING;
                    } else if ("已完成".equals(mtcTaskStatus)) {
                        taskStatus = TaskStatus.COMPLETED;
                        isSynoed = true;
                    } else if ("已取消".equals(mtcTaskStatus)) {
                        taskStatus = TaskStatus.CANCELED;
                        isSynoed = true;
                    } else {
                        taskStatus = TaskStatus.CREATE;
                    }
                    //如果已经同步过了
                    if (isSynoed == true) {
                        //设置任务状态为已同步
                        task.setSyno(TaskSyno.SYNO_YES.value());
                        //任务结果存入数据库
                        task.setResult(result);
                        Date startTime = DateUtils.fromStringToDate((String) mtcTaskInfo.get("start_time"));
                        Date endTime = DateUtils.fromStringToDate((String) mtcTaskInfo.get("end_time"));
                        task.setStarttime(startTime);
                        task.setEndtime(endTime);
                        String taskExcelReport = (String) mtcResult.get("taskExcelReport");
                        task.setExcel(taskExcelReport);
                        //开始同步子任务
                        synoSubTask(task.getId(), result);
                        //System.out.println("同步子任务");
                    }
                    task.setStatus(taskStatus.value());
                    baseDAO.update(task);
                }
            }
        }
    }

    public void synoSubTask(Integer taskId, String taskResult) throws DataBaseException {

        EtTask task = queryById(taskId);
        Gson gson = new Gson();

        Map mtcResult = gson.fromJson(taskResult, Map.class);

        Map result = (Map) mtcResult.get("result");

        Map totalSummary = (Map) result.get("totalSummary");

        Map st_com = (Map) totalSummary.get("compatibility");
        Map st_case = (Map) totalSummary.get("case");
        Map st_travel = (Map) totalSummary.get("travel");

        if (st_com != null) {
            EtSubtask subtaskCom = new EtSubtask();
            subtaskCom.setSubtaskType(SubtaskType.COMPATIBILITY.value());
            subtaskCom.setProjectId(task.getEtProject().getId());
            subtaskCom.setVersionId(task.getEtVersion().getId());
            subtaskCom.setAppId(task.getEtApp().getId());
            subtaskCom.setTask(task);
            Map stComSummary = (Map) st_com.get("summary");
            if (100 == (Double) stComSummary.get("passRate")) {
                //子任务执行成功
                subtaskCom.setResult(SubtaskResult.SUCCESS.value());
            } else {
                //子任务执行失败
                subtaskCom.setResult(SubtaskResult.FAIL.value());
            }
            subtaskService.addSubTask(subtaskCom);
        }

        if (st_case != null) {
            EtSubtask subtaskCase = new EtSubtask();
            subtaskCase.setSubtaskType(SubtaskType.SCRIPT_CASE.value());
            subtaskCase.setProjectId(task.getEtProject().getId());
            subtaskCase.setVersionId(task.getEtVersion().getId());
            subtaskCase.setAppId(task.getEtApp().getId());
            subtaskCase.setTask(task);

            Map stCaseSummary = (Map) st_case.get("summary");
            if (100 == (Double) stCaseSummary.get("passRate")) {
                //子任务执行成功
                subtaskCase.setResult(SubtaskResult.SUCCESS.value());
                System.out.println("脚本测试成功");
            } else {
                //子任务执行失败
                subtaskCase.setResult(SubtaskResult.FAIL.value());
                System.out.println("脚本测试失败");
            }
            subtaskService.addSubTask(subtaskCase);
        }

        if (st_travel != null) {
            EtSubtask subtaskTravel = new EtSubtask();
            subtaskTravel.setSubtaskType(SubtaskType.TRAVEL.value());
            subtaskTravel.setProjectId(task.getEtProject().getId());
            subtaskTravel.setVersionId(task.getEtVersion().getId());
            subtaskTravel.setAppId(task.getEtApp().getId());
            subtaskTravel.setTask(task);
            Map stTravelSummary = (Map) st_travel.get("summary");
            if (100 == (Double) stTravelSummary.get("passRate")) {
                //子任务执行成功
                subtaskTravel.setResult(SubtaskResult.SUCCESS.value());
                System.out.println("遍历测试成功");
            } else {
                //子任务执行失败
                subtaskTravel.setResult(SubtaskResult.FAIL.value());
                System.out.println("遍历测试失败");
            }
            subtaskService.addSubTask(subtaskTravel);
        }

    }

    public void synoSubTask(Integer taskId) throws DataBaseException {
        EtTask task = this.queryById(taskId);
        try {
            String result = this.enginePipe.taskPipe().queryTaskResult(task.getTaskId());
            this.synoSubTask(taskId, result);
        } catch (EngineException ee) {

        }
    }

    private List<Mobile> assemMobile(String[] mobiles) throws BusinessException {
        Mobile mobile = null;
        List<Mobile> mobileList = new ArrayList<Mobile>();
        for (String single : mobiles) {
            String[] m = single.split("@#");
            mobile = new Mobile(m[0], m[1], m[2], m[3], m[4]);

            //添加ip信息
            List<EtMobile> list = null;
            try {
                list = mobileService.queryMobilesNew();
            } catch (DataBaseException e) {
                e.printStackTrace();
                throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
            }
            if (list != null && list.size() > 0) {
                for (EtMobile etMobile : list) {
                    if (mobile.getSn().equals(etMobile.getSerialNumber())) {
                        mobile.setIp(etMobile.getRealIp());
                        break;
                    }
                }
            }
            mobileList.add(mobile);
        }
        return mobileList;
    }

    @Override
    public Integer createTask(Integer projectId, Integer userId, Task task, String[] mobiles) throws EngineException, BusinessException, DataBaseException {
        Gson gson = new Gson();

        //设置系统类型
        EtProject etProject = projectService.queryById(projectId);
        task.setTaskOS(etProject.getProjectType());
        //获取并设置apkUrl
        EtApp etApp = appService.queryById(task.getAppId());
        task.setAppUrl(etApp.getAppAddress());

        //添加手机
        List<Mobile> mobileList = assemMobile(mobiles);
        task.setMobiles(mobileList);
        //网络模拟判断
        if ("1".equals(task.getIsNetSimulation())) {
            EtWeaknet etWeaknet = null;
            try {
                etWeaknet = weaknetService.queryByKey(task.getNetSimulationType());
            } catch (DataBaseException e) {
                e.printStackTrace();
                // TODO: 4/14/2017 暂时
                throw new BusinessException(ExceptionEnum.ENGINE_TASK_CONVERSION_ERROR);
            }
            task.setNetSimulationData(etWeaknet.getParam());
        }
        try {
            return submitTask(projectId, userId, task);
        } catch (EngineException e) {
            throw new EngineException(e.getEe());
        }
    }

    @Override
    public Integer submitTask(Integer projectId, Integer userId, Task task) throws EngineException, BusinessException {
        //转换数据至DTO类
        EngineTaskDTO engineTaskDTO = EngineTaskTranslate.translate(task);
        //向下层接口提交任务信息

        try {
            EngineCreateTaskResultDTO result = engineManager.getTaskEngineManager().createTask(engineTaskDTO);
            if (result.isSuccess()) {
                System.out.println("submit task success");
                EtTask newTask = new EtTask();
                //获取任务信息
                EtProject project = new EtProject();
                project.setId(projectId);
                EtUser user = new EtUser();
                user.setId(userId);
                EtApp app = null;
                try {
                    app = appService.queryById(task.getAppId());
                } catch (DataBaseException e) {
                    e.printStackTrace();
                }
                String taskType = "";
                EtTestType testType = null;
                //判断任务引擎, 0为ETE, 1为MTC
                if (task.getEngine() == EngineEnum.ENGINE_MTCE.value()) {
                    //组装mtc任务类型
                    if (String.valueOf(CompatibilityEnum.YES.value()).equals(task.getCompatibilityTest())) {
                        testType = new EtTestType();
                        testType.setId(1);
                        newTask.getTestTypes().add(testType);
                        taskType += "Compatibility";
                        if (String.valueOf(TraversalEnum.YES.value()).equals(task.getTraversalTest()) || String.valueOf(ScriptEnum.YES.value()).equals(task.getScriptTest())) {
                            taskType += ",";
                        }
                    }
                    if (String.valueOf(ScriptEnum.YES.value()).equals(task.getScriptTest())) {
                        testType = new EtTestType();
                        testType.setId(3);
                        newTask.getTestTypes().add(testType);
                        taskType += "Script";
                        if (String.valueOf(TraversalEnum.YES.value()).equals(task.getTraversalTest())) {
                            taskType += ",";
                        }
                    }
                    if (String.valueOf(TraversalEnum.YES.value()).equals(task.getTraversalTest())) {
                        testType = new EtTestType();
                        testType.setId(2);
                        newTask.getTestTypes().add(testType);
                        taskType += "Traversal";
                    }
                } else {
                    testType = new EtTestType();
                    testType.setId(3);
                    newTask.getTestTypes().add(testType);
                    taskType = "SmartTraversal";
                }
                //判断前处理是否设置了网络模拟
                if ("1".equals(task.getIsNetSimulation())) {
                    newTask.setHasNetSimulation(ModelFiledBooleanEnum.TRUE.value());
                    EtWeaknet etWeaknet = null;
                    try {
                        etWeaknet = weaknetService.queryByKey(task.getNetSimulationType());
                    } catch (DataBaseException e) {
                        e.printStackTrace();
                    }
                    newTask.setNetSimulation(etWeaknet);
                } else {
                    newTask.setHasNetSimulation(ModelFiledBooleanEnum.FALSE.value());
                }
                EtVersion version = new EtVersion();
                if (app != null) {
                    version.setId(app.getEtVersion().getId());
                }
                newTask.setEtVersion(version);
                newTask.setEtApp(app);
                newTask.setTaskType(taskType);
                newTask.setEtProject(project);
                newTask.setEtUser(user);
                newTask.setEngine(task.getEngine());
                newTask.setOs(task.getTaskOS());
                newTask.setStatus(0);
                newTask.setTaskName(task.getTaskName());
                newTask.setTaskParam(GsonUtils.toJsonString(task));
                newTask.setTaskId(String.valueOf(result.getId()));
                newTask.setCreateTime(new Date());
                newTask.setSyno(TaskSyno.SYNO_NO.value());
                try {
                    return baseDAO.save(newTask);
                } catch (DataBaseException e) {
                    e.printStackTrace();
                }
            } else {
                throw new EngineException(ExceptionEnum.ENGINE_TASK_PIPE_ERROR);
            }
        } catch (EngineException e) {
            throw new EngineException(e.getEe());
        }
        return null;
    }

    public String queryTaskResult(Integer taskId) throws EngineException, DataBaseException {
        EtTask currentTask = queryById(taskId);
        return this.enginePipe.taskPipe().queryTaskResult(currentTask.getTaskId());
    }

    public String queryTaskMobileResult(Integer taskId, String serialNumber) throws EngineException, DataBaseException {
        EtTask task = queryById(taskId);
        return enginePipe.taskPipe().queryTaskMobileResult(task.getTaskId(), serialNumber);
    }

    @Override
    public String queryTaskMobileRealtimeLog(String mtcTaskId, String serialNumber) throws EngineException {
        return enginePipe.taskPipe().queryTaskRealtimeLog(mtcTaskId, serialNumber);
    }
}
