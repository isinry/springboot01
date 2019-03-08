package com.sinrycool.springboot01.service;

import com.sinrycool.springboot01.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户 service
 *
 * 实现： {@link com.sinrycool.springboot01.service.impl.UserServiceImpl}
 */
public interface UserService {

    public List<UserEntity> userList ();

    public Integer addUser (UserEntity user);

    public Integer editUser (UserEntity user);
}
