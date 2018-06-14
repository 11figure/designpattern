package com.leven.async.method.invocation;

import java.util.Optional;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:48 2018/6/13
 * @Modified By:
 */
public interface AsyncCallBack<T> {

    /**
     * Complete handler whick is executed when async task is completed or failes execution
     * @param value the evaluated value from async task, undefined when execution fails
     * @param ex empty value if execution succeeds,some exception if executions fails
     */
    void onComplete(T value, Optional<Exception> ex);
}
