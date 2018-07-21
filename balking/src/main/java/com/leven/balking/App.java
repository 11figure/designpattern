package com.leven.balking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 22:44 2018/7/3
 * @Modified By:
 */
public class App {

    public static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        final WashingMachine washingMachine = new WashingMachine();
        ExecutorService executor = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 5; i++) {
            executor.execute(washingMachine::wash);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            LOGGER.error("ERROR:Waiting on exector service shutdown");
        }
//        final WashingMachine washingMachine = new WashingMachine();
////        ExecutorService executor = Executors.newFixedThreadPool(6);
//        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demon-pool-%d").build();
//        ExecutorService executor = new ThreadPoolExecutor(5,10,123L,
//            TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>(1024),namedThreadFactory,
//            new AbortPolicy());
//        for (int i = 0; i < 5; i++) {
//            executor.execute(washingMachine::wash);
//        }
//        executor.shutdown();
//        try{
//            executor.awaitTermination(10, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            LOGGER.error("ERROR:Waiting on executor service shutdown");
//        }
    }

}
