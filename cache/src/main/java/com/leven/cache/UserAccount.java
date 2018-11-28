package com.leven.cache;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:49 2018/8/1
 * @Modified By:
 */
public class UserAccount {

    String userId;
    String userName;
    String additionalInfo;

    public UserAccount(String userId, String userName, String additionalInfo) {
        this.userId = userId;
        this.userName = userName;
        this.additionalInfo = additionalInfo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
            .add("userId", userId)
            .add("userName", userName)
            .add("additionalInfo", additionalInfo)
            .toString();
    }
}
