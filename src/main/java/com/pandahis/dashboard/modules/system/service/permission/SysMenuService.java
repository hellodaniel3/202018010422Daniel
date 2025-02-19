package com.pandahis.dashboard.modules.system.service.permission;

import com.pandahis.dashboard.modules.system.controller.permission.vo.menu.SysMenuCreateReqVO;
import com.pandahis.dashboard.modules.system.controller.permission.vo.menu.SysMenuListReqVO;
import com.pandahis.dashboard.modules.system.controller.permission.vo.menu.SysMenuUpdateReqVO;
import com.pandahis.dashboard.modules.system.dal.dataobject.permission.SysMenuDO;

import java.util.Collection;
import java.util.List;

/**
 * 菜单 Service 接口
 *
 * @author 源码乐园
 */
public interface SysMenuService {

    /**
     * 初始化菜单的本地缓存
     */
    void initLocalCache();

    /**
     * 创建菜单
     *
     * @param reqVO 菜单信息
     * @return 创建出来的菜单编号
     */
    Long createMenu(SysMenuCreateReqVO reqVO);

    /**
     * 更新菜单
     *
     * @param reqVO 菜单信息
     */
    void updateMenu(SysMenuUpdateReqVO reqVO);

    /**
     * 删除菜单
     *
     * @param id 菜单编号
     */
    void deleteMenu(Long id);

    /**
     * 获得所有菜单列表
     *
     * @return 菜单列表
     */
    List<SysMenuDO> getMenus();

    /**
     * 筛选菜单列表
     *
     * @param reqVO 筛选条件请求 VO
     * @return 菜单列表
     */
    List<SysMenuDO> getMenus(SysMenuListReqVO reqVO);

    /**
     * 获得所有菜单，从缓存中
     *
     * 任一参数为空时，则返回为空
     *
     * @param menuTypes 菜单类型数组
     * @param menusStatuses 菜单状态数组
     * @return 菜单列表
     */
    List<SysMenuDO> listMenusFromCache(Collection<Integer> menuTypes, Collection<Integer> menusStatuses);

    /**
     * 获得指定编号的菜单数组，从缓存中
     *
     * 任一参数为空时，则返回为空
     *
     * @param menuIds 菜单编号数组
     * @param menuTypes 菜单类型数组
     * @param menusStatuses 菜单状态数组
     * @return 菜单数组
     */
    List<SysMenuDO> listMenusFromCache(Collection<Long> menuIds, Collection<Integer> menuTypes,
                                       Collection<Integer> menusStatuses);

    /**
     * 获得权限对应的菜单数组
     *
     * @param permission 权限标识
     * @return 数组
     */
    List<SysMenuDO> getMenuListByPermissionFromCache(String permission);

    /**
     * 获得菜单
     *
     * @param id 菜单编号
     * @return 菜单
     */
    SysMenuDO getMenu(Long id);

}
