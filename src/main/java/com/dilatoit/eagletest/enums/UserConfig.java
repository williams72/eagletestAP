package com.dilatoit.eagletest.enums;

/**
 * 用户配置相关常量
 * Created by xueshan.wei on 12/5/2016.
 */
public enum  UserConfig {
    DEFAULT_LAST_PROJECT("last view project", "00");

    private String value;
    private String name;

    UserConfig(String name, String value){
        this.name = name;
        this.value = value;
    }

    public String value(){
        return value;
    }
    public String getName(){
        return name;
    }
}
