package com.dilatoit.engine.pipes;

import com.dilatoit.engine.dto.EngineCreateTaskResultDTO;
import com.dilatoit.engine.dto.EngineTaskDTO;
import com.dilatoit.engine.exception.EngineException;

/**
 * Created by xueshan.wei on 11/16/2016.
 */
public interface TaskPipe {
    /**
     * stop a task
     * @param taskId
     * @return
     * @throws EngineException
     */
    String stopTask(String taskId) throws EngineException;
    /**
     * create a task
     * @return
     * @throws EngineException
     */
    EngineCreateTaskResultDTO createTask(EngineTaskDTO taskDTO) throws EngineException;

    /**
     * query task result by taskId
     * @param taskId
     * @return
     * @throws EngineException
     */
    String queryTaskResult(String taskId) throws EngineException;

    /**
     * query task`s mobile result
     * @param taskId
     * @param serialNumber
     * @return
     * @throws EngineException
     */
    String queryTaskMobileResult(String taskId, String serialNumber) throws EngineException;

    /**
     * querty task realtime log
     * @param taskId
     * @param serialNumber
     * @return
     * @throws EngineException
     */
    String queryTaskRealtimeLog(String taskId, String serialNumber) throws EngineException;
}


