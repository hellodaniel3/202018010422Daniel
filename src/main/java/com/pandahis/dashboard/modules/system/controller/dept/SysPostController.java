package com.pandahis.dashboard.modules.system.controller.dept;

import com.pandahis.dashboard.common.enums.CommonStatusEnum;
import com.pandahis.dashboard.common.pojo.CommonResult;
import com.pandahis.dashboard.common.pojo.PageResult;
import com.pandahis.dashboard.framework.excel.core.util.ExcelUtils;
import com.pandahis.dashboard.framework.logger.operatelog.core.annotations.OperateLog;
import com.pandahis.dashboard.framework.logger.operatelog.core.enums.OperateTypeEnum;
import com.pandahis.dashboard.modules.system.controller.dept.vo.post.*;
import com.pandahis.dashboard.modules.system.convert.dept.SysPostConvert;
import com.pandahis.dashboard.modules.system.dal.dataobject.dept.SysPostDO;
import com.pandahis.dashboard.modules.system.service.dept.SysPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Api(tags = "岗位")
@RestController
@RequestMapping("/system/post")
@Valid
public class SysPostController {

    @Resource
    private SysPostService postService;

    @PostMapping("/create")
    @ApiOperation("创建岗位")
    @PreAuthorize("@ss.hasPermission('system:post:create')")
    public CommonResult<Long> createPost(@Valid @RequestBody SysPostCreateReqVO reqVO) {
        Long postId = postService.createPost(reqVO);
        return CommonResult.success(postId);
    }

    @PutMapping("/update")
    @ApiOperation("修改岗位")
    @PreAuthorize("@ss.hasPermission('system:post:update')")
    public CommonResult<Boolean> updatePost(@Valid @RequestBody SysPostUpdateReqVO reqVO) {
        postService.updatePost(reqVO);
        return CommonResult.success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除岗位")
    @PreAuthorize("@ss.hasPermission('system:post:delete')")
    public CommonResult<Boolean> deletePost(@RequestParam("id") Long id) {
        postService.deletePost(id);
        return CommonResult.success(true);
    }

    @GetMapping(value = "/get")
    @ApiOperation("获得岗位信息")
    @ApiImplicitParam(name = "id", value = "岗位编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('system:post:query')")
    public CommonResult<SysPostRespVO> getPost(@RequestParam("id") Long id) {
        return CommonResult.success(SysPostConvert.INSTANCE.convert(postService.getPost(id)));
    }

    @GetMapping("/list-all-simple")
    @ApiOperation(value = "获取岗位精简信息列表", notes = "只包含被开启的岗位，主要用于前端的下拉选项")
    public CommonResult<List<SysPostSimpleRespVO>> getSimplePosts() {
        // 获得岗位列表，只要开启状态的
        List<SysPostDO> list = postService.getPosts(null, Collections.singleton(CommonStatusEnum.ENABLE.getStatus()));
        // 排序后，返回给前端
        list.sort(Comparator.comparing(SysPostDO::getSort));
        return CommonResult.success(SysPostConvert.INSTANCE.convertList02(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得岗位分页列表")
    @PreAuthorize("@ss.hasPermission('system:post:query')")
    public CommonResult<PageResult<SysPostRespVO>> getPostPage(@Validated SysPostPageReqVO reqVO) {
        return CommonResult.success(SysPostConvert.INSTANCE.convertPage(postService.getPostPage(reqVO)));
    }

    @GetMapping("/export")
    @ApiOperation("岗位管理")
    @PreAuthorize("@ss.hasPermission('system:post:export')")
    @OperateLog(type = OperateTypeEnum.EXPORT)
    public void export(HttpServletResponse response, @Validated SysPostExportReqVO reqVO) throws IOException {
        List<SysPostDO> posts = postService.getPosts(reqVO);
        List<SysPostExcelVO> data = SysPostConvert.INSTANCE.convertList03(posts);
        // 输出
        ExcelUtils.write(response, "岗位数据.xls", "岗位列表", SysPostExcelVO.class, data);
    }

}
