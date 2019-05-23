package com.dilatoit.engine.exception;

import com.dilatoit.eagletest.enums.ExceptionEnum;

/**
 * Created by xueshan.wei on 11/16/2016.
 */
public class CommonsPipeException extends EngineException {
    public CommonsPipeException() {
        super("commons pipe has a exception");
    }

    public CommonsPipeException(String message) {
        super(message);
    }

    public CommonsPipeException(ExceptionEnum ee){
        super(ee);
    }
}
