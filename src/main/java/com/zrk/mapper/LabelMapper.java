package com.zrk.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zrk.entity.Label;
import com.zrk.entity.Problem;
import com.zrk.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/13 19:05
 */
@Repository
public interface LabelMapper extends BaseMapper<Label> {

    @Select("select * ,(select count(*) from problem_label where oj_label.label_id=problem_label.label_id) labelCount from oj_label")
    IPage<Label> findAll(IPage<Label> page);

    @Select("select l.* from oj_label l join problem_label pl on l.label_id = pl.label_id")
    IPage<Label> findLabel(QueryWrapper<Problem> queryWrapper);

}
