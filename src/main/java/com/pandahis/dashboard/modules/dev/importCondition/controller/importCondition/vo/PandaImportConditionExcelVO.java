package com.pandahis.dashboard.modules.dev.importCondition.controller.importCondition.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 导医信息 Excel VO
 *
 */
@Data
public class PandaImportConditionExcelVO {

    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("病情")
    private String conditionInfo;

    @ExcelProperty("挂号科室")
    private String deptName;

}
