package com.dilatoit.eagletest.validate.api;

import com.google.gson.annotations.Expose;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Api Return Result Model
 * Created by xueshan.wei on 2/8/2017.
 */
@Component
@Scope(value = "prototype")
public class ApiResult {
    @Expose
    private String msg;
    @Expose
    private String code;
    @Expose
    private Object data;

    public ApiResult(){
        code = "00000000";
        msg = "查询正常";
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void reset(){
        this.code = "00000000";
        this.msg = "查询正常";
        this.data = null;
    }

    public void setApiResult(String msg, Object data){
        this.msg = msg;
        this.data = data;
    }
}
