package com.dilatoit.engine.engines.mtc.data.task;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xueshan.wei on 4/1/2017.
 */
public class MtcTaskList {
    @SerializedName("compatibility")
    private MtcComp comp;
    @SerializedName("case")
    private MtcCase mtcCase;
    @SerializedName("travel")
    private MtcTraversal traversal;

    public MtcComp getComp() {
        return comp;
    }

    public void setComp(MtcComp comp) {
        this.comp = comp;
    }

    public MtcCase getMtcCase() {
        return mtcCase;
    }

    public void setMtcCase(MtcCase mtcCase) {
        this.mtcCase = mtcCase;
    }

    public MtcTraversal getTraversal() {
        return traversal;
    }

    public void setTraversal(MtcTraversal traversal) {
        this.traversal = traversal;
    }
}
