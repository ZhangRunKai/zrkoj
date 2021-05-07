package com.zrk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zrk.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/13 19:05
 */
@Repository
public interface RoleMapper extends BaseMapper<Role> {

}
