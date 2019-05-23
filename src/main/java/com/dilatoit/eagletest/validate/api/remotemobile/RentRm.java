package com.dilatoit.eagletest.validate.api.remotemobile;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 租借远程真机 数据接收验证
 * Created by beishan on 2017/3/30.
 */
@ApiModel(value = "租借远程真机参数实体")
public class RentRm {
    @NotBlank(message = "远程真机设备序列号不能为空")
    @ApiModelProperty(value = "远程真机设备序列号",required = true,example = "sn")
    private String sn;
    @NotNull(message = "使用时间不能为空")
    @ApiModelProperty(value = "使用时间",required = true,example = "20")
    private Integer time;
    @NotBlank(message = "设备名称不能为空")
    @ApiModelProperty(value = "设备名称",required = true,example = "mobileName")
    private String mobileName;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }
}
