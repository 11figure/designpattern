package com.leven.command;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:30 2018/8/5
 * @Modified By:
 */
public class Goblin extends Target {

    public Goblin() {
        setSize(Size.NORMAL);
        setVisibility(Visibility.VISIABILE);
    }

    @Override
    public String toString() {
        return "com.leven.command.Goblin ";
    }
}
