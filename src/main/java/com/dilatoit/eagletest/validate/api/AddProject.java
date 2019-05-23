package com.dilatoit.eagletest.validate.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * add project model
 * Created by xueshan.wei on 3/8/2017.
 */
@ApiModel(value = "项目实体")
public class AddProject {
    @NotBlank(message = "项目名称不能为空")
    @ApiModelProperty(value = "项目名称",required = true,example = "test")
    private String name;
    @NotBlank(message = "项目key不能为空")
    @Length(min = 0, max = 6, message = "项目key长度必须介于0~6之间")
    @ApiModelProperty(value = "项目Key|长度必须介于0~6之间",required = true,example="0")
    private String key;
    @NotNull(message = "管理员id不能为空")
    @ApiModelProperty(value = "管理员id",required = true,example = "0")
    private Integer adminId;
    @NotNull(message = "项目类型不能为空")
    @ApiModelProperty(value = "项目类型|0 Android | 1 IOS",required = true,example = "0")
    private Integer type;
    @ApiModelProperty(value = "desc 项目描述|可选",required = false,example = "项目的描述")
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

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
