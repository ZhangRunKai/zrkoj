package com.zrk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrk.entity.Admin;
import com.zrk.entity.OjClass;
import com.zrk.mapper.AdminMapper;
import com.zrk.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/8 13:22
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin login(Admin admin) {
        return adminMapper.selectOne(new QueryWrapper<Admin>()
                .eq("admin_account", admin.getAdminAccount())
                .eq("admin_password", admin.getAdminPassword())
        );
    }

    @Override
    public Integer register(Admin admin) {
        return adminMapper.insert(admin);
    }

    @Override
    public Integer addClass(OjClass ojClass) {

        return null;
    }

    @Override
    public Integer deleteClass(OjClass ojClass) {
        return null;
    }

    @Override
    public Integer updateClass(OjClass ojClass) {
        return null;
    }

    @Override
    public IPage findClass(Page page) {
        return null;
    }
}
