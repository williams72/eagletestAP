package com.dilatoit.eagletest.enums;

/**
 * Created by xueshan.wei on 12/7/2016.
 */
public enum MobileTaskStopType {

    STOP_CURRENT("stop current task", 1),
    STOP_ALL("stop all task", 2);
    private int value;
    private String name;

    MobileTaskStopType(String name, int value){
        this.name = name;
        this.value = value;
    }

    public int value(){
        return value;
    }

    public String getName() {
        return name;
    }
}
