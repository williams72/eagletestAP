package com.dilatoit.eagletest.dto;

import com.google.gson.annotations.Expose;

/**
 * Net Simulation
 * Created by xueshan.wei on 5/12/2017.
 */
public class NetSimulationDTO {
    @Expose
    private String name;
    @Expose
    private String key;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
