package com.leven.async.method.invocation;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: LevenLiu
 * @Description: Implementation of async executor that creates a new thread for every task
 * @Date: Create 23:49 2018/6/13
 * @Modified By:
 */
public class ThreadAsyncExecutor implements AsyncExecutor {
    /*Index for thread nameing*/
    private final AtomicInteger idx = new AtomicInteger(0);

    @Override
    public <T> AsyncResult<T> startProcess(Callable<T> task) {
        return startProcess(task, null);
    }

    @Override
    public <T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallBack<T> callBack) {
        CompletableResult<T> result = new CompletableResult<>(callBack);
        new Thread(() ->{
            try {
                result.setValue(task.call());
            } catch (Exception e) {
                result.setException(e);
            }

        },"executor-" + idx.incrementAndGet()).start();
        return result;
    }



    @Override
    public <T> T endProcess(AsyncResult<T> asyncResult)
        throws ExecutionException, InterruptedException {
        if (!asyncResult.isCompleted()) {
            asyncResult.await();
        }
        return asyncResult.getValue();
    }

    private class CompletableResult<T> implements AsyncResult{
        static final int RUNNING = 1;
        static final int FAILED = 2;
        static final int COMPLETE = 3;
        final Object lock;
        final Optional<AsyncCallBack<T>> callback;

        volatile int state = RUNNING;
        T value;
        Exception exception;

        CompletableResult(AsyncCallBack<T> callback) {
            this.lock = new Object();
            this.callback = Optional.ofNullable(callback);
        }

        @Override
        public boolean isCompleted() {
            return state > RUNNING;
        }

        @Override
        public T getValue() throws ExecutionException {
            if (state == COMPLETE) {
                return value;
            } else if (state == FAILED) {
                throw new ExecutionException(exception);
            } else {
                throw new IllegalStateException("Execution not completed yet");
            }
        }

        @Override
        public void await() throws InterruptedException {
            synchronized (lock) {
                while (!isCompleted()) {
                    lock.wait();
                }
            }
        }

        /**
         * Set the value from successful execution and executes callback if avaiable.
         * Notifies any thread waiting for completion.
         * @param value
         */
        public void setValue(T value) {
            this.value = value;
            this.state = COMPLETE;
            this.callback.ifPresent(ac -> ac.onComplete(value, Optional.<Exception>empty()));
            synchronized (lock) {
                lock.notifyAll();
            }
        }

        /**
         * Set the exception from failed execution and execute callback fi available, Notified any
         * thread waiting for completion.
         * @param exception
         */
        public void setException(Exception exception) {
            this.exception = exception;
            this.state = FAILED;
            this.callback.ifPresent(ac -> ac.onComplete(null, Optional.of(exception)));
            synchronized (lock) {
                lock.notifyAll();
            }
        }
    }
}
