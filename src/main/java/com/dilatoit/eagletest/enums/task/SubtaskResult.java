package com.dilatoit.eagletest.enums.task;

/**
 * Created by xueshan.wei on 1/16/2017.
 */
public enum SubtaskResult {
    SUCCESS(1, "子任务执行成功"),
    FAIL(2, "子任务执行失败");
    private int value;
    private String name;
    SubtaskResult(int value, String name){
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
