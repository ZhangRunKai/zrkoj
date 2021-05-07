package com.zrk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrk.entity.Contest;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/4/23 16:19
 */
public interface ContestServlet {

    public boolean createContest(Contest contest);

    public IPage<Contest> findAll(Contest contest);

    public IPage<Contest> findAllByCreate(Integer userId, Page page);
}
