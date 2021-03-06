package com.leven.dto;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:55 2018/8/20
 * @Modified By:
 */
public class Author {
    private String username;
    private String name;
    private String email;

    public Author(String username, String name, String email) {
        this.username = username;
        this.name = name;
        this.email = email;
    }

    public Author() {
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
