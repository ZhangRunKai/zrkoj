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
    /**
     * 创建题目
     * @param problem
     * @return
     */
    Integer add(Problem problem);

    /**
     * 删除题目
     * @param problem
     * @return
     */
    Integer delete(Problem problem);

    /**
     * 更改题目
     * @param problem
     * @return
     */
    Integer update(Problem problem);

    /**
     * 分页查询题库
     * @param page
     * @return
     */
    IPage<Problem> findAll(Page page);

    /**
     * 查询单个题目
     * @param problem
     * @return
     */
    Problem find(Problem problem);

    /**
     * 管理员查询个人题库
     * @param page
     * @return
     */
    IPage<Problem> findProblemByPrivate(Page page);


}
