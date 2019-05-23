package com.dilatoit.eagletest.enums.task;

/**
 * Created by Administrator on 2017/7/4.
 */
public enum TraversalEnum {
    NO(0),
    YES(1);
    private int value;
    TraversalEnum(int value){
        this.value = value;
    }
    public int value(){
        return value;
    }
}
