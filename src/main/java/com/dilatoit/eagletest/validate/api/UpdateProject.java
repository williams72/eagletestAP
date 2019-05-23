package com.dilatoit.eagletest.validate.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by xueshan.wei on 3/15/2017.
 */
@ApiModel(value = "更新项目的实体")
public class UpdateProject {
    @NotBlank(message = "项目名称不能为空")
    @ApiModelProperty(value = "项目名称", required = true, example = "新的名称")
    private String name;
    @NotBlank(message = "项目key不能为空")
    @Length(min = 0, max = 6, message = "项目key长度必须介于0~6之间")
    @ApiModelProperty(value = "项目key|长度必须介于0~6之间", required = true, example = "0")
    private String key;

    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
