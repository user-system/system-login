package com.ld.system.login.server.controller.outward;

import com.ld.system.login.server.dto.LoginDTO;
import com.ld.system.login.server.from.LoginFrom;
import com.ld.system.login.server.service.LoginService;
import com.ld.system.login.server.vo.LoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 登录相关接口
 *
 * @author 王海龙
 */
@RestController
@Api(value = "登录的相关Api", tags = "登录的相关Api")
@Slf4j
public class LoginController {

    @Resource
    LoginService loginService;

    @PostMapping("/login")
    @ApiOperation(value = "登录", notes = "登录")
    public LoginVO login(@RequestBody @Valid LoginFrom loginFrom) {
        LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(loginFrom, loginDTO);
        return loginService.login(loginDTO);
    }

    @PostMapping("/logout")
    @ApiOperation(value = "登出", notes = "登出")
    public void logout() {
    }

}
