package com.dilatoit.eagletest.validate.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 弱网验证类
 * Created by xueshan.wei on 4/20/2017.
 */
@ApiModel(value = "弱网验证类")
public class WeaknetValidate {
    @NotBlank
    @ApiModelProperty(value = "name", dataType = "String", required = true, example = "name")
    private String name;

    @NotBlank
    @ApiModelProperty(value = "desc", dataType = "String", required = false, example = "desc")
    private String desc;

    @NotBlank
    @ApiModelProperty(value = "param", dataType = "String", required = true, example = "param")
    private String param;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
