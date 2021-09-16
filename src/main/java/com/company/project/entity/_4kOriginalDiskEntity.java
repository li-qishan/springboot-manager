package com.company.project.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.company.project.entity.BaseEntity;


import java.io.Serializable;

import lombok.Data;

/**
 *
 *
 * @author wenbin
 * @email *****@mail.com
 * @date 2021-08-21 15:03:18
 */
@Data
@TableName("4k_original_disk")
public class _4kOriginalDiskEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * uid
	 */
	@TableId("id")
	private Integer id;

	/**
	 * 资源名称
	 */
	@TableField("title")
	private String title;

	/**
	 * 分类
	 */
	@TableField("type")
	private String type;

	/**
	 * 内容
	 */
	@TableField("contents")
	private String contents;


}
