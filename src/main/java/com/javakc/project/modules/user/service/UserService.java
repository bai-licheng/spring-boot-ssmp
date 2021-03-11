package com.javakc.project.modules.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javakc.project.commons.base.service.BaseService;
import com.javakc.project.modules.user.dao.UserDao;
import com.javakc.project.modules.user.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @program: spring-boot-project
 * @description: RBAC用户逻辑层
 * @author: zhou hong gang
 * @create: 2020-12-15 13:48
 */
@Service
public class UserService extends BaseService<UserDao, User> {

    public IPage<User> list(User entity)
    {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if(StringUtils.hasText(entity.getName()))
        {
            wrapper.like("name", entity.getName());
        }
        IPage<User> page = new Page<>(entity.getOffset(), entity.getSize());
        return baseMapper.selectPage(page, wrapper);
    }

    @Transactional(readOnly = false)
    public void deleteByCondition(Map<String, Object> params)
    {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if(!ObjectUtils.isEmpty(params) && !ObjectUtils.isEmpty(params.get("start")) && !ObjectUtils.isEmpty(params.get("end")))
        {
            wrapper.between("created_time", params.get("start"), params.get("end"));
            baseMapper.delete(wrapper);
        }
    }

}
