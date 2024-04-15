package com.pandahis.dashboard.framework.logger.operatelog.core.util;

import com.pandahis.dashboard.framework.logger.operatelog.core.aop.OperateLogAspect;

/**
 * 操作日志工具类
 * 目前主要的作用，是提供给业务代码，记录操作明细和拓展字段
 *
 * @author 源码乐园
 */
public class OperateLogUtils {

    public static void setContent(String content) {
        OperateLogAspect.setContent(content);
    }

    public static void addExt(String key, Object value) {
        OperateLogAspect.addExt(key, value);
    }

}
