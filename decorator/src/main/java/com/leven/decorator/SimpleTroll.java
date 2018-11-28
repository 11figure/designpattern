package com.leven.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Administrator
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:42 2018/8/10
 * @Modified By:
 */
public class SimpleTroll implements Troll {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleTroll.class);

    @Override
    public void attack() {
        LOGGER.info("simple attack");
    }

    @Override
    public void getAttackPower() {
        LOGGER.info("simple get power");
    }

    @Override
    public void fleetBattle() {
        LOGGER.info("simple fleet battle");
    }
}
