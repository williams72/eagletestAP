package com.dilatoit.eagletest.validate.api;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * Created by xueshan.wei on 3/9/2017.
 */
@ApiModel(value = "添加项目成员实体")
public class UserToProject {
    //项目id
    @NotNull(message = "项目id不能为空")
    @ApiModelProperty(value = "项目id", required = true, example = "1")
    private Integer pid;

    //用户id
    @NotNull(message = "成员id不能为空")
    @ApiModelProperty(value = "用户id", required = true, example = "1")
    private Integer uid;

    //成员角色
    @NotNull(message = "成员角色不能为空")
    @Digits(integer = 1, fraction = 0, message = "成员角色值必须是一个整数")
    //@Pattern(regexp = "1|2", message = "项目成员身份值必须是1|2")
    @Range(min = 1, max = 2, message = "项目成员身份值必须是1|2")
    @ApiModelProperty(value = "项目成员身份（1 管理员 | 2 成员）", required = true, example = "0", allowableValues = "{1, 2}")
    private Integer value;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
