package com.javakc.project.modules.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.javakc.project.commons.base.entity.Base;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: spring-boot-project
 * @description: RBAC用户
 * @author: zhou hong gang
 * @create: 2020-12-15 13:43
 */
@Getter
@Setter
@TableName(value = "user_info")
@ApiModel(value = "用户模块")
public class User extends Base {
    @ApiModelProperty(name = "name", value = "姓名")
    private String name;
    @ApiModelProperty(name = "account", value = "账号")
    private String account;
    @ApiModelProperty(name = "password", value = "密码")
    private String password;
    @ApiModelProperty(name = "identity", value = "身份证")
    private String identity;
    @ApiModelProperty(name = "phone", value = "手机")
    private String phone;
    @ApiModelProperty(name = "email", value = "邮箱")
    private String email;
    @ApiModelProperty(name = "lock", value = "是否锁定0:未锁定1:已锁定")
    private Integer lock;
}
