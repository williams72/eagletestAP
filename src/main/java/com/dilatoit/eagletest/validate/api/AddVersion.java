package com.dilatoit.eagletest.validate.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * Created by xueshan.wei on 3/9/2017.
 */
@ApiModel(value = "项目版本实体")
public class AddVersion {
    @NotBlank(message = "版本名称不能为空")
    @ApiModelProperty(value = "版本名称",required = true,example = "V1.0")
    private String name;
    @NotNull(message = "版本状态不能为空")
    @Range(min = 1, max = 3, message = "版本状态必须是1/2/3其中一个值")
    @ApiModelProperty(value = "版本状态|取值1~3|开发中1,测试中2,已发布3",required = true,example = "1")
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
