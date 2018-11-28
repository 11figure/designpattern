package com.leven.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 18:41 2018/8/5
 * @Modified By:
 */
public abstract class Target {

    private static final Logger LOGGER = LoggerFactory.getLogger(Target.class);
    private Size size;
    private Visibility visibility;

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }


    public abstract String toString();

    public void printStatus() {
        LOGGER.info("{},[size={}] [visibility={}]", this, getSize(), getVisibility());
    }
}
