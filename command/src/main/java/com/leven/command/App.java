package com.leven.command;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:09 2018/8/10
 * @Modified By:
 */
public class App {

    public static void main(String[] args) {
        Wizard wizard = new Wizard();
        Goblin goblin = new Goblin();
        goblin.printStatus();

        wizard.castSpell(new ShrinkSpell(), goblin);
        goblin.printStatus();

        wizard.castSpell(new InvisiablitySpell(), goblin);
        goblin.printStatus();

        wizard.undoLastSpell();
        goblin.printStatus();

        wizard.undoLastSpell();
        goblin.printStatus();

        wizard.redoLastSpell();
        goblin.printStatus();


        wizard.redoLastSpell();
        goblin.printStatus();
    }

}
