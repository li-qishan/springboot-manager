package com.company.project.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.project.entity.OriginalDiskIndex;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jhon-li
 * @since 2021-08-20
 */
public interface OriginalDiskIndexMapper extends BaseMapper<OriginalDiskIndex> {

    public void insrt(OriginalDiskIndex originalDiskIndex);

    public List<OriginalDiskIndex> all();

}
