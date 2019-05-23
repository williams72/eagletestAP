package com.dilatoit.eagletest.authority.enums;

/**
 * 资源操作，标识符
 * Created by xueshan.wei on 12/5/2016.
 */
public enum ResOperator {
    ADD("add"),
    DELETE("delete"),
    QUERY("query"),
    UPDATE("update");

    private String operator;
    ResOperator (String operator){
        this.operator = operator;
    }
}
