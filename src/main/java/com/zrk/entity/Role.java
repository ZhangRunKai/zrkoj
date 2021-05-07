package com.zrk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/12 21:48
 */
@Data
@TableName("oj_role")
public class Role {

    @TableId(value = "role_id",type = IdType.AUTO)
    private Integer roleId;
    private String roleName;
    private Integer rolePower;
    private String roleDescribe;
    private Integer roleNum;

}
