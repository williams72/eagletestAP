package com.dilatoit.eagletest.enums;

/**
 * Created by beishan on 2016/11/20.
 */
public enum RealMobileStatus {
    //正在进行中的
    UNDERWAY(1),
    //已经完成的
    STOPPED(0);
    private int status;
    private RealMobileStatus(int status){
        this.status = status;
    }
    public int value(){
        return status;
    }
}
