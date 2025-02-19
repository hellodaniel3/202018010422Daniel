package com.pandahis.dashboard.modules.system.service.auth;

import com.pandahis.dashboard.framework.security.core.service.SecurityAuthFrameworkService;
import com.pandahis.dashboard.modules.system.controller.auth.vo.auth.SysAuthLoginReqVO;

/**
 * 认证 Service 接口
 *
 * 提供用户的账号密码登陆、token 的校验等认证相关的功能
 *
 * @author 源码乐园
 */
public interface SysAuthService extends SecurityAuthFrameworkService {

    /**
     * 登陆用户
     *
     * @param reqVO 登陆信息
     * @param userIp 用户 IP
     * @param userAgent 用户 UA
     * @return 身份令牌，使用 JWT 方式
     */
    String login(SysAuthLoginReqVO reqVO, String userIp, String userAgent);

}
