package com.dilatoit.eagletest.validate.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 用于接收新增用户信息时的实体
 * Created by xueshan.wei on 3/7/2017.
 */
@ApiModel(value = "接收新用户信息的实体")
public class AddUser {
    //用户账户/用户名
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名",required = true,example = "admin")
    private String account;

    //user`s email
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    @ApiModelProperty(value = "邮箱（标准格式）",required = true,example = "admin@admin.com")
    private String email;

    //user`s password
    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 26, message = "密码长度必须介于6~26之间")
    @ApiModelProperty(value = "密码|长度必须介于6~26之间",required = true,example = "123456")
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
