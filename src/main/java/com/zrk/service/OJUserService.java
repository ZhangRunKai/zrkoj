package com.zrk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrk.entity.OjClass;
import com.zrk.entity.OjUser;

import java.util.List;

public interface OJUserService {

    public Integer register(OjUser ojUser);

    public OjUser login(OjUser ojUser);

    public Integer changeOjUser(OjUser ojUser);

    public IPage findAll(Page page);

    public Integer addClass(OjClass ojClass);

    public Integer deleteClass(OjClass ojClass);

    public IPage findClass(Page page);


}
