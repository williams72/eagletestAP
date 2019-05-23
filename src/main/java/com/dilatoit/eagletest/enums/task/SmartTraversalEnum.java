package com.dilatoit.eagletest.enums.task;

/**
 * Created by Administrator on 2017/7/4.
 */
public enum SmartTraversalEnum {
    NO(0),
    YES(1);
    private int value;
    SmartTraversalEnum(int value){
        this.value = value;
    }
    public int value(){
        return value;
    }
}
