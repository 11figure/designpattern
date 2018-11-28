package com.leven.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:48 2018/8/1
 * @Modified By:
 */
public class LruCache {

    private static final Logger LOGGER = LoggerFactory.getLogger(LruCache.class);

    public boolean contains(String userId) {
        return cache.containsKey(userId);
    }

    class Node {

        String userId;
        UserAccount userAccount;
        Node previous;
        Node next;

        public Node(String userId, UserAccount userAccount) {
            this.userId = userId;
            this.userAccount = userAccount;
        }
    }

    int capacity;
    Map<String, Node> cache = new HashMap<>();
    Node head;
    Node end;

    public LruCache(int capacity) {
        this.capacity = capacity;
    }


    //增删改查，每次操作注意要刷新head 和 end
    //删
    public void remove(Node node) {
        if (node.previous != null) {
            node.previous.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.previous = node.previous;
        } else {
            end = node.previous;
        }
    }

    //增改

    public void set(String userId, UserAccount userAccount) {
        set(new Node(userId, userAccount));
    }


    public void set(Node node) {
        //改
        if (cache.containsKey(node.userId)) {
            Node old = cache.get(node.userId);
            remove(old);
            setHead(node);
        } else {//增 //注意要增删Map容器
            if (cache.size() >= capacity) {
                cache.remove(end);
                remove(end);
            }
            setHead(node);
            cache.put(node.userId, node);
        }


    }

    public void setHead(Node node) {
        node.next = head;
        node.previous = null;
        if (head != null) {
            head.previous = node;
        }
        if (end == null) {
            end = node;
        }
        head = node;
    }

    /**
     * 查 Get user account
     */
    public UserAccount get(String userId) {
        if (cache.containsKey(userId)) {
            Node node = cache.get(userId);
            remove(node);
            setHead(node);
            return node.userAccount;
        }
        return null;
    }


    //is Full
    public boolean isFull() {
        return cache.size() >= capacity;
    }

    public UserAccount getLruData() {
        return end.userAccount;
    }

    /**
     * clear
     */
    public void clear() {
        head = null;
        end = null;
        cache.clear();
    }

    public List<UserAccount> getCacheDataInListForm() {
        List<UserAccount> listOfCacheData = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            listOfCacheData.add(temp.userAccount);
            temp = temp.next;
        }
        return listOfCacheData;
    }

    public void setCapacity(int newcapacity) {
        if (capacity > newcapacity) {
            clear(); //Behavior can be modified to accomodate for decrease in cach size.
        } else {
            this.capacity = capacity;
        }
    }

    /**
     * Invalidate cache for user
     */
    public void invalidate(String userId) {
        Node toBeRemoved = cache.remove(userId);
        if (toBeRemoved != null) {
            LOGGER.info("# {} has been updated! Removing older version from cache...", userId);
            remove(toBeRemoved);
        }
    }

}
