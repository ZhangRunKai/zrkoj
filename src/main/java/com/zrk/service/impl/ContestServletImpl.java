package com.zrk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrk.entity.Contest;
import com.zrk.mapper.ContestMapper;
import com.zrk.service.ContestServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/4/23 16:20
 */
@Service
public class ContestServletImpl implements ContestServlet {

    @Autowired
    private ContestMapper contestMapper;

    @Override
    public boolean createContest(Contest contest) {
        int insert = contestMapper.insert(contest);
        return insert==1;
    }

    @Override
    public IPage<Contest> findAll(Contest contest) {
        return null;
    }

    @Override
    public IPage<Contest> findAllByCreate(Integer userId, Page page) {
        return contestMapper.selectPage(page,new QueryWrapper<Contest>().eq("user_id",userId));
    }

}
