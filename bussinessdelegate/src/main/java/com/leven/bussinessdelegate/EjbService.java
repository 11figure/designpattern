package com.leven.bussinessdelegate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:51 2018/8/15
 * @Modified By:
 */
public class EjbService implements  BusinessService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EjbService.class);
    @Override
    public void doProcessing() {
        LOGGER.info("EjbService do processing");
    }
}
