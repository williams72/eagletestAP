package com.dilatoit.eagletest.exception.ex.api;


import com.dilatoit.eagletest.enums.ExceptionEnum;


/**
 * Created by xueshan.wei on 2/16/2017.
 */
public class ApiParameterException extends ApiBusinessException{
    public ApiParameterException() {
    }

    public ApiParameterException(ExceptionEnum ee) {
        super(ee);
    }
    public ApiParameterException(ExceptionEnum ee, Object data) {
        super(ee, data);
    }
}
