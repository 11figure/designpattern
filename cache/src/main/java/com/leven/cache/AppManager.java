package com.leven.cache;

import java.text.ParseException;

/**
 * @Author: LevenLiu
 * @Description: com.leven.cache.AppManager helps to bridge the gap in communication between the main class and
 * the application's back-end. DB connection is initialized througn this class.The chosen caching strategy/
 * policy is also intialized here. Before the cache can be used, the size of the cache has to be set.
 * Before the cache can be used,
 * @Date: Create 2:20 2018/8/1
 * @Modified By:
 */
public class AppManager {

    private static CachingPolicy cachingPolicy;

    //initDb
    public static void initDb(boolean userMongoDb) {
        if (userMongoDb) {
            try {
                DbManager.connect();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else{
            DbManager.createVirtualDb();
        }
    }

    //initialize caching policy
    public static void initCachingPolicy(CachingPolicy policy) {
        cachingPolicy = policy;
        if (cachingPolicy == CachingPolicy.BEHIND) {
            Runtime.getRuntime().addShutdownHook(new Thread(CacheStore::flushCache));
        }
        CacheStore.clearCache();
    }


    public static void initCacheCapacity(int capacity) {
        CacheStore.initCapacity(capacity);
    }

    //find user Acount
    public static UserAccount find(String userId) {
        if (cachingPolicy == CachingPolicy.THROUGH || cachingPolicy == cachingPolicy.AROUND) {
            return CacheStore.readThrough(userId);
        } else if (cachingPolicy == CachingPolicy.BEHIND) {
            return CacheStore.readThroughWithWriteBackPolicy(userId);
        } else if (cachingPolicy == CachingPolicy.ASIDE) {
            return findAside(userId);
        }
        return null;
    }

    //print cache content
    public static String printCacheContent() {
        return CacheStore.print();
    }

    //save user account
    public static  void save(UserAccount userAccount) {
        switch (cachingPolicy){
            case THROUGH:
                CacheStore.writeThrough(userAccount);
                break;
            case AROUND:
                CacheStore.writeAround(userAccount);
                break;
            case BEHIND:
                CacheStore.writeBehind(userAccount);
                break;
            case ASIDE:
                saveAside(userAccount);
                break;
        }

    }

    //cache-Aside save user account helper //不用cache
    public static void saveAside(UserAccount userAccount) {
        DbManager.upsertDb(userAccount);
        CacheStore.invalidate(userAccount.getUserId());

    }

    //cache-aside find user account helper
    private  static  UserAccount findAside(String userId) {
        UserAccount userAccount = CacheStore.get(userId);
        if (userAccount != null) {
            return userAccount;
        } else {
            UserAccount userAccount1 = DbManager.readFromDb(userId);
            CacheStore.set(userId, userAccount1);
            return userAccount1;
        }
    }
}
