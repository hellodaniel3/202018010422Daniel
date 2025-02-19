package com.pandahis.dashboard.modules.infra.service.config;

import com.pandahis.dashboard.common.pojo.PageResult;
import com.pandahis.dashboard.modules.infra.controller.config.vo.InfConfigCreateReqVO;
import com.pandahis.dashboard.modules.infra.controller.config.vo.InfConfigExportReqVO;
import com.pandahis.dashboard.modules.infra.controller.config.vo.InfConfigPageReqVO;
import com.pandahis.dashboard.modules.infra.controller.config.vo.InfConfigUpdateReqVO;
import com.pandahis.dashboard.modules.infra.dal.dataobject.config.InfConfigDO;

import javax.validation.Valid;
import java.util.List;

/**
 * 参数配置 Service 接口
 *
 * @author 源码乐园
 */
public interface InfConfigService {

    /**
     * 创建参数配置
     *
     * @param reqVO 创建信息
     * @return 配置编号
     */
    Long createConfig(@Valid InfConfigCreateReqVO reqVO);

    /**
     * 更新参数配置
     *
     * @param reqVO 更新信息
     */
    void updateConfig(@Valid InfConfigUpdateReqVO reqVO);

    /**
     * 删除参数配置
     *
     * @param id 配置编号
     */
    void deleteConfig(Long id);

    /**
     * 获得参数配置
     *
     * @param id 配置编号
     * @return 参数配置
     */
    InfConfigDO getConfig(Long id);

    /**
     * 根据参数键，获得参数配置
     *
     * @param key 配置键
     * @return 参数配置
     */
    InfConfigDO getConfigByKey(String key);

    /**
     * 获得参数配置分页列表
     *
     * @param reqVO 分页条件
     * @return 分页列表
     */
    PageResult<InfConfigDO> getConfigPage(@Valid InfConfigPageReqVO reqVO);

    /**
     * 获得参数配置列表
     *
     * @param reqVO 列表
     * @return 列表
     */
    List<InfConfigDO> getConfigList(@Valid InfConfigExportReqVO reqVO);


}
