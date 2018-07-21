package com.leven.guarded.suspension;

import java.util.LinkedList;
import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description: Guarded Queue is an implementation for Guarded Suspension Pattern
 * Guarded suspension pattern is used to handle a sitution when you want to execute a method
 * on an object which is not in a proper state.
 * @Date: Create 0:07 2018/7/5
 * @Modified By:
 */
public class GuardedQueue {

    Logger LOGGER = LoggerFactory.getLogger(GuardedQueue.class);
    private Queue<Integer> sourceList;

    public GuardedQueue() {
        this.sourceList = new LinkedList<>();
    }

    public synchronized void put(Integer e) {
        LOGGER.info("putting");
        sourceList.add(e);
        LOGGER.info("notifying");
        notify();
    }
    public synchronized Integer get() {
        while (sourceList.isEmpty()) {
            try {
                LOGGER.info("waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        LOGGER.info("getting");
        return sourceList.peek();
    }
}
