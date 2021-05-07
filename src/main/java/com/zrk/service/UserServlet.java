package com.zrk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrk.entity.User;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/13 19:07
 */

public interface UserServlet {
    public User login(User user);

    public Integer addUser(User user);

    public Integer deleteUser(Integer userId);

    public Integer updateUser(User user);

    public IPage<User> find(Page page);

}
