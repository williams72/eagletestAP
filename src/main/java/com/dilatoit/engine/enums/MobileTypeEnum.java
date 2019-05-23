package com.dilatoit.engine.enums;

/**
 * Created by xueshan.wei on 6/15/2017.
 */
public enum MobileTypeEnum {
    ANDROID(0),
    IOS(1)
    ;
    private int value;

    MobileTypeEnum(int value) {
        this.value = value;
    }
    public int value(){
        return value;
    }
}
