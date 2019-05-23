package com.dilatoit.engine.engines.mtc.data.task;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xueshan.wei on 4/13/2017.
 */
public class MtcEnv {
    @SerializedName("clean")
    private boolean clean;

    public MtcEnv() {
    }

    public MtcEnv(boolean clean) {
        this.clean = clean;
    }

    public boolean isClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }
}
