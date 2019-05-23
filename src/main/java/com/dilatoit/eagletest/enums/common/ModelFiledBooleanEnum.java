package com.dilatoit.eagletest.enums.common;

/**
 * Created by xueshan.wei on 4/14/2017.
 */
public enum ModelFiledBooleanEnum {
    TRUE(1),
    FALSE(0)
    ;
    private int value;

    ModelFiledBooleanEnum(int value) {
        this.value = value;
    }

    public int value(){
        return value;
    }
}
