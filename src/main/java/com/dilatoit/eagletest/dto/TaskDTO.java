package com.dilatoit.eagletest.dto;

import com.google.gson.annotations.Expose;

import java.util.Map;

/**
 * Created by xueshan.wei on 5/17/2017.
 */
public class TaskDTO {
    @Expose
    private int projectId;
    @Expose
    private int taskId;
    @Expose
    private String taskName;
    @Expose
    private int status;
    @Expose
    private Map taskParam;
    @Expose
    private long createTime;
    @Expose
    private long startTime;
    @Expose
    private long endTime;
    @Expose
    private String taskType;
    @Expose
    private String excel;
    @Expose
    private Map result;

    @Override
    public String toString() {
        return "TaskDTO{" +
                "projectId=" + projectId +
                ", taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", status=" + status +
                ", taskParam='" + taskParam + '\'' +
                ", createTime=" + createTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", taskType='" + taskType + '\'' +
                ", excel='" + excel + '\'' +
                ", result=" + result +
                '}';
    }

    public Map getResult() {
        return result;
    }

    public void setResult(Map result) {
        this.result = result;
    }

    public String getExcel() {
        return excel;
    }

    public void setExcel(String excel) {
        this.excel = excel;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map getTaskParam() {
        return taskParam;
    }

    public void setTaskParam(Map taskParam) {
        this.taskParam = taskParam;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }
}
