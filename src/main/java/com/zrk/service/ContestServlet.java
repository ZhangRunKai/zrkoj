package com.zrk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrk.entity.Contest;
import com.zrk.entity.User;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/4/23 16:19
 */
public interface ContestServlet {

    /**
     * 管理员创建比赛
     * @param contest
     * @return
     */
    Integer createContest(Contest contest);

    /**
     * 学生参加比赛
     * @param user
     * @param contest
     * @return
     */
    Integer joinContest(User user, Contest contest);


    /**
     * 管理员更新比赛
     * @param contest
     * @return
     */
    Integer updateContest(Contest contest);

    /**
     * 学生查询比赛
     * @param contest
     * @return
     */
    IPage<Contest> findAll(Contest contest);

    /**
     * 管理员查询所管理的比赛
     * @param userId
     * @param page
     * @return
     */
    IPage<Contest> findAllByCreate(Integer userId, Page page);

    /**
     * 查询报名参加的比赛学生
     * @param contest
     * @return
     */
    IPage<User> findJoinStudent(Contest contest);
}
