package com.ld.system.login.server.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 登录VO
 *
 * @author 王海龙
 */
@Data
@ApiModel(value = "登录VO")
public class LoginVO {

    @ApiModelProperty(value = "用户名", name = "userName", example = "张三", required = true)
    private String userName;

    @ApiModelProperty(value = "账号", name = "account", example = "124541245", required = true)
    private String account;

}
