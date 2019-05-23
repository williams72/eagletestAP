package com.dilatoit.eagletest.exception.ex;


import com.dilatoit.eagletest.enums.ExceptionEnum;

/**
 * Created by xueshan.wei on 11/14/2016.
 */
public class BusinessException extends CheckedException {
    public BusinessException() {
    }

    public BusinessException(ExceptionEnum ee) {
        super(ee);
    }
}
