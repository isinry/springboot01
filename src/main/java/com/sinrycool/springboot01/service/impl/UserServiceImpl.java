package com.sinrycool.springboot01.service.impl;

import com.sinrycool.springboot01.entity.UserEntity;
import com.sinrycool.springboot01.mapper.UserMapper;
import com.sinrycool.springboot01.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户 Service
 *
 * @author ：Sinry
 * @date ：Created in 2019-03-01 17:38
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserEntity> userList() {
        List<UserEntity> users = userMapper.SelectUsers();
        return users;
    }

    @Override
    public Integer addUser(UserEntity user) {
        Date date = new Date();
        user.setCreateTime(date);
        user.setUpdateTime(date);
        return userMapper.AddUser(user);
    }

    @Override
    public Integer editUser(UserEntity user) {
        Date date = new Date();
        user.setUpdateTime(date);
        return userMapper.EditUser(user);
    }
}
