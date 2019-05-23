package com.dilatoit.eagletest.dto.translate;



import com.dilatoit.commons.GsonUtils;
import com.dilatoit.eagletest.dto.TaskDTO;
import com.dilatoit.eagletest.model.EtTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xueshan.wei on 5/17/2017.
 */
public class TaskDTOTranslate {

    public static TaskDTO translate(EtTask task){
        TaskDTO taskDTO = null;
        if(task != null){
            taskDTO = new TaskDTO();
            taskDTO.setTaskId(task.getId());
            taskDTO.setProjectId(task.getEtProject().getId());
            taskDTO.setTaskName(task.getTaskName());
            taskDTO.setStatus(task.getStatus());
            taskDTO.setTaskParam(GsonUtils.toMap(task.getTaskParam()));
            taskDTO.setCreateTime(task.getCreateTime() != null ? task.getCreateTime().getTime() : 0L);
            taskDTO.setStartTime(task.getStarttime() != null ? task.getStarttime().getTime() : 0L);
            taskDTO.setEndTime(task.getEndtime() != null ? task.getEndtime().getTime() : 0L);
            taskDTO.setTaskType(task.getTaskType());
            taskDTO.setExcel(task.getExcel());
            taskDTO.setResult(GsonUtils.toMap(task.getResult()));
        }
        return taskDTO;
    }

    public static List<TaskDTO> translateList(List<EtTask> objs){
        List<TaskDTO> list = null;
        if(objs != null){
            list = new ArrayList<TaskDTO>();
            for(EtTask obj : objs){
                list.add(TaskDTOTranslate.translate(obj));
            }
        }
        return list;
    }
}
