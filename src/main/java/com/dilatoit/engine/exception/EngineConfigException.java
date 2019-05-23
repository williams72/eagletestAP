package com.dilatoit.engine.exception;

import com.dilatoit.eagletest.enums.ExceptionEnum;

/**
 * Created by xueshan.wei on 11/16/2016.
 */
public class EngineConfigException extends EngineException {
    public EngineConfigException(){
        super("engine config has a error");
    }
    public EngineConfigException(String message) {
        super(message);
    }

    public EngineConfigException(ExceptionEnum ee){
        super(ee);
    }
}
