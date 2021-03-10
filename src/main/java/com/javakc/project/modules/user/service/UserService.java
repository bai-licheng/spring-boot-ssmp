package com.javakc.project.modules.user.service;

import com.javakc.project.commons.base.service.BaseService;
import com.javakc.project.modules.user.dao.UserDao;
import com.javakc.project.modules.user.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: spring-boot-project
 * @description: RBAC用户逻辑层
 * @author: zhou hong gang
 * @create: 2020-12-15 13:48
 */
@Service(value = "userDetailsService")
public class UserService extends BaseService<UserDao, User> {


}
