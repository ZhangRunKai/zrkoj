package com.zrk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrk.entity.Label;
import com.zrk.entity.Problem;
import com.zrk.entity.ProblemLabel;
import com.zrk.mapper.LabelMapper;
import com.zrk.mapper.ProblemLabelMapper;
import com.zrk.mapper.ProblemMapper;
import com.zrk.service.ProblemServlet;
import com.zrk.util.OjSqlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/15 13:04
 */
@Service
public class ProblemServletImpl implements ProblemServlet {
    @Autowired
    private ProblemMapper problemMapper;

    @Autowired
    private LabelMapper labelMapper;

    @Autowired
    private ProblemLabelMapper problemLabelMapper;

    @Override
    @Transactional(rollbackFor = OjSqlException.class)
    public Integer add(Problem problem) {
        if(problemMapper.insert(problem)>0){
            System.out.println(problem.getProblemId());
            for(Label i:problem.getLabels()){
                int insert = problemLabelMapper.insert(new ProblemLabel(problem.getProblemId(),i.getLabelId()));
                if(insert==0){
                    throw new OjSqlException("标签插入失败:problem:"+problem.toString());
                }
            }
            return 1;
        }
        else throw  new OjSqlException("题目创建失败：problem:"+problem.toString());
    }

    @Override
    public Integer delete(Problem problem) {
        return null;
    }

    @Override
    public Integer update(Problem problem) {
        return null;
    }

    @Override
    public IPage<Problem> findAll(Page page) {
        return problemMapper.selectPage(page, new QueryWrapper<Problem>().eq("problem_power", "0"));
    }

    @Override
    public Problem find(Problem problem) {
        Problem problem1 = problemMapper.selectOne(new QueryWrapper<Problem>().eq("problem_id", problem.getProblemId()).eq("problem_power","0"));
        return problem1;
    }

}
