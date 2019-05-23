package com.dilatoit.eagletest.exception.ex;

import com.dilatoit.eagletest.enums.ExceptionEnum;

/**
 * Created by beishan on 2016/11/15.
 */
public class MtcConfigException extends ConfigException {
    public MtcConfigException() {
    }

    public MtcConfigException(ExceptionEnum ee) {
        super(ee);
    }
}
