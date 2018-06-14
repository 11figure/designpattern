package com.leven.async.method.invocation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:48 2018/6/13
 * @Modified By:
 */
public interface AsyncExecutor {

    /**
     * Starts processing of an asyn task. Returns immediately with asyn result.
     * @param task
     * @param <T>
     * @return
     */
    <T> AsyncResult<T> startProcess(Callable<T> task);

    /**
     * starts processing of an async task. Return immediately with result. Executes callback
     * when the task is complete
     * @param callBack callback to the executed on task completion
     * @param <T>
     * @return
     */
    <T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallBack<T> callBack);

    /**
     * Ends processing of an async task. Blocks the current thread if nessary and returns the
     * evaluate value the completed task.
     * @param asyncResult sync result of a task
     * @param <T>
     * @return evaluate value of the complete task
     * @throws ExecutionException if execution has failed, containing the root cause
     * @throws InterruptedException if the execution is interrupted
     */
    <T> T endProcess(AsyncResult<T> asyncResult) throws ExecutionException, InterruptedException;
}
