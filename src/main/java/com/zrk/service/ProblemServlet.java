package com.zrk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrk.entity.Problem;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/15 12:05
 */
public interface ProblemServlet {
    Integer add(Problem problem);
    Integer delete(Problem problem);
    Integer update(Problem problem);
    IPage<Problem> findAll(Page page);

    Problem find(Problem problem);
}
