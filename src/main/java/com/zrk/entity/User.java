package com.zrk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zrk.util.MD5;

import java.util.Date;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/13 16:41
 */
@TableName("oj_user")
public class User {
    @TableId(value = "user_id",type = IdType.AUTO)
    private Integer userId;
    private String userName;
    private String userAccount;
    private String userPassword;
    private UserSex userSex;
    private String userEmail;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date userCreateTime;
    private Integer roleId;
    private String roleName;

    /**
     * 增删改查
     * 1)做题权限，参与课程的权限，参加比赛权限：0，即所有用户都有该权限。
     * 2)创建私有题目权限：1（1<<0）。
     * 3)创建课程权限：10（1<<1）。
     * 4)创建比赛权限：100（1<<2）。
     * 5)管理题库权限：1000（1<<3）。
     * 6)查看系统操作日志及查看沙箱状态权限：10000（1<<4）。
     * 7)管理角色权限，管理用户权限：100000（1<<5）。
     *
     */
    private Integer rolePower;
    private String roleDescribe;
    /**
     * 用户状态，保留
     */
    private Integer userStatus;

    public User() {
    }



    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = MD5.getMD5(userPassword);
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public Integer getRolePower() {
        return rolePower;
    }

    public void setRolePower(Integer rolePower) {
        this.rolePower = rolePower;
    }

    public String getRoleDescribe() {
        return roleDescribe;
    }

    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public UserSex getUserSex() {
        return userSex;
    }

    public void setUserSex(UserSex userSex) {
        this.userSex = userSex;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSex=" + userSex +
                ", userEmail='" + userEmail + '\'' +
                ", userCreateTime=" + userCreateTime +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", rolePower=" + rolePower +
                ", roleDescribe='" + roleDescribe + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }

    enum UserSex{
        男,女
    }
    public static boolean hasCreateProblem(Integer rolePower){
        return ((rolePower>>0)&1)==1;
    }
    public static boolean hasCreateCourse(Integer rolePower){
        return ((rolePower>>1)&1)==1;
    }
    public static boolean hasCreateContest(Integer rolePower){
        return ((rolePower>>2)&1)==1;
    }
    public static boolean hasChangeProblems(Integer rolePower){
        return ((rolePower>>3)&1)==1;
    }
    public static boolean hasReadSystem(Integer rolePower){
        return ((rolePower>>4)&1)==1;
    }
    public static boolean hasChangeRole(Integer rolePower){
        return ((rolePower>>5)&1)==1;
    }
}
