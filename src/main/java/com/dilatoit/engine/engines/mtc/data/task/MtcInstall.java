package com.dilatoit.engine.engines.mtc.data.task;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by beishan on 2017/3/30.
 */
public class MtcInstall {
    @SerializedName("pre_install_files")
    private List<MtcPreInstall> mtcPreInstalls;

    public List<MtcPreInstall> getMtcPreInstalls() {
        return mtcPreInstalls;
    }

    public void setMtcPreInstalls(List<MtcPreInstall> mtcPreInstalls) {
        this.mtcPreInstalls = mtcPreInstalls;
    }
}
