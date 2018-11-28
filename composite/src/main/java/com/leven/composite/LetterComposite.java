package com.leven.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:00 2018/7/12
 * @Modified By:
 */
public abstract class LetterComposite {

    private List<LetterComposite> children = new ArrayList<>();

    public void add(LetterComposite letterComposite) {
        children.add(letterComposite);
    }

    public int count() {
        return children.size();
    }

    protected  void printThisBefore(){};
    protected  void printThisAfter(){};

    /**
     * Print
     */
    public void print() {
        printThisBefore();
        for (LetterComposite letter : children) {
            letter.print();
        }
        printThisAfter();
    }
}
