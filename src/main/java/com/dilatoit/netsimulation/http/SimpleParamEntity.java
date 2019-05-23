package com.dilatoit.netsimulation.http;

/**
 * 简单参数实体
 * Created by xueshan.wei on 5/12/2017.
 */
public class SimpleParamEntity {
    private String name;
    private String value;

    public SimpleParamEntity(){

    }

    public SimpleParamEntity(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
