package com.dilatoit.eagletest.enums.task;

/**
 * Created by Administrator on 2017/7/4.
 */
public enum CompatibilityEnum {
    NO(0),
    YES(1);
    private int value;
    CompatibilityEnum(int value){
        this.value = value;
    }
    public int value(){
        return value;
    }

}
