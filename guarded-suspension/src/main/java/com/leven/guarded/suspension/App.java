package com.leven.guarded.suspension;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:08 2018/7/5
 * @Modified By:
 */
public class App {
    public static void main(String[] args) {
        GuardedQueue guardedQueue = new GuardedQueue();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //
        executorService.execute(()->{guardedQueue.get();});
    }
}
