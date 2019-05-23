package com.dilatoit.eagletest.exception.ex;


import com.dilatoit.eagletest.enums.ExceptionEnum;
import org.springframework.validation.BindingResult;

/**
 * Created by xueshan.wei on 11/14/2016.
 */
public class ParameterException extends BadRequestException {
    private BindingResult bindingResult;
    public ParameterException() {
    }

    public ParameterException(ExceptionEnum ee, BindingResult bindingResult) {
        super(ee);
        this.bindingResult = bindingResult;
    }

    public ParameterException(ExceptionEnum ee) {
        super(ee);
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public void setBindingResult(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }
}
