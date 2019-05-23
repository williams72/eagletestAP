package com.dilatoit.engine.engines.ete.utils;

/**
 * Created by xueshan.wei on 6/2/2017.
 */
public enum SmartTraversalStatus {
    //已创建
    CREATED(0),
    //等待中
    WAITING(1),
    RUNNING(2),
    COMPLETED(3),
    CANCELLED(4),
    ERROR(5)
            ;
    private int status;
    private SmartTraversalStatus(int status){
        this.status = status;
    }
    public int value(){
        return status;
    }


}
