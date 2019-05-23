package com.dilatoit.eagletest.enums.task;

/**
 * Created by Administrator on 2017/7/4.
 */
public enum ScriptEnum {
    NO(0),
    YES(1);
    private int value;
    ScriptEnum(int value){
        this.value = value;
    }
    public int value(){
        return value;
    }
}
