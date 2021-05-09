package com.zrk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrk.entity.Contest;
import com.zrk.entity.ContestProblem;
import com.zrk.entity.Problem;
import com.zrk.entity.User;
import com.zrk.mapper.ContestMapper;
import com.zrk.mapper.ContestProblemMapper;
import com.zrk.mapper.ProblemMapper;
import com.zrk.service.ContestServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/4/23 16:20
 */
@Service
public class ContestServletImpl implements ContestServlet {

    @Autowired
    private ContestMapper contestMapper;

    @Autowired
    private ProblemMapper problemMapper;

    @Autowired
    private ContestProblemMapper contestProblemMapper;

    @Override
    public Integer createContest(Contest contest) {
        int insert = contestMapper.insert(contest);
        List<ContestProblem> problems = contest.getProblems();
        for (ContestProblem problem : problems) {
            contestProblemMapper.insert(problem);
        }
        return insert;
    }

    @Override
    public Integer joinContest(User user, Contest contest) {
        return null;
    }

    @Override
    public Integer updateContest(Contest contest) {
        return null;
    }

    @Override
    public IPage<Contest> findAll(Contest contest) {
        return null;
    }

    @Override
    public IPage<Contest> findAllByCreate(Integer userId, Page page) {
        return contestMapper.selectPage(page,new QueryWrapper<Contest>().eq("user_id",userId));
    }

    @Override
    public IPage<User> findJoinStudent(Contest contest) {
        return null;
    }

}
