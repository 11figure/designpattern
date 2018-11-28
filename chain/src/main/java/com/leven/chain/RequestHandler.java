package com.leven.chain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:38 2018/7/11
 * @Modified By:
 */
public abstract class RequestHandler {

    public static final Logger LOGGER = LoggerFactory.getLogger(RequestHandler.class);

    public RequestHandler(RequestHandler requestHandler) {
        this.next = requestHandler;
    }

    private RequestHandler next;

    public void handleRequest(Request request) {
        if (null != next) {
            next.handleRequest(request);
        }
    }

    public void printHandling(Request request) {
        LOGGER.info("{} handling request \"{}\"", this, request);
    }
}
