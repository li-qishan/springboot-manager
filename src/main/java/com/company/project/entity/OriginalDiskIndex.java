package com.company.project.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author jhon-li
 * @since 2021-08-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("4k_original_disk_index")
public class OriginalDiskIndex extends Model<OriginalDiskIndex> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 资源名称
     */
    private String title;

    /**
     * 资源地址
     */
    private String url;

    /**
     * 资源类型
     */
    private String type;

    /**
     * 页码
     */
    private Integer page;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
