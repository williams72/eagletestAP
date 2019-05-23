package com.dilatoit.engine.enums;

/**
 * 引擎枚举类型
 * Created by xueshan.wei on 6/15/2017.
 */
public enum EngineEnum {
    ENGINE_ETE(0), //迪原引擎
    ENGINE_MTCE(1), //百度引擎
    ENGINE_ALL(2) //所有引擎
    ;
    private int value;

    EngineEnum(int value) {
        this.value = value;
    }
    public int value(){
        return value;
    }
}
