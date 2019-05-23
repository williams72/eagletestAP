package com.dilatoit.eagletest.service;

import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtTask;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;
import com.dilatoit.eagletest.validate.formtask.Task;
import com.dilatoit.engine.exception.EngineException;

import java.util.List;

/**
 * Created by beishan on 2016/11/13.
 */
public interface TaskService {

    /**
     * 创建一个包含智能遍历的任务，注意此次更新只支持执行一种任务（MTC任务|智能遍历）
     * 即如果选择了智能遍历则默认其他测试类型的测试不会执行
     * 已停用
     * @param pid
     * @param uid
     * @param task
     * @param mobiles
     * @return
     * @throws BusinessException
    int createTaskIncludeSmartTraversal(Integer pid, Integer uid, Task task, String [] mobiles) throws BusinessException;
     */

    /**
     * query task by id
     * @param id
     * @return
     * @throws DataBaseException
     */
    EtTask queryById(Integer id) throws DataBaseException;


    /**
     * 根据idList查询任务状态，用于任务页面自动刷新
     * @param ids
     * @return
     * @throws DataBaseException
     */
    List<EtTask> queryListTaskById(List<Integer> ids) throws DataBaseException;

    /**
     * 旧方法，停用
     * 在这里设置脚本测试的默认时间
     * @param pid
     * @param uid
     * @param task
     * @param mobiles
     * @return
     * @throws BusinessException
    Integer createNewInterface(Integer pid, Integer uid, Task task, String [] mobiles) throws BusinessException;
     */

    /**
     * query page
     * @param page
     * @throws DataBaseException
     */
    void page(DataPage<EtTask> page) throws DataBaseException;

    /**
     * query page by conditions
     * @param page
     * @param conditions
     * @throws DataBaseException
     */
    void page(DataPage<EtTask> page, Conditions conditions) throws DataBaseException;

    /**
     * query page by conditions
     * @param page
     * @param conditions
     * @throws DataBaseException
     */
    void pageApi(DataPage<EtTask> page, Conditions conditions) throws DataBaseException;

    /**
     * 将file和mobile，以及相关url集成入task对象中
     * @param projectId
     * @param userId
     * @param task
     * @param mobiles
     * @return
     * @throws BusinessException
     * @throws DataBaseException
     */
    Integer createTask(Integer projectId, Integer userId, Task task, String[] mobiles)throws EngineException, BusinessException, DataBaseException;

    /**
     * 发送任务接口Json，根据返回值创建数据库task
     * @param projectId
     * @param userId
     * @return
     * @throws EngineException
     * @throws BusinessException
     * @throws DataBaseException
     */
    Integer submitTask(Integer projectId, Integer userId, Task task)throws EngineException, BusinessException;

    /**
     * 拼接字符串式创建任务Json，已停用
     * @param task
     * @param mobiles
     * @return
     * @throws EngineException
     * @throws BusinessException
     * @throws DataBaseException
     *
    Integer createTask(Integer projectId, Integer userId, Task task, String[] mobiles) throws EngineException, BusinessException, DataBaseException;
    */

    /**
     *
     * @param taskId
     * @return
     * @throws EngineException
     */
    String queryTaskResult(Integer taskId) throws EngineException, DataBaseException;

    /**
     * 查询某个任务中某个手机的执行结果
     * @param taskId
     * @param serialNumber
     * @return
     * @throws EngineException
     * @throws DataBaseException
     */
    String queryTaskMobileResult(Integer taskId, String serialNumber) throws EngineException, DataBaseException;

    String queryTaskMobileRealtimeLog(String mtcTaskId, String serialNumber) throws EngineException;

    /**
     * 同步子任务
     * @param taskId
     * @param taskResult
     */
    void synoSubTask(Integer taskId, String taskResult) throws DataBaseException;

    void synoSubTask(Integer taskId) throws DataBaseException;


    void synoTaskStatus() throws EngineException, DataBaseException;
    /**
     * stop task
     * @param taskId
     * @return
     * @throws BusinessException
     */
    String stopTask(Integer taskId) throws BusinessException;

    /**
     * 分页查询某个项目下任务
     * @param projectId
     * @return
     * @throws BusinessException
     */
    void queryTasksByProjectId(DataPage<EtTask> page, int projectId) throws BusinessException;

    /**
     * 分页查询某个项目下任务,无需同步任务状态
     * @param projectId
     * @return
     * @throws BusinessException
     */
    void queryTasksByProjectIdApi(DataPage<EtTask> page, int projectId) throws BusinessException;

    /**
     * 查询某个项目下所有的任务
     * @param projectId
     * @return
     * @throws BusinessException
     */
    List<EtTask> queryTasksByProjectId(int projectId) throws BusinessException;
}
