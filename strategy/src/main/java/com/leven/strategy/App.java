package com.leven.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 15:45 2018/5/19
 * @Modified By:
 */
public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        //melleestrategy
        DragonSlayer slayer1 = new DragonSlayer(new MeleeStrategy());
        slayer1.slay();
        //
        DragonSlayer slayer2 = new DragonSlayer(new ProjectileStrategy());
        slayer2.slay();

        DragonSlayer slayer3 = new DragonSlayer(new SpellStrategy());
        slayer3.slay();

        slayer1.changeStrategy(new ProjectileStrategy());
        slayer1.slay();

        DragonSlayer dragonSlayer = new DragonSlayer(
            () -> LOGGER.info("With your Excalibur you severe the dragon's head!"));
        dragonSlayer.slay();

        dragonSlayer.changeStrategy(()->LOGGER.info(
            "your shoot the dragon with the magical crossbow and it false dead on the ground"
        ));
        dragonSlayer.slay();

    }
}
