package com.dilatoit.eagletest.enums.task;

/**
 * Created by xueshan.wei on 12/9/2016.
 */
public enum TaskSyno {
    SYNO_YES("已同步完成", 1),
    SYNO_NO("同步未完成", 0);
    private String name;
    private int value;

    TaskSyno(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int value() {
        return value;
    }
}
