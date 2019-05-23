package com.dilatoit.engine.engines.ete;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于向与ete engine 后台交互的ＤＴＯ类
 * Created by xueshan.wei on 6/19/2017.
 */
public class EteTaskDTO {
    private String appurl;
    private int testType;

    private List<String> mobiles = new ArrayList<>();

    public String getAppurl() {
        return appurl;
    }

    public void setAppurl(String appurl) {
        this.appurl = appurl;
    }

    public List<String> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<String> mobiles) {
        this.mobiles = mobiles;
    }
}
