package com.leven.async.method.invocation;

import java.util.concurrent.ExecutionException;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:48 2018/6/13
 * @Modified By:
 */
public interface AsyncResult<T> {

    /**
     * Status of the async task execution
     * @return
     */
    boolean isCompleted();

    /**
     * Get the value of completed async task
     * @return evaluate value or throws ExecutionExecption if execution has failed
     * @throws ExecutionException if execution is not completed
     */
    T getValue() throws ExecutionException;

    /**
     * Blocks the current thread until the async task is complete
     * @throws InterruptedException
     */
    void await() throws InterruptedException;

}
