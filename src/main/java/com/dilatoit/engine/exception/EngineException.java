package com.dilatoit.engine.exception;

import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.exception.ex.InternalServerException;

/**
 * Created by xueshan.wei on 11/16/2016.
 */
public class EngineException extends InternalServerException {
    public EngineException(String message) {

    }

    public EngineException(ExceptionEnum ee){
        super(ee);
    }
}
