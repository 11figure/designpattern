package com.leven.bussinessdelegate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:52 2018/8/15
 * @Modified By:
 */
public class JmsService implements BusinessService {
    private static final Logger LOGGER = LoggerFactory.getLogger(JmsService.class);
    @Override
    public void doProcessing() {
        LOGGER.info("JmsService do processing");
    }
}
