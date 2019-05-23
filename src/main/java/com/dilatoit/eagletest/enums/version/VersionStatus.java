package com.dilatoit.eagletest.enums.version;

/**
 * Created by xueshan.wei on 12/9/2016.
 */
public enum VersionStatus {

    IN_DEVELOPING("开发中", 1),
    IN_TESTING("测试中", 2),
    IN_GA("已发布", 3);

    private String name;
    private int value;
    VersionStatus(String name, int value){
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
