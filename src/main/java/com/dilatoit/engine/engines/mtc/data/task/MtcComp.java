package com.dilatoit.engine.engines.mtc.data.task;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xueshan.wei on 4/1/2017.
 */
public class MtcComp {
    @SerializedName("monkey")
    private MtcMonkey mtcMonkey;

    public MtcMonkey getMtcMonkey() {
        return mtcMonkey;
    }

    public void setMtcMonkey(MtcMonkey mtcMonkey) {
        this.mtcMonkey = mtcMonkey;
    }
}
