package com.dilatoit.eagletest.enums.task;

/**
 * Created by xueshan.wei on 2/21/2017.
 */
public enum MonkeyType {
    MONKEY(0, "monkey"),
    SMART_MONKEY(1, "smartMonkey");

    private int value;
    private String name;

    MonkeyType(int value, String name){
        this.value = value;
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public int value(){
        return value;
    }
}
