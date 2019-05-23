package com.dilatoit.engine.engines.mtc.data;

/**
 * Created by xueshan.wei on 6/15/2017.
 */
public enum MtcTaskOsType {
    ANDROID("android", 0),
    IOS("ios", 1)
    ;
    private String name;
    private int value;

    MtcTaskOsType(String name, int value) {
        this.name = name;
        this.value = value;
    }
    public int value(){
        return value;
    }
    public String getName(){
        return name;
    }
}
