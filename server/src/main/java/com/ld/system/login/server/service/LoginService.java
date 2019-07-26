package com.ld.system.login.server.service;

import com.ld.system.login.server.dto.LoginDTO;
import com.ld.system.login.server.vo.LoginVO;

/**
 * 登录的业务接口
 *
 * @author 王海龙
 */
public interface LoginService {

    /**
     * 登录功能
     *
     * @param loginDTO 登录的DTO
     * @return 登录的VO
     */
    LoginVO login(LoginDTO loginDTO);

}
