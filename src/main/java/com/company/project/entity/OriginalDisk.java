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
@TableName("4k_original_disk")
public class OriginalDisk extends Model<OriginalDisk> {

    private static final long serialVersionUID = 1L;

    /**
     * uid
     */
    private Integer id;

    /**
     * 资源名称
     */
    private String title;
    /**
     *
     */
    private String type;

    /**
     * 内容
     */
    private String contents;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
