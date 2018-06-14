package com.leven.async.method.invocation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:47 2018/6/13
 * @Modified By:
 */
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        AsyncExecutor executor = new ThreadAsyncExecutor();
        //start few async tasks with warying processing time, two last with callback handlers
        AsyncResult<Integer> integerAsyncResult = executor.startProcess(lazyval(10, 5000));
        AsyncResult<String> stringAsyncResult = executor.startProcess(lazyval("23", 500));
        AsyncResult<Long> longAsyncResult = executor.startProcess(lazyval(50L, 100));
        AsyncResult<Integer> integerAsyncResult1 = executor
            .startProcess(lazyval(20, 400), callback("callback result 4"));

        //
        Thread.sleep(240);

        //wait for completoin fo the task
        Integer resul1 = executor.endProcess(integerAsyncResult);
        String resul2 = executor.endProcess(stringAsyncResult);
        Long resul3 = executor.endProcess(longAsyncResult);
        integerAsyncResult1.await();
    }



    private static <T> Callable<T> lazyval(T value, long delayMillis) {
        return () -> {
            Thread.sleep(delayMillis);
            log("Task completed with: " + value);
            return value;
        };
    }

    private static <T> AsyncCallBack<T> callback(String name) {
        return (value, ex) ->{
            if (ex.isPresent()) {
                log(name + "failed" + ex.map(Exception::getMessage).orElse(""));
            } else {
                log(name + ":" + value);
            }
        };
    }


    private static void log(String msg) {
        LOGGER.info(msg);
    }
}
