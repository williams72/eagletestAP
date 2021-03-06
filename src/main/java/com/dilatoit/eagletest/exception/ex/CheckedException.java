package com.dilatoit.eagletest.exception.ex;

import com.dilatoit.eagletest.enums.ExceptionEnum;

/**
 * Created by xueshan.wei on 11/14/2016.
 */
public class CheckedException extends Exception{
    protected ExceptionEnum ee;

    public CheckedException() {
    }

    public CheckedException(ExceptionEnum ee) {
        super(ee.getCode() + "------" + ee.getMessage());
        this.ee = ee;
    }

    public ExceptionEnum getEe() {
        return ee;
    }

    public void setEe(ExceptionEnum ee) {
        this.ee = ee;
    }
}
