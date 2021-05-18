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

    /**
     * 能创建私有题目
     * @param param
     * @return
     */
    public static boolean canCreatePrivateProblem(Integer param){
        return (param & 1) == 1;
    }

    /**
     * 能创建课程
     * @param param
     * @return
     */
    public static boolean canCreateCourse(Integer param){
        return ((param >> 1) & 1) == 1;
    }

    /**
     * 创建比赛权限
     * @param param
     * @return
     */
    public static boolean canCreateContest(Integer param){
        return ((param >> 2) & 1) == 1;
    }

    /**
     * 管理题库
     * @param param
     * @return
     */
    public static boolean canManageProblems(Integer param){
        return ((param >> 3) & 1) == 1;
    }

    /**
     * 角色管理及用户管理
     * @param param
     * @return
     */
    public static boolean canManageRoleAndUser(Integer param){
        return ((param >> 5) & 1) == 1;
    }
}
