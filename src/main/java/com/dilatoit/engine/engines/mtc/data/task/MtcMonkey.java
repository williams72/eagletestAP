package com.dilatoit.engine.engines.mtc.data.task;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by beishan on 2017/3/30.
 */
public class MtcMonkey {
    @SerializedName("jobList")
    private List<MtcCompJob> jobList;

    public List<MtcCompJob> getJobList() {
        return jobList;
    }

    public void setJobList(List<MtcCompJob> jobList) {
        this.jobList = jobList;
    }
}
