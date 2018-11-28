package com.leven.converter;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:14 2018/8/14
 * @Modified By:
 */
public class User {
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String userId;

    public User(String firstName, String lastName, boolean isActive, String userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}
