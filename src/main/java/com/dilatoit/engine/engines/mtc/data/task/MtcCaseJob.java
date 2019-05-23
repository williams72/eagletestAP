package com.dilatoit.engine.engines.mtc.data.task;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xueshan.wei on 4/1/2017.
 */
public class MtcCaseJob {
    @SerializedName("jobInfo")
    private MtcCaseJobInfo caseJobInfo;

    @SerializedName("devInfo")
    private MtcMobile mtcMobile;

    public MtcCaseJobInfo getCaseJobInfo() {
        return caseJobInfo;
    }

    public void setCaseJobInfo(MtcCaseJobInfo caseJobInfo) {
        this.caseJobInfo = caseJobInfo;
    }

    public MtcMobile getMtcMobile() {
        return mtcMobile;
    }

    public void setMtcMobile(MtcMobile mtcMobile) {
        this.mtcMobile = mtcMobile;
    }
}
