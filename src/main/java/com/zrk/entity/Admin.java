package com.zrk.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zrk.util.MD5;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/7 12:30
 */
@TableName("oj_admin")
public class Admin {
    private Integer adminId;
    private String adminName;
    private String adminAccount;
    private String adminPassword;
    /**
     * 管理员权限
     * rwx: 系统管理权限
     *    rwx：同组管理权限 56
     *        rwx：个人管理权限 7
     */
    private Integer adminPower;

    public static boolean checkAdmin(Admin admin){
        if(admin!=null&&admin.getAdminAccount()!=null
                &&admin.getAdminPassword()!=null) return true;
        return false;
    }

    public Admin() {
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = MD5.getMD5(adminPassword);
    }

    public Integer getAdminPower() {
        return adminPower;
    }

    public void setAdminPower(Integer adminPower) {
        this.adminPower = adminPower;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminAccount='" + adminAccount + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }
}
