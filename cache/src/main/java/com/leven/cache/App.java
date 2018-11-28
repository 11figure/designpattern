package com.leven.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 2:27 2018/8/2
 * @Modified By:
 */
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        AppManager.initDb(false);
        AppManager.initCacheCapacity(3);
        App app = new App();
//        app.useReadAndWriteThroughStrategy();
//        app.useResdThroughAndWriteAroundStrategy();
//        app.useReadThroughAndWriteBehidndStrategy();
        app.userCacheAsideStrategy();
    }


    private void useReadAndWriteThroughStrategy() {
        LOGGER.info("# com.leven.cache.CachingPolicy.THROUGH");
        AppManager.initCachingPolicy(CachingPolicy.THROUGH);
        AppManager.save(new UserAccount("01", "user1", "user1 info"));
        LOGGER.info(AppManager.printCacheContent());
        AppManager.find("01");
        AppManager.find("01");
    }

    /**
     *
     */
    private void useResdThroughAndWriteAroundStrategy() {
        LOGGER.info("# com.leven.cache.CachingPolicy.Around start");
        AppManager.initCachingPolicy(CachingPolicy.AROUND);
        AppManager.save(new UserAccount("02", "user02", "user02 info"));
        LOGGER.info(AppManager.printCacheContent());
        AppManager.find("02");
        LOGGER.info(AppManager.printCacheContent());
        AppManager.save(new UserAccount("02", "user02", "user02 info"));
        AppManager.save(new UserAccount("02", "user02", "user02 info"));
        AppManager.save(new UserAccount("01", "user1", "user1 info"));
        AppManager.save(new UserAccount("03", "user3", "user3 info"));
        AppManager.save(new UserAccount("04", "user4", "user4 info"));
        LOGGER.info(AppManager.printCacheContent());
        AppManager.find("01");
        AppManager.find("02");
        AppManager.find("03");
        LOGGER.info(AppManager.printCacheContent());
        AppManager.find("01");
        AppManager.find("02");
        AppManager.find("03");
        LOGGER.info("# com.leven.cache.CachingPolicy.Around end");

    }

    /**
     * Read-through and write-behind write high perfermance?
     */
    private void useReadThroughAndWriteBehidndStrategy() {
        LOGGER.info("# com.leven.cache.CachingPolicy.BEHIND");
        AppManager.initCachingPolicy(CachingPolicy.BEHIND);
        AppManager.save(new UserAccount("02", "user02", "user02 info"));
        LOGGER.info(AppManager.printCacheContent());
        AppManager.find("02");
        LOGGER.info(AppManager.printCacheContent());
        AppManager.save(new UserAccount("02", "user02", "user02 info"));
        AppManager.save(new UserAccount("02", "user02", "user02 info"));
        AppManager.save(new UserAccount("01", "user1", "user1 info"));
        AppManager.save(new UserAccount("03", "user3", "user3 info"));
        AppManager.save(new UserAccount("04", "user4", "user4 info"));
        LOGGER.info(AppManager.printCacheContent());
        AppManager.find("01");
        AppManager.find("02");
        AppManager.find("03");
        LOGGER.info(AppManager.printCacheContent());
        AppManager.find("01");
        AppManager.find("02");
        AppManager.find("03");
    }


    private void userCacheAsideStrategy() {
        LOGGER.info("# com.leven.cache.CachingPolicy.THROUGH");
        AppManager.initCachingPolicy(CachingPolicy.ASIDE);
        AppManager.save(new UserAccount("02", "user02", "user02 info"));
        AppManager.save(new UserAccount("02", "user02", "user02 info"));
        AppManager.save(new UserAccount("01", "user1", "user1 info"));
        AppManager.save(new UserAccount("03", "user3", "user3 info"));
        AppManager.save(new UserAccount("04", "user4", "user4 info"));
        LOGGER.info(AppManager.printCacheContent());
        AppManager.find("01");
        AppManager.find("02");
        AppManager.find("03");
        LOGGER.info(AppManager.printCacheContent());
        AppManager.find("01");
        AppManager.find("02");
        AppManager.find("03");
        LOGGER.info(AppManager.printCacheContent());

    }
}
