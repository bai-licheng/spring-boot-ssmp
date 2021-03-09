package com.javakc.project.commons.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Program: spring-boot-project
 * @description: 公共基础属性
 * @author: zhou hong gang
 * @create: 2020-12-09 11:01
 */
@Getter
@Setter
public class Base {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty(value = "主键(修改是必填)")
    private Integer id;
    @ApiModelProperty(value = "乐观锁(在并发操作时使用)", hidden = true)
    private String revision;
    @ApiModelProperty(value = "创建人", hidden = true)
    private String createdBy;
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date createdTime;
    @ApiModelProperty(value = "更新人", hidden = true)
    private String updatedBy;
    @ApiModelProperty(value = "更新时间", hidden = true)
    private Date updatedTime;
    /**
     * offset, size 属性
     * 不参与数据库相关操作
     * 只负责分页查询相关功能
     */
    @TableField(exist = false)
    private int offset = 1;
    @TableField(exist = false)
    private int size = 10;
}