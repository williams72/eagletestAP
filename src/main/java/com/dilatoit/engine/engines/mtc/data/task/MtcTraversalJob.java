package com.dilatoit.engine.engines.mtc.data.task;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xueshan.wei on 4/1/2017.
 */
public class MtcTraversalJob {
    @SerializedName("jobInfo")
    private MtcTraversalJobInfo traversalJobInfo;

    @SerializedName("devInfo")
    private MtcMobile mobile;

    public MtcTraversalJobInfo getTraversalJobInfo() {
        return traversalJobInfo;
    }

    public void setTraversalJobInfo(MtcTraversalJobInfo traversalJobInfo) {
        this.traversalJobInfo = traversalJobInfo;
    }

    public MtcMobile getMobile() {
        return mobile;
    }

    public void setMobile(MtcMobile mobile) {
        this.mobile = mobile;
    }
}
