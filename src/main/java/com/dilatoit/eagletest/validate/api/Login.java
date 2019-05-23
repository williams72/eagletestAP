package com.dilatoit.eagletest.validate.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 用于接收登录数据的模型
 * Created by xueshan.wei on 2/15/2017.
 */
@ApiModel(value = "用户登录实体")
public class Login {
    @ApiModelProperty(value = "账户名", dataType = "int", required = true, example = "test@test.com")
    @NotNull(message = "账户ID不能为空")
    @NotBlank(message = "账户ID不能为空")
    @Email(message = "账户格式必须为邮箱")
    private String account; //账户ID（包括但不仅限于用户名、邮箱）

    @ApiModelProperty(value = "账户密码", dataType = "string", required = true)
    @NotBlank(message = "密码不能为空")
    private String password; // 账户密码

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
