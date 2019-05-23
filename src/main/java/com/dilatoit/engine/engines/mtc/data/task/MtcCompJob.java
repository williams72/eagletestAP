package com.dilatoit.engine.engines.mtc.data.task;

import com.google.gson.annotations.SerializedName;

/**
 * Created by beishan on 2017/3/30.
 */
public class MtcCompJob {
    @SerializedName("jobInfo")
    private MtcCompJobInfo jobInfo;
    @SerializedName("devInfo")
    private MtcMobile mtcMobile;

    public MtcCompJobInfo getJobInfo() {
        return jobInfo;
    }

    public void setJobInfo(MtcCompJobInfo jobInfo) {
        this.jobInfo = jobInfo;
    }

    public MtcMobile getMtcMobile() {
        return mtcMobile;
    }

    public void setMtcMobile(MtcMobile mtcMobile) {
        this.mtcMobile = mtcMobile;
    }
}
