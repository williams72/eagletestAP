package com.dilatoit.eagletest.enums.task;

/**
 * Created by xueshan.wei on 1/16/2017.
 */
public enum SubtaskType {
    COMPATIBILITY(1, "兼容行测试"),
    SCRIPT_CASE(2, "脚本测试"),
    TRAVEL(3, "遍历测试");
    private int value;
    private String name;
    SubtaskType(int value, String name){
        this.value = value;
        this.name = name;
    }

    public int value(){
        return value;
    }
    public String getName(){
        return name;
    }
}
