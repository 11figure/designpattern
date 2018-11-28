package com.leven.decorator;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:48 2018/8/10
 * @Modified By:
 */
public class App {

    public static void main(String[] args) {
        SuperTroller superTroller = new SuperTroller(new SimpleTroll());
        superTroller.attack();
        superTroller.getAttackPower();
        superTroller.fleetBattle();
    }

}
