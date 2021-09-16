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

import com.company.project.entity._4kOriginalDiskIndexEntity;
import com.company.project.service._4kOriginalDiskIndexService;



/**
 *
 *
 * @author wenbin
 * @email *****@mail.com
 * @date 2021-08-21 15:03:18
 */
@Controller
@RequestMapping("/")
public class _4kOriginalDiskIndexController {
    @Autowired
    private _4kOriginalDiskIndexService _4kOriginalDiskIndexService;


    /**
    * 跳转到页面
    */
    @GetMapping("/index/_4kOriginalDiskIndex")
    public String _4kOriginalDiskIndex() {
        return "_4kOriginalDiskIndex/list";
        }

    @ApiOperation(value = "新增")
    @PostMapping("_4kOriginalDiskIndex/add")
    @RequiresPermissions("_4kOriginalDiskIndex:add")
    @ResponseBody
    public DataResult add(@RequestBody _4kOriginalDiskIndexEntity _4kOriginalDiskIndex){
        _4kOriginalDiskIndexService.save(_4kOriginalDiskIndex);
        return DataResult.success();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("_4kOriginalDiskIndex/delete")
    @RequiresPermissions("_4kOriginalDiskIndex:delete")
    @ResponseBody
    public DataResult delete(@RequestBody @ApiParam(value = "id集合") List<String> ids){
        _4kOriginalDiskIndexService.removeByIds(ids);
        return DataResult.success();
    }

    @ApiOperation(value = "更新")
    @PutMapping("_4kOriginalDiskIndex/update")
    @RequiresPermissions("_4kOriginalDiskIndex:update")
    @ResponseBody
    public DataResult update(@RequestBody _4kOriginalDiskIndexEntity _4kOriginalDiskIndex){
        _4kOriginalDiskIndexService.updateById(_4kOriginalDiskIndex);
        return DataResult.success();
    }

    @ApiOperation(value = "查询分页数据")
    @PostMapping("_4kOriginalDiskIndex/listByPage")
    @RequiresPermissions("_4kOriginalDiskIndex:list")
    @ResponseBody
    public DataResult findListByPage(@RequestBody _4kOriginalDiskIndexEntity _4kOriginalDiskIndex){
        Page page = new Page(_4kOriginalDiskIndex.getPage(), _4kOriginalDiskIndex.getLimit());
        LambdaQueryWrapper<_4kOriginalDiskIndexEntity> queryWrapper = Wrappers.lambdaQuery();
        //查询条件示例
        //queryWrapper.eq(_4kOriginalDiskIndexEntity::getId, _4kOriginalDiskIndex.getId());
        IPage<_4kOriginalDiskIndexEntity> iPage = _4kOriginalDiskIndexService.page(page, queryWrapper);
        return DataResult.success(iPage);
    }

}
