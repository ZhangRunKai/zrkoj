package com.zrk.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zrk.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/13 19:06
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    @Select("select user_name,user_id,role_power,role_describe from oj_user u,oj_role r ${ew.customSqlSegment} and r.role_id=u.role_id")
    public User login(@Param(Constants.WRAPPER) QueryWrapper<User> queryWrapper);
}
