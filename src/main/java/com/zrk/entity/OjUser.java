package com.zrk.entity;

import com.zrk.util.MD5;

public class OjUser {

    private Integer userId;
    private String userName;
    private String userAccount;
    private String userPassword;
    private Integer userPower;
    private Integer userStatus;

    public OjUser() {
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

    /**
     * 对所有密码进行加密处理
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = MD5.getMD5(userPassword);
    }

    public Integer getUserPower() {
        return userPower;
    }

    public void setUserPower(Integer userPower) {
        this.userPower = userPower;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "OjUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPower=" + userPower +
                ", userStatus=" + userStatus +
                '}';
    }
}
