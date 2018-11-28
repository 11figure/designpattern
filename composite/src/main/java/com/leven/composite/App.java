package com.leven.composite;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:24 2018/8/1
 * @Modified By:
 */
public class App {

    public static void main(String[] args) {
        new Messnger().messageFromElves().print();
        new Messnger().messageFromOrcs().print();
    }
}
