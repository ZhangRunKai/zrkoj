package com.zrk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrk.entity.User;
import com.zrk.mapper.UserMapper;
import com.zrk.service.UserServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/13 19:10
 */
@Service
public class UserServletImpl implements UserServlet {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        User login = userMapper.login(new QueryWrapper<User>()
                .eq("user_account", user.getUserAccount())
                .eq("user_password", user.getUserPassword()));
        return login;
    }

    @Override
    public Integer addUser(User user) {
        user.setUserCreateTime(new Date());
        return userMapper.insert(user);
    }

    @Override
    public Integer deleteUser(Integer userId) {
        return  userMapper.delete(new QueryWrapper<User>().eq("user_id", userId));
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public IPage<User> find(Page page) {
        return userMapper.selectPage(page,new QueryWrapper<User>());
    }
}
