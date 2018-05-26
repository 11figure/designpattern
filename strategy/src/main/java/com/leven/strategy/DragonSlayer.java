package com.leven.strategy;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 15:52 2018/5/19
 * @Modified By:
 */
public class DragonSlayer {
    private DragonSlayingStrategy strategy;

    public DragonSlayer(DragonSlayingStrategy strategy) {
        this.strategy = strategy;
    }

    public void changeStrategy(DragonSlayingStrategy strategy) {
        this.strategy = strategy;
    }
    void slay() {
        strategy.execute();
    }
}
