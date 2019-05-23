package com.dilatoit.engine.engines.mtc.data.task;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xueshan.wei on 4/1/2017.
 */
public class MtcTask {
    @SerializedName("userId")
    private String userId;
    @SerializedName("os")
    private String os;
    @SerializedName("taskInfo")
    private MtcTaskInfo taskInfo;
    @SerializedName("apkUrl")
    private String apkUrl;
    @SerializedName("taskList")
    private MtcTaskList taskList;
    @SerializedName("optInfo")
    private MtcOptInfo optInfo;

    @SerializedName("token")
    private String token;



    public MtcTaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(MtcTaskList taskList) {
        this.taskList = taskList;
    }

    public MtcTaskInfo getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(MtcTaskInfo taskInfo) {
        this.taskInfo = taskInfo;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getApkUrl() {
        return apkUrl;
    }

    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }

    public MtcOptInfo getOptInfo() {
        return optInfo;
    }

    public void setOptInfo(MtcOptInfo optInfo) {
        this.optInfo = optInfo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
