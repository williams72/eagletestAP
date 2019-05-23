package com.dilatoit.eagletest.exception.ex.api;

import com.dilatoit.eagletest.enums.ExceptionEnum;

/**
 * Created by xueshan.wei on 2/16/2017.
 */
public class ApiBusinessException extends ApiBaseException {
    public ApiBusinessException() {
    }

    public ApiBusinessException(ExceptionEnum ee) {
        super(ee);
    }
    public ApiBusinessException(ExceptionEnum ee, Object data) {
        super(ee, data);
    }


}
