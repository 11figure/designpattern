package com.leven.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 15:46 2018/5/19
 * @Modified By:
 */
public class MeleeStrategy implements DragonSlayingStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(MeleeStrategy.class);
    @Override
    public void execute() {
        LOGGER.info("MelleStrategy");
    }
}
