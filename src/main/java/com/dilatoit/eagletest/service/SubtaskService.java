package com.dilatoit.eagletest.service;


import com.dilatoit.eagletest.enums.task.SubtaskType;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtSubtask;
import com.dilatoit.eagletest.util.Conditions;

import java.util.List;

/**
 * Created by xueshan.wei on 1/5/2017.
 */
public interface SubtaskService {
    /**
     * 条件查询
     * @param conditions
     * @return
     * @throws DataBaseException
     */
    List<EtSubtask> queryByConditions(Conditions conditions) throws DataBaseException;

    /**
     * 根据taskid 查询子任务
     * @param taskId
     * @return
     * @throws DataBaseException
     */
    List<EtSubtask> queryByTaskId(Integer taskId) throws DataBaseException;

    /**
     * 增加子任务
     * @param subtask
     * @throws DataBaseException
     */
    void addSubTask(EtSubtask subtask) throws DataBaseException;

    /**
     * 根据项目id 和 子任务类型查询子任务
     * @param projectId
     * @param subtaskType
     * @return 返回所有符合条件的子任务
     * @throws DataBaseException
     */
    List<EtSubtask> queryByPidAndSubtaskType(Integer projectId, SubtaskType subtaskType) throws DataBaseException;

    /**
     * 根据项目id 查询子任务
     * @param projectId
     * @return
     * @throws DataBaseException
     */
    List<EtSubtask> queryByPid(Integer projectId) throws DataBaseException;


}
