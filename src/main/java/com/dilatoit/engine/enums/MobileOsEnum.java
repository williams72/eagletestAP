package com.dilatoit.engine.enums;

/**
 * Created by xueshan.wei on 11/17/2016.
 */
public enum MobileOsEnum {
    ALL(0),
    ANDROID(1),
    IOS(2);

    private final int osType;

    private MobileOsEnum(int osType){
        this.osType = osType;
    }
    public int value(){
        return this.osType;
    }
}
