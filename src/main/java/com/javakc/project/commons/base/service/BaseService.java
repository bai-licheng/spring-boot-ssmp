package com.javakc.project.commons.base.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javakc.project.commons.base.entity.Base;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @program: spring-boot-project
 * @description: 公共逻辑层实现
 * @author: zhou hong gang
 * @create: 2020-12-09 11:06
 */
@Transactional(
    readOnly = true,
    isolation = Isolation.REPEATABLE_READ
)
public class BaseService<D extends BaseMapper<T>, T extends Base> extends ServiceImpl<D, T> {

    /**
     * 分页查询记录
     * @param entity 相关条件
     * @return 分页对象
     */
    public IPage<T> queryByPage(T entity)
    {
        IPage<T> userPage = new Page<>(entity.getOffset(), entity.getSize());
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        return baseMapper.selectPage(userPage, queryWrapper);
    }

    /**
     * 不建议使用
     * 查询全部记录
     * @return 全部记录
     */
    @Deprecated
    public List<T> queryAll()
    {
        return baseMapper.selectList(new QueryWrapper<>());
    }

}
