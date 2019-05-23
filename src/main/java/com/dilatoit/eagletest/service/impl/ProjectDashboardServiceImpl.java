package com.dilatoit.eagletest.service.impl;

import com.dilatoit.eagletest.enums.task.SubtaskResult;
import com.dilatoit.eagletest.enums.task.SubtaskType;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtProject;
import com.dilatoit.eagletest.model.EtSubtask;
import com.dilatoit.eagletest.model.EtVersion;
import com.dilatoit.eagletest.service.ProjectDashboardService;
import com.dilatoit.eagletest.service.ProjectService;
import com.dilatoit.eagletest.service.SubtaskService;
import com.dilatoit.eagletest.service.VersionService;
import com.dilatoit.eagletest.util.NoUseClass;
import com.dilatoit.engine.engines.mtc.util.NumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xueshan.wei on 1/16/2017.
 */
@Service(value = "projectDashboardService")
public class ProjectDashboardServiceImpl extends BaseService<NoUseClass> implements ProjectDashboardService {
    @Autowired
    private SubtaskService subtaskService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private VersionService versionService;

    public Map rateOfVersionAndSubtaskType(Integer projectId) throws DataBaseException {
        EtProject project = projectService.queryById(projectId);
        //List<EtVersion> versions = project.getEtVersions();
        List<EtVersion> versions = versionService.queryAllByProId(projectId);
        List<EtSubtask> subtasks = subtaskService.queryByPid(projectId);
        Map result = new HashMap();
        if(subtasks != null && subtasks.size() > 0){
            Map<String, List<String>> rate = new HashMap<String, List<String>>();
            List<String> versionsName = new ArrayList<String>();
            List<EtSubtask> subtasks_com = new ArrayList<EtSubtask>();
            List<EtSubtask> subtasks_case = new ArrayList<EtSubtask>();
            List<EtSubtask> subtasks_travel = new ArrayList<EtSubtask>();
            //统计版本名称
            for(EtVersion version : versions){
                versionsName.add(version.getVersionName());
            }
            //先分成三种测试类型
            for (EtSubtask subtask : subtasks) {
                if (subtask.getSubtaskType().equals(SubtaskType.COMPATIBILITY.value())) {
                    subtasks_com.add(subtask);
                } else if (subtask.getSubtaskType().equals(SubtaskType.SCRIPT_CASE.value())) {
                    subtasks_case.add(subtask);
                } else {
                    subtasks_travel.add(subtask);
                }
            }

            //分别计算三种类型每个版本的成功率
            List<String> rate_com = versionSubtaskRate(subtasks_com, versions);
            List<String> rate_case = versionSubtaskRate(subtasks_case, versions);
            List<String> rate_travel = versionSubtaskRate(subtasks_travel, versions);

            rate.put("rate_com", rate_com);
            rate.put("rate_case", rate_case);
            rate.put("rate_travel", rate_travel);

            //
            result.put("versionsName", versionsName);
            result.put("rate", rate);
            return result;
        }
        return null;
    }

    private List<String> versionSubtaskRate(List<EtSubtask> subtasks, List<EtVersion> versions) {
        Double version_subtask_total;
        Double version_subtask_success;
        Double version_subtask_rate;



        List<String> rate = new ArrayList<String>();
        for (EtVersion version : versions) {
            version_subtask_total = 0.0d;
            version_subtask_success = 0.0d;
            for (EtSubtask subtask : subtasks) {

                if (subtask.getVersionId().equals(version.getId())) {
                    version_subtask_total++;
                    if (subtask.getResult().equals(SubtaskResult.SUCCESS.value())) {
                        //子任务结果为成功
                        version_subtask_success++;
                    }
                }
            }
            if (version_subtask_success == 0) {
                version_subtask_rate = 0.0d;
            } else {
                version_subtask_rate = (version_subtask_success / version_subtask_total) * 100.0;
            }
            rate.add(NumUtils.formatToTwo(version_subtask_rate));
        }
        return rate;
    }
}
