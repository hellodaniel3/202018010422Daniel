package com.pandahis.dashboard.modules.system.controller.auth.vo.session;

import com.pandahis.dashboard.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel("在线用户 Session 分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserSessionPageReqVO extends PageParam {

    @ApiModelProperty(value = "用户 IP", example = "127.0.0.1", notes = "模糊匹配")
    private String userIp;

    @ApiModelProperty(value = "用户账号", example = "system", notes = "模糊匹配")
    private String username;

}
