package com.dilatoit.eagletest.service.impl;

import com.dilatoit.eagletest.enums.task.SubtaskType;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtSubtask;
import com.dilatoit.eagletest.service.SubtaskService;
import com.dilatoit.eagletest.util.Conditions;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xueshan.wei on 1/5/2017.
 */
@Service(value = "subtaskService")
public class SubtaskServiceImpl extends BaseService<EtSubtask> implements SubtaskService {
    public List<EtSubtask> queryByConditions(Conditions conditions) throws DataBaseException {
        return baseDAO.queryByConditions(com.dilatoit.eagletest.model.EtSubtask.class, conditions);
    }

    public List<EtSubtask> queryByTaskId(Integer taskId) throws DataBaseException {
        Conditions conditions = new Conditions();
        conditions.addCondition("task_id", taskId, Conditions.Operator.EQUAL);
        return queryByConditions(conditions);
    }

    public void addSubTask(EtSubtask subtask) throws DataBaseException {
        this.baseDAO.save(subtask);
    }

    public List<EtSubtask> queryByPidAndSubtaskType(Integer projectId, SubtaskType subtaskType) throws DataBaseException {
        Conditions conditions = new Conditions();
        conditions.addCondition("projectId", projectId, Conditions.Operator.EQUAL);
        conditions.addCondition("subtaskType", subtaskType.value(), Conditions.Operator.EQUAL);
        return queryByConditions(conditions);
    }

    public List<EtSubtask> queryByPid(Integer projectId) throws DataBaseException {
        Conditions conditions = new Conditions();
        conditions.addCondition("projectId", projectId, Conditions.Operator.EQUAL);
        return queryByConditions(conditions);
    }
}
