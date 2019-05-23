package com.dilatoit.engine.engines.mtc.data.task;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by beishan on 2017/3/30.
 */
public class MtcTeardown {
    @SerializedName("script")
    private List<MtcScript> mtcScripts;
    private boolean reboot;

    @SerializedName("clean_apk")
    private boolean cleanApk;

    public List<MtcScript> getMtcScripts() {
        return mtcScripts;
    }

    public void setMtcScripts(List<MtcScript> mtcScripts) {
        this.mtcScripts = mtcScripts;
    }

    public boolean isReboot() {
        return reboot;
    }

    public void setReboot(boolean reboot) {
        this.reboot = reboot;
    }

    public boolean isCleanApk() {
        return cleanApk;
    }

    public void setCleanApk(boolean cleanApk) {
        this.cleanApk = cleanApk;
    }
}
