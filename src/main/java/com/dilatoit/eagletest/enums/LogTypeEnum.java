package com.dilatoit.eagletest.enums;

/**
 * Created by xueshan.wei on 11/14/2016.
 */
public enum LogTypeEnum {
    LOG_OPERATE(1),
    LOG_EXCEPTION(0);

    private final int logType;

    private LogTypeEnum(int logType){
        this.logType = logType;
    }

    public int value(){
        return this.logType;
    }
}
