package com.edu.dlut.springbootdemo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.dlut.springbootdemo.entity.User;
import com.edu.dlut.springbootdemo.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Stream;

/**
 * ClassName: UserService
 * Description:
 * Date: 2021/9/27 14:30
 *
 * @author Crescent
 * @version 1.0
 * @since JDK 1.8
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Page<User> queryByPage(Integer pageNum, Integer pageSize, String search) {
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        // search不为null时  才将search条件加入
        if (StringUtils.isNotBlank(search)) {
            wrapper.like(User::getId,search)
                    .or()
                    .like(User::getNickName, search)
                    .or()
                    .like(User::getUsername,search);
        }
        return userMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
    }

    @Override
    public User queryUserByUid(Integer uid) {
        return userMapper.selectById(uid);
    }

    @Override
    public int updateUserByUid(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteUserByUid(Integer id) {
        return userMapper.deleteById(id);
    }
}
