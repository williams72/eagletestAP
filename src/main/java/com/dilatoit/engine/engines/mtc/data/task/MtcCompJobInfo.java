package com.dilatoit.engine.engines.mtc.data.task;

import com.google.gson.annotations.SerializedName;

/**
 * Created by beishan on 2017/3/30.
 */
public class MtcCompJobInfo {
    private String testTime;
    private String runType;

    @SerializedName("setup")
    private MtcSetUp mtcSetUp;

    @SerializedName("teardown")
    private MtcTeardown teardown;

    public String getTestTime() {
        return testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime;
    }

    public String getRunType() {
        return runType;
    }

    public void setRunType(String runType) {
        this.runType = runType;
    }

    public MtcSetUp getMtcSetUp() {
        return mtcSetUp;
    }

    public void setMtcSetUp(MtcSetUp mtcSetUp) {
        this.mtcSetUp = mtcSetUp;
    }

    public MtcTeardown getTeardown() {
        return teardown;
    }

    public void setTeardown(MtcTeardown teardown) {
        this.teardown = teardown;
    }
}
