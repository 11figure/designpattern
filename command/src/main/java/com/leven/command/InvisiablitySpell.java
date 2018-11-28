package com.leven.command;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 18:43 2018/8/5
 * @Modified By:
 */
public class InvisiablitySpell extends Command {

    private Target target;

    @Override
    public void execute(Target target) {
        target.setVisibility(Visibility.INVISIABLE);
        this.target = target;
    }

    @Override
    public void undo() {
        if (target != null) {
            target.setVisibility(Visibility.VISIABILE);
        }
    }

    @Override
    public void redo() {
        if (target != null) {
            target.setVisibility(Visibility.INVISIABLE);
        }
    }

    @Override
    public String toString() {
        return "Invisibility spell";
    }
}
