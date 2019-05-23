package com.dilatoit.engine.engines.mtc.data.task;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xueshan.wei on 4/1/2017.
 */
public class MtcTraversalJobInfo {
    @SerializedName("testTime")
    private Integer testTime;

    @SerializedName("setup")
    private MtcSetUp setUp;
    @SerializedName("teardown")
    private MtcTeardown teardown;

    public Integer getTestTime() {
        return testTime;
    }

    public void setTestTime(Integer testTime) {
        this.testTime = testTime;
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
