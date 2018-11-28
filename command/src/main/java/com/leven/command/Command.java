package com.leven.command;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 18:40 2018/8/5
 * @Modified By:
 */
public abstract class Command {
    public abstract void execute(Target target);

    public abstract void undo();

    public abstract void redo();

    @Override
    public abstract String toString();
}
