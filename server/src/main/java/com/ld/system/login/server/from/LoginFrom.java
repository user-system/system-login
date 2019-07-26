package com.ld.system.login.server.from;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * 登录表单
 *
 * @author 王海龙
 */
@Data
@ApiModel(value = "登录表单")
public class LoginFrom {

    @ApiModelProperty(value = "账号", name = "account", example = "2015426574", required = true)
    @NotEmpty(message = "参数验证失败：账号不能为空")
    @Length(min = 6, max = 20, message = "参数验证失败：账号长度在6到20之间")
    private String account;

    @ApiModelProperty(value = "密码", name = "password", example = "0000000000", required = true)
    @NotEmpty(message = "参数验证失败：密码不能为空")
    @Length(min = 6, max = 10, message = "参数验证失败：密码长度在6到10之间")
    @Pattern(regexp = "^[a-zA-Z]\\w{5,11}$",message = "参数验证失败：密码必须由字母和数字和_组成")
    private String password;

}
