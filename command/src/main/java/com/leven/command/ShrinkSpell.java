package com.leven.command;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 18:44 2018/8/5
 * @Modified By:
 */
public class ShrinkSpell extends Command {

    private Size oldSize;

    private Target target;
    @Override
    public void execute(Target target) {
        oldSize = target.getSize();
        target.setSize(Size.SMALL);
        this.target = target;
    }

    @Override
    public void undo() {
        if (oldSize != null && target != null) {
            Size temp = target.getSize();
            target.setSize(oldSize);
            oldSize = temp;
        }
    }

    @Override
    public void redo() {
        undo();
    }

    @Override
    public String toString() {
        return "Shrink spell";
    }
}
