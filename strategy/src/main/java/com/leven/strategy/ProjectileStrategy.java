package com.leven.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 15:48 2018/5/19
 * @Modified By:
 */
public class ProjectileStrategy implements DragonSlayingStrategy {

    private static Logger LOGGER = LoggerFactory.getLogger(ProjectileStrategy.class);
    @Override
    public void execute() {
        LOGGER.info("ProjectileStrategy");
    }
}
