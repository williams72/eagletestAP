package com.dilatoit.engine.exception;

import com.dilatoit.eagletest.enums.ExceptionEnum;

/**
 * Created by xueshan.wei on 11/16/2016.
 */
public class TaskPipeException extends EngineException {
    public TaskPipeException() {
        super("task pipe has a exception");
    }

    public TaskPipeException(String message) {
        super(message);
    }

    public TaskPipeException(ExceptionEnum ee){
        super(ee);
    }
}
