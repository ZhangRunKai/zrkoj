package com.zrk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrk.entity.Role;
import com.zrk.entity.User;
import com.zrk.mapper.RoleMapper;
import com.zrk.mapper.UserMapper;
import com.zrk.service.RoleServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/14 14:25
 */
@Service
public class RoleServletImpl implements RoleServlet {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public Integer insert(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public Integer delete(Role role) {
        userMapper.selectCount(new QueryWrapper<User>().eq("role_id",role.getRoleId()));
        return roleMapper.deleteById(role.getRoleId());
    }

    @Override
    public Integer update(Role role) {
        return roleMapper.updateById(role);
    }

    @Override
    public IPage<Role> findAll(Page page,Role role) {
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        if(role!=null){
            if(role.getRoleId()!=null) roleQueryWrapper.eq("role_id",role.getRoleId());
            if(role.getRoleName()!=null) roleQueryWrapper.eq("role_name",role.getRoleName());
        }
        return roleMapper.selectPage(page,roleQueryWrapper);
    }
}
