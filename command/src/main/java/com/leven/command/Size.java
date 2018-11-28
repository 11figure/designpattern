package com.leven.command;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 19:48 2018/8/5
 * @Modified By:
 */
public enum Size {
    NORMAL("normal"), SMALL("small");
    private String title;


    Size(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("com.leven.command.Size{}",title);
    }
}
