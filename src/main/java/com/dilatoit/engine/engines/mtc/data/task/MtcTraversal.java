package com.dilatoit.engine.engines.mtc.data.task;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xueshan.wei on 4/1/2017.
 */
public class MtcTraversal {
    @SerializedName("travel")
    private MtcTraversal2 travel;

    public MtcTraversal2 getTravel() {
        return travel;
    }

    public void setTravel(MtcTraversal2 travel) {
        this.travel = travel;
    }
}
