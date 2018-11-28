package com.leven.cache;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 2:01 2018/8/1
 * @Modified By:
 */
public class CacheStore {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheStore.class);
    static LruCache cache;

    public CacheStore() {
    }

    public static void initCapacity(int capacity){
        if (cache == null) {
            cache = new LruCache(capacity);
        }else {
            cache.setCapacity(capacity);
        }
    }

    public static UserAccount readThrough(String userID) {
        if (cache.contains(userID)) {
            LOGGER.info("# Cache Hit");
            return cache.get(userID);
        }
        LOGGER.info("# Cache Miss");
        UserAccount userAccount = DbManager.readFromDb(userID);
        cache.set(userID, userAccount);
        return userAccount;
    }

    /**
     * Get user account using writeThrough cache
     * @param userAccount
     */
    public static void writeThrough(UserAccount userAccount) {
        if (cache.contains(userAccount.getUserId())) {
            DbManager.updateDb(userAccount);
        } else {
            DbManager.writeToDb(userAccount);
        }
        cache.set(userAccount.getUserId(), userAccount);
    }


    /**
     *
     * @param userAccount
     */
    public static void writeAround(UserAccount userAccount) {
        if (cache.contains(userAccount.getUserId())) {
            DbManager.updateDb(userAccount);
            cache.invalidate(userAccount.getUserId()); //Cache com.leven.data has been updated -- remove older
            //version from cache

        }else{
            DbManager.writeToDb(userAccount);
        }
    }

    /**
     * Get user account using read-through cache with write-back policy
     */
    public static UserAccount readThroughWithWriteBackPolicy(String userId) {
        if (cache.contains(userId)) {
            LOGGER.info("# Cache Hit!");
            return cache.get(userId);
        }
        LOGGER.info("# Cache Miss!");
        UserAccount userAccount = DbManager.readFromDb(userId);
        if (cache.isFull()) {
            LOGGER.info("# Cache is FULL! Writing LRU com.leven.data to DB...");
            UserAccount toBeWrittenToDb = cache.getLruData();
            DbManager.upsertDb(toBeWrittenToDb);
        }
        cache.set(userId, userAccount);
        return userAccount;
    }

    /**
     * Set user account
     */
    public static void writeBehind(UserAccount userAccount) {
        if (cache.isFull() && !cache.contains(userAccount.getUserId())) {
            LOGGER.info("# Cache is FULL! Writing LRU com.leven.data to DB...");
            UserAccount toBeWrittenToDb = cache.getLruData();
            DbManager.upsertDb(toBeWrittenToDb);
        }
        cache.set(userAccount.getUserId(), userAccount);
    }

    /**
     * Clears cache
     */
    public static void clearCache() {
        if (cache != null) {
            cache.clear();
        }
    }

    /**
     * Writes remaining content in the cache into the DB.
     */
    public static void flushCache() {
        LOGGER.info("# flushCache...");
        if (null == cache) {
            return;
        }
        List<UserAccount> listOfUserAccounts = cache.getCacheDataInListForm();
        for (UserAccount userAccount : listOfUserAccounts) {
            DbManager.upsertDb(userAccount);
        }
    }

    public static String print() {
        List<UserAccount> listOfUserAccounts = cache.getCacheDataInListForm();
        StringBuilder sb = new StringBuilder();
        sb.append("\n--CACHE CONTENT--\n");
        listOfUserAccounts.forEach(userAccount -> sb.append(userAccount.toString() + "\n"));
        sb.append("----\n");
        return sb.toString();
    }

    /**
     * Delegate to backing cache store
     * @param userId
     * @return
     */
    public static UserAccount get(String userId) {
        return cache.get(userId);
    }

    public static void set(String userId, UserAccount userAccount) {
        cache.set(userId, userAccount);
    }


    public static void invalidate(String userId) {
        cache.invalidate(userId);
    }


}
