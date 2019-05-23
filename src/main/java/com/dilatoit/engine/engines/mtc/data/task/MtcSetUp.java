package com.dilatoit.engine.engines.mtc.data.task;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by beishan on 2017/3/30.
 */
public class MtcSetUp {

    @SerializedName("env")
    private MtcEnv env;//default clean

    @SerializedName("install")
    private MtcInstall mtcInstall;
    private boolean reboot;

    @SerializedName("script")
    private List<MtcScript> mtcScripts;

    public MtcEnv getEnv() {
        return env;
    }

    public void setEnv(MtcEnv env) {
        this.env = env;
    }

    public MtcInstall getMtcInstall() {
        return mtcInstall;
    }

    public void setMtcInstall(MtcInstall mtcInstall) {
        this.mtcInstall = mtcInstall;
    }

    public boolean isReboot() {
        return reboot;
    }

    public void setReboot(boolean reboot) {
        this.reboot = reboot;
    }

    public List<MtcScript> getMtcScripts() {
        return mtcScripts;
    }

    public void setMtcScripts(List<MtcScript> mtcScripts) {
        this.mtcScripts = mtcScripts;
    }
}
