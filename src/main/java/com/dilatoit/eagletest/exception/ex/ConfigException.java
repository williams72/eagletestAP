package com.dilatoit.eagletest.exception.ex;

import com.dilatoit.eagletest.enums.ExceptionEnum;

/**
 * Created by beishan on 2016/11/15.
 */
public class ConfigException extends CheckedException {
    public ConfigException() {
    }

    public ConfigException(ExceptionEnum ee) {
        super(ee);
    }
}
