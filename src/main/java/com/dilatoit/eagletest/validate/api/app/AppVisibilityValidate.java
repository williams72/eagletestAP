package com.dilatoit.eagletest.validate.api.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by xueshan.wei on 5/11/2017.
 */
@ApiModel("app 属性修改实体")
public class AppVisibilityValidate {

    //@NotNull(message = "pid不能为空")
    @ApiModelProperty(value = "项目id", dataType = "int", required = true, example = "1")
    private Integer pid;
    //@NotNull(message = "appid 不能为空")
    @ApiModelProperty(value = "app id", dataType = "int", required = true, example = "1")
    private Integer appid;
    @NotNull(message = "visibility 不能为空")
    @ApiModelProperty(value = "app 可见属性值 1 public | 0 private", dataType = "int", required = true, allowableValues = "{0, 1}",example = "1")
    private Integer visibility;

    @Override
    public String toString() {
        return "AppVisibilityValidate{" +
                "pid=" + pid +
                ", appid=" + appid +
                ", visibility=" + visibility +
                '}';
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }
}
