package com.javakc.project.modules.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.javakc.project.commons.base.entity.Base;
import com.javakc.project.commons.utils.validator.Password;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

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
    @Length(min = 2, max = 32, message = "用户姓名长度要求在{min}到{max}位之间")
    private String name;

    @ApiModelProperty(name = "account", value = "账号")
    @Length(min = 3, max = 16, message = "登陆账号长度要求在{min}到{max}位之间")
    private String account;

    @ApiModelProperty(name = "password", value = "密码")
    @Length(min = 6, max = 32, message = "登陆密码长度要求在{min}到{max}位之间")
    @Password(message = "你的密码弱爆了, 请重新输入复杂一些的密码吧!")
    private String password;

    @ApiModelProperty(name = "identity", value = "身份证")
    @Pattern(
        regexp = "^[1-9][0-9]{5}(18|19|20)[0-9]{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)[0-9]{3}([0-9]|(X|x))",
        message = "请输入正确身份证号码"
    )
    private String identity;

    @ApiModelProperty(name = "phone", value = "手机")
    @Pattern(
        regexp = "^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$",
        message = "请输入正确的手机号码"
    )
    private String phone;

    @ApiModelProperty(name = "email", value = "邮箱")
    @Email(message = "请输入正确的电子邮箱地址")
    private String email;

    @ApiModelProperty(name = "locked", value = "是否锁定0:未锁定1:已锁定")
    private Integer locked = 0;
}
