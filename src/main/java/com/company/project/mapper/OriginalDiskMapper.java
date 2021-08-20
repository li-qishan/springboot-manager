package com.company.project.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.project.entity.OriginalDisk;
import com.company.project.entity.OriginalDiskIndex;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jhon-li
 * @since 2021-08-20
 */

public interface OriginalDiskMapper extends BaseMapper<OriginalDisk> {

    public void insrt(OriginalDisk originalDisk);

}
