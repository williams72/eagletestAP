package com.dilatoit.engine.engines.mtc.data.task;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xueshan.wei on 4/1/2017.
 */
public class MtcCaseJobInfo {
    @SerializedName("taskCaseUrl")
    private String taskCaseUrl;
    @SerializedName("testTime")
    private Integer testTime;
    @SerializedName("runCmd")
    private String runCmd;
    @SerializedName("setup")
    private MtcSetUp setUp;
    @SerializedName("teardown")
    private MtcTeardown teardown;

    public String getTaskCaseUrl() {
        return taskCaseUrl;
    }

    public void setTaskCaseUrl(String taskCaseUrl) {
        this.taskCaseUrl = taskCaseUrl;
    }

    public Integer getTestTime() {
        return testTime;
    }

    public void setTestTime(Integer testTime) {
        this.testTime = testTime;
    }

    public String getRunCmd() {
        return runCmd;
    }

    public void setRunCmd(String runCmd) {
        this.runCmd = runCmd;
    }

    public MtcSetUp getSetUp() {
        return setUp;
    }

    public void setSetUp(MtcSetUp setUp) {
        this.setUp = setUp;
    }

    public MtcTeardown getTeardown() {
        return teardown;
    }

    public void setTeardown(MtcTeardown teardown) {
        this.teardown = teardown;
    }
}
