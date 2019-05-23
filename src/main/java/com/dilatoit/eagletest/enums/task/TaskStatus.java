package com.dilatoit.eagletest.enums.task;

/**
 * Created by xueshan.wei on 12/9/2016.
 */
public enum TaskStatus {
    CREATE("创建", 0),
    WAITING("等待中", 1),
    TESTING("执行中", 2),
    COMPLETED("已完成", 3),
    CANCELED("已取消", 4);

    private int value;
    private String name;

    TaskStatus(String name, int value) {
        this.value = value;
        this.name = name;
    }

    public int value() {
        return value;
    }

    public String getName() {
        return name;
    }
}
