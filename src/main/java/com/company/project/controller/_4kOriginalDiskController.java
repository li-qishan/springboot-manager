package com.company.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import com.company.project.common.utils.DataResult;

import com.company.project.entity._4kOriginalDiskEntity;
import com.company.project.service._4kOriginalDiskService;



/**
 *
 *
 * @author wenbin
 * @email *****@mail.com
 * @date 2021-08-21 15:03:18
 */
@Controller
@RequestMapping("/")
public class _4kOriginalDiskController {
    @Autowired
    private _4kOriginalDiskService _4kOriginalDiskService;


    /**
    * 跳转到页面
    */
    @GetMapping("/index/_4kOriginalDisk")
    public String _4kOriginalDisk() {
        return "_4kOriginalDisk/list";
        }

    @ApiOperation(value = "新增")
    @PostMapping("_4kOriginalDisk/add")
    @RequiresPermissions("_4kOriginalDisk:add")
    @ResponseBody
    public DataResult add(@RequestBody _4kOriginalDiskEntity _4kOriginalDisk){
        _4kOriginalDiskService.save(_4kOriginalDisk);
        return DataResult.success();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("_4kOriginalDisk/delete")
    @RequiresPermissions("_4kOriginalDisk:delete")
    @ResponseBody
    public DataResult delete(@RequestBody @ApiParam(value = "id集合") List<String> ids){
        _4kOriginalDiskService.removeByIds(ids);
        return DataResult.success();
    }

    @ApiOperation(value = "更新")
    @PutMapping("_4kOriginalDisk/update")
    @RequiresPermissions("_4kOriginalDisk:update")
    @ResponseBody
    public DataResult update(@RequestBody _4kOriginalDiskEntity _4kOriginalDisk){
        _4kOriginalDiskService.updateById(_4kOriginalDisk);
        return DataResult.success();
    }

    @ApiOperation(value = "查询分页数据")
    @PostMapping("_4kOriginalDisk/listByPage")
    @RequiresPermissions("_4kOriginalDisk:list")
    @ResponseBody
    public DataResult findListByPage(@RequestBody _4kOriginalDiskEntity _4kOriginalDisk){
        Page page = new Page(_4kOriginalDisk.getPage(), _4kOriginalDisk.getLimit());
        LambdaQueryWrapper<_4kOriginalDiskEntity> queryWrapper = Wrappers.lambdaQuery();
        //查询条件示例
        //queryWrapper.eq(_4kOriginalDiskEntity::getId, _4kOriginalDisk.getId());
        IPage<_4kOriginalDiskEntity> iPage = _4kOriginalDiskService.page(page, queryWrapper);
        return DataResult.success(iPage);
    }

}
