package com.leven.bussinessdelegate;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:53 2018/8/15
 * @Modified By:
 */
public class Client {

    private BussinessDelegate bussinessDelegate;

    public Client(BussinessDelegate bussinessDelegate) {
        this.bussinessDelegate = bussinessDelegate;
    }

    public void doTask() {
        bussinessDelegate.doTask();
    }
}
