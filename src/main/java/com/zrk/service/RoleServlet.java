package com.zrk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrk.entity.Role;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/14 14:23
 */
public interface RoleServlet {

    public Integer insert(Role role);

    public Integer delete(Role role);

    public Integer update(Role role);

    public IPage<Role> findAll(Page page,Role role);
}
