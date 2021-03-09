package com.javakc.project.commons.mybatis;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;

/**
 * @program: spring-boot-project
 * @description: mybatis plus公共配置
 * @author: zhou hong gang
 * @create: 2020-12-09 11:04
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.javakc.project.modules.*.dao")
public class MybatisPlusConfig {

    private static final Logger LOG = LoggerFactory.getLogger(MybatisPlusConfig.class);

    /**
     * 启用mybatis plus分页支持
     * @return mybatis分页拦截器
     */
    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    /**
     * 自动插入添加与修改时间
     */
    @Component
    static class AutoTimeMetaObjectHandler implements MetaObjectHandler {
        @Override
        public void insertFill(MetaObject metaObject) {
            this.setFieldValByName("createdTime", new Date(), metaObject);
        }
        @Override
        public void updateFill(MetaObject metaObject) {
            this.setFieldValByName("updatedTime", new Date(), metaObject);
        }
    }

}
