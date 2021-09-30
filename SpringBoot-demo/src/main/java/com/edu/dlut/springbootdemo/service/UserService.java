package com.edu.dlut.springbootdemo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.dlut.springbootdemo.entity.User;

import java.util.List;

/**
 * ClassName: UserService
 * Description:
 * Date: 2021/9/27 21:30
 *
 * @author Crescent
 * @version 1.0
 * @since JDK 1.8
 */
public interface UserService {
    /**
     * 分页查询用户
     * @return
     */
    Page<User> queryByPage(Integer pageNum, Integer pageSize,String search);

    /*根据用户id查询用户*/
    User queryUserByUid(Integer uid);

    /*根据用户id修改用户信息*/
    int updateUserByUid(User user);

    /*添加用户*/
    int addUser(User user);

    /*根据用户id删除用户*/
    int deleteUserByUid(Integer uid);
}
