package com.sinrycool.springboot01.mapper;

import com.sinrycool.springboot01.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户 Mapper
 *
 * @author ：Sinry
 * @date ：Created in 2019-03-01 17:41
 */
@Repository
public interface UserMapper {

    List<UserEntity> SelectUsers();

    Integer AddUser(UserEntity user);

    Integer EditUser(UserEntity user);
}
