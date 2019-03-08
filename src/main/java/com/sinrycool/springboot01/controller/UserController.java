package com.sinrycool.springboot01.controller;

import com.sinrycool.springboot01.entity.UserEntity;
import com.sinrycool.springboot01.service.UserService;
import com.sinrycool.springboot01.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 用户 Controller
 *
 * @author ：Sinry
 * @date ：Created in 2019-03-01 17:30
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Object list ()
    {
        if (userService.userList().isEmpty()) {
            return ResultUtil.successNoData();
        }

        return ResultUtil.success(userService.userList());
    }

    @PostMapping("/users")
    public Object addPost (UserEntity user)
    {
        return ResultUtil.success(userService.addUser(user));
    }

    @PostMapping("/users/{id}")
    public Object editPost (@PathVariable Integer id, UserEntity user)
    {
        System.out.println(id);
        System.out.println(user.toString());

        return ResultUtil.success(userService.editUser(user));
    }
}
