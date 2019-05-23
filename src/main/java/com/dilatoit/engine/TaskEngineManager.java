package com.dilatoit.engine;

import com.dilatoit.engine.dto.EngineCreateTaskResultDTO;
import com.dilatoit.engine.dto.EngineTaskDTO;
import com.dilatoit.engine.engines.ete.pipe.EteTaskPipe;
import com.dilatoit.engine.engines.mtc.pipe.MtcTaskPipe;
import com.dilatoit.engine.enums.EngineEnum;
import com.dilatoit.engine.exception.EngineException;
import com.dilatoit.engine.pipes.TaskPipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 任务引擎管理类
 * Created by xueshan.wei on 6/15/2017.
 */
@Component
public class TaskEngineManager {
    @Autowired
    private MtcTaskPipe mtcTaskPipe;
    @Autowired
    private EteTaskPipe eteTaskPipe;

    /**
     * 任务执行分发类，根据选用的不同引擎来分发任务
     * @param taskDTO
     * @throws EngineException
     */
    public EngineCreateTaskResultDTO createTask(EngineTaskDTO taskDTO) throws EngineException{
        if(taskDTO.getEngine() == EngineEnum.ENGINE_ETE.value()){
            return createTask(eteTaskPipe, taskDTO);
        }else if(taskDTO.getEngine() == EngineEnum.ENGINE_MTCE.value()){
            return createTask(mtcTaskPipe, taskDTO);
        }
        return null;
    }

    private EngineCreateTaskResultDTO createTask(TaskPipe taskPipe, EngineTaskDTO taskDTO) throws EngineException{
        return taskPipe.createTask(taskDTO);
    }

    public String queryTaskResult(EngineEnum engineEnum, String taskId) throws EngineException{
        String result = null;
        switch (engineEnum){
            case ENGINE_ETE:
                result = eteTaskPipe.queryTaskResult(taskId);
                break;
            case ENGINE_MTCE:
                result = mtcTaskPipe.queryTaskResult(taskId);
                break;
            default:
                break;
        }
        return result;
    }
}
