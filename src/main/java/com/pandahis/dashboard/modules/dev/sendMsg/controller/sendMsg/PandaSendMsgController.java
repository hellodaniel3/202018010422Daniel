package com.pandahis.dashboard.modules.dev.sendMsg.controller.sendMsg;

import com.pandahis.dashboard.modules.dev.sendMsg.controller.sendMsg.vo.*;
import com.pandahis.dashboard.modules.dev.sendMsg.convert.sendMsg.PandaSendMsgConvert;
import com.pandahis.dashboard.modules.dev.sendMsg.dal.dataobject.sendMsg.PandaSendMsgDO;
import com.pandahis.dashboard.modules.dev.sendMsg.service.sendMsg.PandaSendMsgService;
import com.pandahis.dashboard.common.pojo.CommonResult;
import com.pandahis.dashboard.common.pojo.PageResult;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.*;

import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import com.pandahis.dashboard.framework.excel.core.util.ExcelUtils;

import com.pandahis.dashboard.framework.logger.operatelog.core.annotations.OperateLog;
import static com.pandahis.dashboard.framework.logger.operatelog.core.enums.OperateTypeEnum.*;


@Api(tags = "发送消息表")
@RestController
@RequestMapping("/panda/send-msg")
@Validated
public class PandaSendMsgController {

    @Resource
    private PandaSendMsgService sendMsgService;

    @PostMapping("/create")
    @ApiOperation("创建发送消息表")

    public CommonResult<Long> createSendMsg(@Valid @RequestBody PandaSendMsgDO pandaSendMsgDO) {
        return CommonResult.success(sendMsgService.createSendMsg(pandaSendMsgDO));
    }

    @PutMapping("/update")
    @ApiOperation("更新发送消息表")

    public CommonResult<Boolean> updateSendMsg(@Valid @RequestBody PandaSendMsgUpdateReqVO updateReqVO) {
        sendMsgService.updateSendMsg(updateReqVO);
        return CommonResult.success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除发送消息表")
    @ApiImplicitParam(name = "id", value = "编号", required = true)

    public CommonResult<Boolean> deleteSendMsg(@RequestParam("id") Long id) {
        sendMsgService.deleteSendMsg(id);
        return CommonResult.success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得发送消息表")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)

    public CommonResult<PandaSendMsgRespVO> getSendMsg(@RequestParam("id") Long id) {
        PandaSendMsgDO sendMsg = sendMsgService.getSendMsg(id);
        return CommonResult.success(PandaSendMsgConvert.INSTANCE.convert(sendMsg));
    }

    @GetMapping("/list")
    @ApiOperation("获得发送消息表列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)

    public CommonResult<List<PandaSendMsgRespVO>> getSendMsgList(@RequestParam("ids") Collection<Long> ids) {
        List<PandaSendMsgDO> list = sendMsgService.getSendMsgList(ids);
        return CommonResult.success(PandaSendMsgConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得发送消息表分页")

    public CommonResult<PageResult<PandaSendMsgRespVO>> getSendMsgPage(@Valid PandaSendMsgPageReqVO pageVO) {
        PageResult<PandaSendMsgDO> pageResult = sendMsgService.getSendMsgPage(pageVO);
        return CommonResult.success(PandaSendMsgConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出发送消息表 Excel")

    @OperateLog(type = EXPORT)
    public void exportSendMsgExcel(@Valid PandaSendMsgExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PandaSendMsgDO> list = sendMsgService.getSendMsgList(exportReqVO);
        // 导出 Excel
        List<PandaSendMsgExcelVO> datas = PandaSendMsgConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "发送消息表.xls", "数据", PandaSendMsgExcelVO.class, datas);
    }

}
