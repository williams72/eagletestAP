package com.dilatoit.engine.engines.mtc.pipe;

import com.dilatoit.commons.GsonUtils;
import com.dilatoit.commons.http.HttpUtils;
import com.dilatoit.engine.dto.EngineCreateTaskResultDTO;
import com.dilatoit.engine.dto.EngineTaskDTO;
import com.dilatoit.engine.engines.mtc.config.MtcConfig;
import com.dilatoit.engine.engines.mtc.data.MtcTaskConversion;
import com.dilatoit.engine.exception.EngineException;
import com.dilatoit.engine.pipes.TaskPipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by xueshan.wei on 11/16/2016.
 */
@Component
public class MtcTaskPipe extends MtcBasePipe implements TaskPipe{
    private static Logger LOGGER = LoggerFactory.getLogger(MtcTaskPipe.class);

    @Autowired
    private MtcTaskConversion mtcTaskConversion;

    public String stopTask(String taskId) throws EngineException {
        String params = "taskId=" + taskId + "&reasonInfo={\"userId\":\"1\"}";
        return this.accessApi("api_task_stop", params);
    }

    public EngineCreateTaskResultDTO createTask(EngineTaskDTO taskDTO) throws EngineException {
        String taskJson = mtcTaskConversion.conversion(taskDTO);
        String result = null;
        try {
            result = HttpUtils.sendJsonPost(getCreateTaskUrl(), taskJson);
        } catch (Exception e) {
            e.printStackTrace();
            throw new EngineException("[MTCE] 连接出错");
        }
        System.out.println(result);
        EngineCreateTaskResultDTO ectr = new EngineCreateTaskResultDTO();
        Map resultMap = GsonUtils.toMap(result);
        if(resultMap != null && !resultMap.containsKey("Error")){
            if(resultMap.containsKey("status") && "success".equals(resultMap.get("status"))){
                ectr.setSuccess(true);
                Map taskInfo = (Map)resultMap.get("taskInfo");
                //the task id is not to big
                int taskId = Integer.parseInt((String)taskInfo.get("id"));
                ectr.setId(taskId);
                ectr.setResult(resultMap);
                return ectr;
            }
        }
        ectr.setSuccess(false);
        ectr.setResult(resultMap);
        return ectr;
    }


    public String queryTaskResult(String taskId) throws EngineException {
        String params = "taskId=" + taskId;
        return this.accessApi("api_task_result", params);
    }

    public String queryTaskMobileResult(String taskId, String serialNumber) throws EngineException {
        String params = "taskId=" + taskId + "&serialNumber=" + serialNumber;
        return this.accessApi("api_task_mobile_result", params);
    }

    public String queryTaskRealtimeLog(String taskId, String serialNumber) throws EngineException{
        String params = "{\"taskId\":\"" + taskId + "\",\"serialNumber\":\"" + serialNumber + "\"}";
        String result = null;
        try{
            result =  HttpUtils.sendJsonPost(getRFLogUrl(), params);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
