package com.leven.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 22:54 2018/8/10
 * @Modified By:
 */
public abstract class StealingMethod {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StealingMethod.class);
    
    protected abstract String pickTarget();

    protected abstract void confuseTarget(String target);

    protected abstract void stealTheItem(String Target);

    public void steal() {
        String target = this.pickTarget();
        this.confuseTarget(target);
        this.stealTheItem(target);
    }
}
