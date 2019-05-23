package com.dilatoit.engine.engines.mtc.data.task;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by xueshan.wei on 4/1/2017.
 */
public class MtcCaseType {
    @SerializedName("jobList")
    private List<MtcCaseJob> caseJobList;

    public List<MtcCaseJob> getCaseJobList() {
        return caseJobList;
    }

    public void setCaseJobList(List<MtcCaseJob> caseJobList) {
        this.caseJobList = caseJobList;
    }
}
