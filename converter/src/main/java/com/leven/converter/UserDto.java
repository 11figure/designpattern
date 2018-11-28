package com.leven.converter;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:15 2018/8/14
 * @Modified By:
 */
public class UserDto {
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String email;

    public UserDto(String firstName, String lastName, boolean isActive, String userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.email = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
