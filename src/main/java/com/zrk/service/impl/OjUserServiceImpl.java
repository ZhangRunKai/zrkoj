package com.zrk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrk.entity.OjClass;
import com.zrk.entity.OjUser;
import com.zrk.mapper.OjClassMapper;
import com.zrk.mapper.OjUserMapper;
import com.zrk.service.OJUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OjUserServiceImpl implements OJUserService {

    @Autowired
    private static Logger logger = Logger.getLogger(OjUserServiceImpl.class);
    @Autowired
    private OjUserMapper ojUserMapper;
    @Autowired
    private OjClassMapper ojClassMapper;

    /**
     * 注册普通用户
     * @param ojUser
     * @return
     */
    @Override
    public Integer register(OjUser ojUser){
        int insert = ojUserMapper.insert(ojUser);
        logger.info("UserService:参数："+ojUser+",结果："+insert);
        return insert;
    }

    /**
     * 用户登陆
     * @param ojUser
     * @return
     */
    @Override
    public OjUser login(OjUser ojUser) {
        logger.info("UserService:"+ojUser);
        QueryWrapper<OjUser> ojUserQueryWrapper = new QueryWrapper<OjUser>();
        ojUserQueryWrapper.eq("user_account",ojUser.getUserAccount());
        ojUserQueryWrapper.eq("user_Password",ojUser.getUserPassword());
        return ojUserMapper.selectOne(ojUserQueryWrapper);
    }

    /**
     * 更改用户信息
     * @param ojUser
     * @return
     */
    @Override
    public Integer changeOjUser(OjUser ojUser) {
        int i = ojUserMapper.updateById(ojUser);
        return i;
    }

    /**
     * 分页查询用户
     * @param page
     * @return
     */
    @Override
    public IPage findAll(Page page) {
        return ojUserMapper.selectPage(page, null);
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
    public IPage findClass(Page page) {
        return null;
    }
}
