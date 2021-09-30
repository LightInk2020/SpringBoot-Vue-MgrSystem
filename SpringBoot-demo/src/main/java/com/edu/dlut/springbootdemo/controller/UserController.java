package com.edu.dlut.springbootdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.dlut.springbootdemo.common.Result;
import com.edu.dlut.springbootdemo.entity.User;
import com.edu.dlut.springbootdemo.mapper.UserMapper;
import com.edu.dlut.springbootdemo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Wrapper;

/**
 * ClassName: UserController
 * Description:
 * Date: 2021/9/27 14:04
 *
 * @author Crescent
 * @version 1.0
 * @since JDK 1.8
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    //正常来说应该在service中引入Mapper
    @Resource
    UserService userService;

    @PostMapping
    public Result<?> save(@RequestBody User user) {
        if(user.getPassword()==null){
            user.setPassword("123456");
        }
        return Result.success(userService.addUser(user));
    }

    @PutMapping
    public Result<?> update(@RequestBody User user) {
        if(user.getPassword()==null){
            user.setPassword("123456");
        }
        return Result.success(userService.updateUserByUid(user));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Integer id) {
        return Result.success(userService.deleteUserByUid(id));
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {
        Page<User> userPage =  userService.queryByPage(pageNum,pageSize,search);
        return Result.success(userPage);
    }
}
