package com.dilatoit.eagletest.enums;

/**
 * Created by xueshan.wei on 12/28/2016.
 */
public enum AppType {
    ANDROID("apk"),
    IOS("ipa");
    private String value;
    private AppType(String value){
        this.value = value;
    }
    public String value(){
        return value;
    }
}
