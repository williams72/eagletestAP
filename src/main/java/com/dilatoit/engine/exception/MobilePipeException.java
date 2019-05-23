package com.dilatoit.engine.exception;

import com.dilatoit.eagletest.enums.ExceptionEnum;

/**
 * Created by xueshan.wei on 11/16/2016.
 */
public class MobilePipeException extends EngineException {
    public MobilePipeException() {
        super("mobile pipe has a exception");
    }

    public MobilePipeException(String message) {
        super(message);
    }

    public MobilePipeException(ExceptionEnum ee){
        super(ee);
    }
}
