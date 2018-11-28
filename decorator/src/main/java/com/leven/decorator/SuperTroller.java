package com.leven.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:46 2018/8/10
 * @Modified By:
 */
public class SuperTroller implements  Troll{

    private static final Logger LOGGER = LoggerFactory.getLogger(SuperTroller.class);
    private SimpleTroll simpleTroll;

    public SuperTroller(SimpleTroll simpleTroll) {
        this.simpleTroll = simpleTroll;
    }

    @Override
    public void attack() {
        simpleTroll.attack();
        LOGGER.info("attack with Clubbed");
    }

    @Override
    public void getAttackPower() {
        simpleTroll.getAttackPower();
    }

    @Override
    public void fleetBattle() {
        simpleTroll.fleetBattle();
    }
}
