package com.javakc.project.modules.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javakc.project.modules.user.entity.User;
import com.javakc.project.modules.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Program: spring-boot-project
 * @Created: 2021/3/9 14:30
 * @Author: ZhouHongGang
 * @Description: TODO
 */
@RestController
@RequestMapping("user")
@Api(tags = "[用户接口]")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ApiOperation(value = "【用户注册】", notes = "调用当前接口向服务器中添加一位新的用户!")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name", value = "用户名称", required = true, dataType = "string", dataTypeClass = String.class),
        @ApiImplicitParam(name = "account", value = "登陆账号", required = true, dataType = "string", dataTypeClass = String.class),
        @ApiImplicitParam(name = "password", value = "登陆密码", required = true, dataType = "string", dataTypeClass = String.class),
        @ApiImplicitParam(name = "identity", value = "身份证编号", required = true, dataType = "string", dataTypeClass = String.class),
        @ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "string", dataTypeClass = String.class),
        @ApiImplicitParam(name = "email", value = "电子邮箱", required = true, dataType = "string", dataTypeClass = String.class)
    })
    public void save(@RequestBody @Valid User entity)
    {
        userService.save(entity);
    }

    @GetMapping
    @ApiOperation(value = "【用户条件分页查询】", notes = "根据动态的查询参数完成用户信息查询!")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name", value = "用户名称", dataType = "string", dataTypeClass = String.class),
        @ApiImplicitParam(name = "offset", value = "当前页", dataType = "int", dataTypeClass = Integer.class),
        @ApiImplicitParam(name = "size", value = "每页条数", dataType = "int", dataTypeClass = Integer.class)
    })
    public IPage<User> query(@RequestBody User entity)
    {
        return userService.list(entity);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "【根据主键ID查询用户】", notes = "调用当前接口查询服务器中ID-用户信息!")
    public User query(@PathVariable int id)
    {
        return userService.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "【用户修改】", notes = "调用当前接口编辑服务器中用户信息!")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int", dataTypeClass = Integer.class),
        @ApiImplicitParam(name = "name", value = "用户名称", required = true, dataType = "string", dataTypeClass = String.class),
        @ApiImplicitParam(name = "account", value = "登陆账号", required = true, dataType = "string", dataTypeClass = String.class),
        @ApiImplicitParam(name = "password", value = "登陆密码", required = true, dataType = "string", dataTypeClass = String.class),
        @ApiImplicitParam(name = "identity", value = "身份证编号", required = true, dataType = "string", dataTypeClass = String.class),
        @ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "string", dataTypeClass = String.class),
        @ApiImplicitParam(name = "email", value = "电子邮箱", required = true, dataType = "string", dataTypeClass = String.class)
    })
    public void update(@RequestBody User entity)
    {
        userService.updateById(entity);
    }

    @DeleteMapping
    @ApiOperation(value = "【删除一组用户】", notes = "传入一组用户主键!")
    public void deleteAll(@RequestBody List<Integer> ids)
    {
        userService.removeByIds(ids);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "【根据主键ID删除用户】", notes = "出入需要删除的用户主键ID!")
    public void delete(@PathVariable int id)
    {
        userService.removeById(id);
    }

    @DeleteMapping("condition")
    @ApiOperation(value = "【根据条件删除用户】", notes = "传入开始时间及结束时间!")
    public void deleteByCondition(@RequestBody Map<String, Object> params)
    {
        userService.deleteByCondition(params);
    }

}
