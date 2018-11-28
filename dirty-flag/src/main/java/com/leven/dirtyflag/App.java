package com.leven.dirtyflag;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:53 2018/9/3
 * @Modified By:
 */
public class App implements Runnable{


    @Override
    public void run() {
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        World world = new World();
        executorService.scheduleAtFixedRate(() -> {
            List<String> countries = world.fetch();
            System.out.println("Our world currently has the following countries:-");
            for (String country : countries) {
                System.out.println("\t" + country);
            }
        }, 0, 15, TimeUnit.SECONDS);

    }

    public static void main(String[] args) {
        new App().run();
    }
}
