package com.dilatoit.engine.exception;

import com.dilatoit.eagletest.enums.ExceptionEnum;

/**
 * Created by xueshan.wei on 11/16/2016.
 */
public class RealMobilePipeException extends EngineException{
    public RealMobilePipeException() {
        super("real mobile pipe has a exception");
    }

    public RealMobilePipeException(String message) {
        super(message);
    }

    public RealMobilePipeException(ExceptionEnum ee){
        super(ee);
    }
}
