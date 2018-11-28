package com.leven.command;

import java.util.Deque;
import java.util.LinkedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 18:45 2018/8/5
 * @Modified By:
 */
public class Wizard {

    private static final Logger LOGGER = LoggerFactory.getLogger(Wizard.class);
    private Deque<Command> redoStack = new LinkedList<>();
    private Deque<Command> undoStack = new LinkedList<>();

    public Wizard() {
        // comment to ignore sonar issue: LEVEL critical
    }

    /**
     * Cast Spell
     * @param command
     * @param target
     */
    public void castSpell(Command command, Target target) {
        LOGGER.info("{} casts {} at {}", this, command, target);
        command.execute(target);
        undoStack.offerLast(command);
    }

    public void undoLastSpell() {
        if (!undoStack.isEmpty()) {
            Command previousSpell = undoStack.pollLast();
            redoStack.offerLast(previousSpell);
            LOGGER.info("{} undoes {}", this, previousSpell);
            previousSpell.undo();
        }
    }

    public void redoLastSpell() {
        if (!redoStack.isEmpty()) {
            Command previousSpell = redoStack.pollLast();
            undoStack.offerLast(previousSpell);
            LOGGER.info("{} redoes {}", this, previousSpell);
            previousSpell.redo();
        }
    }

    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
            .add("redoStack", redoStack)
            .add("undoStack", undoStack)
            .toString();
    }
}
