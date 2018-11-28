package com.leven.composite;

import java.util.List;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:07 2018/7/12
 * @Modified By:
 */
public class Word extends LetterComposite {

    public Word(List<Letter> letters) {

        for (Letter l : letters) {
            this.add(l);
        }
    }

    @Override
    protected void printThisBefore() {
        System.out.print(" ");
    }

}
