package com.zrk.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrk.entity.Problem;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/13 19:06
 */
@Repository
public interface ProblemMapper extends BaseMapper<Problem> {

    @Select("select * from oj_problem ${ew.customSqlSegment}")
    IPage<Problem> findAll(IPage<Problem> page,@Param(Constants.WRAPPER) Wrapper<Problem> userWrapper);
}
