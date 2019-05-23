package com.dilatoit.engine.exception;

import com.dilatoit.eagletest.enums.ExceptionEnum;

/**
 * Created by xueshan.wei on 4/10/2017.
 */
public class EngineNotFoundException extends EngineException {
    public EngineNotFoundException(String message) {
        super(message);
    }

    public EngineNotFoundException(ExceptionEnum ee) {
        super(ee);
    }
}
