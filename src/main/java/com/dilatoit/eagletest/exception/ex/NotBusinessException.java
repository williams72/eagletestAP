package com.dilatoit.eagletest.exception.ex;

import com.dilatoit.eagletest.enums.ExceptionEnum;

/**
 * Created by xueshan.wei on 11/14/2016.
 */
public class NotBusinessException extends CheckedException {
    public NotBusinessException() {
    }

    public NotBusinessException(ExceptionEnum ee) {
        super(ee);
    }
}
