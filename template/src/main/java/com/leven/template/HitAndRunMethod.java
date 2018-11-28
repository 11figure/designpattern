package com.leven.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:01 2018/8/10
 * @Modified By:
 */
public class HitAndRunMethod extends StealingMethod {

    private static final Logger LOGGER = LoggerFactory.getLogger(HitAndRunMethod.class);

    @Override
    public String pickTarget() {
        return "old golbin woman";
    }

    @Override
    public void confuseTarget(String target) {
        LOGGER.info("Approach the {} from behind", target);
    }

    @Override
    public void stealTheItem(String target) {
        LOGGER.info("Grab the handbag andd run away fast!");
    }
}
