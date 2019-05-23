package com.dilatoit.engine.engines.ete.pipe;

import com.dilatoit.commons.GsonUtils;
import com.dilatoit.engine.dto.EngineCreateTaskResultDTO;
import com.dilatoit.engine.dto.EngineTaskDTO;
import com.dilatoit.engine.dto.EngineTaskMobileDTO;
import com.dilatoit.engine.engines.ete.EteEngineConfig;
import com.dilatoit.engine.engines.ete.EteEngineRemoteMaster;
import com.dilatoit.engine.engines.ete.EteTaskDTO;
import com.dilatoit.engine.engines.ete.utils.SmartTraversal;
import com.dilatoit.engine.engines.ete.utils.SmartTraversalTask;
import com.dilatoit.engine.exception.EngineException;
import com.dilatoit.engine.pipes.TaskPipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * Created by xueshan.wei on 6/15/2017.
 */
@Component
public class EteTaskPipe implements TaskPipe {
    @Autowired
    private EteEngineRemoteMaster eteEngineRemoteMaster;



    @Autowired
    private EteEngineConfig eteEngineConfig;

    @Override
    public String stopTask(String taskId) throws EngineException {
        return null;
    }

    @Override
    public EngineCreateTaskResultDTO createTask(EngineTaskDTO taskDTO) throws EngineException {
        String api = "/api/smtl";
        EteTaskDTO eteTaskDTO = new EteTaskDTO();
        if (taskDTO != null) {
            eteTaskDTO.setAppurl(taskDTO.getAppUrl());
            //添加手机设备
            for (EngineTaskMobileDTO mobileDTO : taskDTO.getMobiles()) {
                eteTaskDTO.getMobiles().add(mobileDTO.getSerialno());
            }

            //发送创建任务请求
            SmartTraversalTask smartTraversalTask = new SmartTraversalTask();
            smartTraversalTask.setAppUrl(eteTaskDTO.getAppurl());
            smartTraversalTask.setSerialno(eteTaskDTO.getMobiles().get(0));
            //Map resultMap = eteEngineRemoteMaster.postMethod(api, GsonUtils.toJsonString(eteTaskDTO));
            Map resultMap = eteEngineRemoteMaster.postMethod(api, GsonUtils.toJsonString(smartTraversalTask));
            EngineCreateTaskResultDTO ectr = new EngineCreateTaskResultDTO();
            if (resultMap.containsKey("code") && "00000000".equals(resultMap.get("code"))) {
                ectr.setSuccess(true);
                Map data = (Map) resultMap.get("data");
                ectr.setId(((Double) data.get("id")).longValue());
                ectr.getResult().put("resultPath", data.get("resultPath"));
            } else {
                ectr.setSuccess(false);
            }
            return ectr;
        } else {
            throw new EngineException("[ETE Task Pipe] 参数不能为空");
        }
    }

    @Override
    public String queryTaskResult(String taskId) throws EngineException {
        SmartTraversal smartTraversal = null;
        String api = "/api/smtl/" + taskId;
        Map resultMap = eteEngineRemoteMaster.getMethod(api);

        if (resultMap.containsKey("code")) {
            String code = (String) resultMap.get("code");
            if ("00000000".equals(code)) {
                //查询成功
                Map data = (Map) resultMap.get("data");
                smartTraversal = new SmartTraversal();
                smartTraversal.setStatus(((Double) data.get("status")).intValue());
                smartTraversal.setResult(((Double) data.get("result")).intValue());
                smartTraversal.setBeginTime(new Date(((Double) data.get("beginTime")).longValue()));
                //smartTraversal.setEndTime(new Date(((Double) data.get("endTime")).longValue()));
                smartTraversal.setResultPath(eteEngineConfig.getServerUrl() + (String)data.get("resultPath"));
                // TODO: 6/2/2017 这里先转换这几个数据，其他数据等有需要时再转换
                return GsonUtils.toJsonString(smartTraversal);
            }
        }
        throw new EngineException("[ETE 查询任务结果出错]");
    }

    @Override
    public String queryTaskMobileResult(String taskId, String serialNumber) throws EngineException {
        return null;
    }
    @Override
    public String queryTaskRealtimeLog(String taskId, String serialNumber) throws EngineException {
        return null;
    }
}
