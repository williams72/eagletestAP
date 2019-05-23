package com.dilatoit.eagletest.enums;

/**
 * Created by xueshan.wei on 12/1/2016.
 */
public enum ProjectType {

    ANDROID("android", 0),
    IOS("ios", 1);

    private int value;
    private String key;

    ProjectType(String key, int value){
        this.key = key;
        this.value = value;
    }

    public int value(){
        return value;
    }

    public String key(){
        return key;
    }
}
