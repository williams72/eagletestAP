package com.dilatoit.engine.engines.mtc.data.task;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by xueshan.wei on 4/1/2017.
 */
public class MtcTraversal2 {
    @SerializedName("jobList")
    private List<MtcTraversalJob> jobList;

    public List<MtcTraversalJob> getJobList() {
        return jobList;
    }

    public void setJobList(List<MtcTraversalJob> jobList) {
        this.jobList = jobList;
    }
}
