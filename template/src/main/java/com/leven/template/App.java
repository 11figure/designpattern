package com.leven.template;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:22 2018/8/10
 * @Modified By:
 */
public class App {

    public static void main(String[] args) {
        HalfingThief thief = new HalfingThief(new HitAndRunMethod());
        thief.steal();
        thief.changeMethod(new SubtleMethod());
        thief.steal();
    }
}
