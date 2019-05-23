package com.dilatoit.engine.enums;

/**
 * Created by xueshan.wei on 11/18/2016.
 */
public enum  RealMobileTime {
    TIME_1(1),
    TIME_2(2),
    TIME_3(3);

    private int time_length;

    private RealMobileTime(int time_length){
        this.time_length = time_length;
    }
    public int value(){
        return this.time_length;
    }
}
