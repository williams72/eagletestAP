package com.dilatoit.engine.engines.mtc.data.task;

import com.google.gson.annotations.SerializedName;

/**
 * Created by beishan on 2017/3/30.
 */
public class MtcScript {
    @SerializedName("script_url")
    private String scriptUrl;

    @SerializedName("cmd")
    private String scriptCmd;

    public String getScriptUrl() {
        return scriptUrl;
    }

    public void setScriptUrl(String scriptUrl) {
        this.scriptUrl = scriptUrl;
    }

    public String getScriptCmd() {
        return scriptCmd;
    }

    public void setScriptCmd(String scriptCmd) {
        this.scriptCmd = scriptCmd;
    }
}
