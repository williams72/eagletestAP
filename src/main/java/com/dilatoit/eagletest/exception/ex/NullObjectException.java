package com.dilatoit.eagletest.exception.ex;

import com.dilatoit.eagletest.enums.ExceptionEnum;

/**
 * Created by xueshan.wei on 11/14/2016.
 */
public class NullObjectException extends BusinessException {
    public NullObjectException() {
    }

    public NullObjectException(ExceptionEnum ee) {
        super(ee);
    }
}
