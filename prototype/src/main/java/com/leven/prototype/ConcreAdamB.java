package com.leven.prototype;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:19 2018/7/11
 * @Modified By:
 */
public class ConcreAdamB implements Adam {
    private String age;
    @Override
    public Adam copy() {
        return this;
    }
}
