package com.pandahis.dashboard.framework.logger.operatelog.core.annotations;

import com.pandahis.dashboard.framework.logger.operatelog.core.enums.OperateTypeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 操作日志注解
 *
 * @author 源码乐园
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OperateLog {

    // ========== 模块字段 ==========

    /**
     * 操作模块
     *
     * 为空时，会尝试读取 {@link Api#value()} 属性
     */
    String module() default "";
    /**
     * 操作名
     *
     * 为空时，会尝试读取 {@link ApiOperation#value()} 属性
     */
    String name() default "";
    /**
     * 操作分类
     *
     * 实际并不是数组，因为枚举不能设置 null 作为默认值
     */
    OperateTypeEnum[] type() default {};

    // ========== 开关字段 ==========

    /**
     * 是否记录操作日志
     */
    boolean enable() default true;
    /**
     * 是否记录方法参数
     */
    boolean logArgs() default true;
    /**
     * 是否记录方法结果的数据
     */
    boolean logResultData() default true;

}
