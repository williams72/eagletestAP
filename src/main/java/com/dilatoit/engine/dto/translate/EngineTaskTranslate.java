package com.dilatoit.engine.dto.translate;

import com.dilatoit.eagletest.validate.formtask.Task;
import com.dilatoit.engine.dto.EngineTaskDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/16.
 */
public class EngineTaskTranslate {
    public static EngineTaskDTO translate(Task task){
        EngineTaskDTO engineTaskDTO = null;
        if(task != null){
            engineTaskDTO = new EngineTaskDTO();
            engineTaskDTO.setEngine(task.getEngine());
            engineTaskDTO.setTaskName(task.getTaskName());
            engineTaskDTO.setAppUrl(task.getAppUrl());
            engineTaskDTO.setOsType(task.getTaskOS());
            //重启
            if("0".equals(task.getIsReboot())){
                engineTaskDTO.setReboot(false);
            } else if ("1".equals(task.getIsReboot())){
                engineTaskDTO.setReboot(true);
            }
            //网络模拟
            if("0".equals(task.getIsNetSimulation())){
                engineTaskDTO.setNetsimulation(false);
            } else if ("1".equals(task.getIsNetSimulation())){
                engineTaskDTO.setNetsimulation(true);
                engineTaskDTO.setNetsimulationData(task.getNetSimulationData());
            }
            //兼容
            if("0".equals(task.getCompatibilityTest())){
                engineTaskDTO.setCompatibility(false);
            } else if("1".equals(task.getCompatibilityTest())){
                engineTaskDTO.setCompatibility(true);
                engineTaskDTO.setCompatibilityTime(task.getCompatibilityTime());
                engineTaskDTO.setCompatibilityType(task.getCompatibilityType());
            }

            //脚本
            if("0".equals(task.getScriptTest())){
                engineTaskDTO.setScript(false);
            } else if("1".equals(task.getScriptTest())){
                engineTaskDTO.setScript(true);
                engineTaskDTO.setScriptUrl(task.getScriptUrl());
                engineTaskDTO.setScriptType(task.getScriptType());
                engineTaskDTO.setScriptCmd(task.getScriptCmd());
            }

            //遍历
            if("0".equals(task.getTraversalTest())){
                engineTaskDTO.setTraversal(false);
            } else if("1".equals(task.getTraversalTest())){
                engineTaskDTO.setTraversal(true);
                engineTaskDTO.setTraversalTime(task.getTraversalTime());
            }

            //智能遍历
            if("0".equals(task.getSmartTraversalTest())){
                engineTaskDTO.setSmartTraversal(false);
            } else if("1".equals(task.getSmartTraversalTest())){
                engineTaskDTO.setSmartTraversal(true);
            }

            engineTaskDTO.setOptInfo(task.getOptInfo());
            engineTaskDTO.setMobiles(EngineTaskMobileTranslate.translateList(task.getMobiles()));

        }
        return engineTaskDTO;
    }
    public static List<EngineTaskDTO> translateList(List<Task> tasks){
        List<EngineTaskDTO> list = null;
        if(tasks != null){
            list = new ArrayList<EngineTaskDTO>();
            for(Task task : tasks){
                list.add(EngineTaskTranslate.translate(task));
            }
        }
        return list;
    }


}
