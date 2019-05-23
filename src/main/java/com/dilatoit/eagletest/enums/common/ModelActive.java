package com.dilatoit.eagletest.enums.common;

/**
 * Created by xueshan.wei on 3/14/2017.
 */
public enum ModelActive {

    ACTIVE(1),
    INACTIVE(0);

    private int value;
    ModelActive(int value){
        this.value = value;
    }

    public int value(){
        return value;
    }
}
