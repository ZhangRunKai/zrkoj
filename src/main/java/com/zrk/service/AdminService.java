package com.zrk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrk.entity.Admin;
import com.zrk.entity.OjClass;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/7 12:32
 */
public interface AdminService {

    public Admin login(Admin admin);

    public Integer register(Admin admin);

    public Integer addClass(OjClass ojClass);

    public Integer deleteClass(OjClass ojClass);

    public Integer updateClass(OjClass ojClass);

    public IPage findClass(Page page);

}
