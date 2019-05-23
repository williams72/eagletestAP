package com.dilatoit.eagletest.exception.ex.api;

import com.dilatoit.eagletest.enums.ExceptionEnum;

/**
 * Created by xueshan.wei on 2/16/2017.
 */
public class ApiBaseException extends Exception{
    //异常的类型，及基本信息
    protected ExceptionEnum ee;
    //异常的具体信息，以及一些附加信息
    protected Object data;

    public ApiBaseException() {
    }

    public ApiBaseException(ExceptionEnum ee) {
        super(ee.getCode() + "------" + ee.getMessage());
        this.ee = ee;
    }
    public ApiBaseException(ExceptionEnum ee, Object data) {
        super(ee.getCode() + "------" + ee.getMessage());
        this.ee = ee;
        this.data = data;
    }

    public ExceptionEnum getEe() {
        return ee;
    }

    public void setEe(ExceptionEnum ee) {
        this.ee = ee;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
