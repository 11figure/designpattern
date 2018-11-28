package com.leven.composite;

import java.util.List;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:48 2018/7/31
 * @Modified By:
 */
public class Sentence extends LetterComposite {

    public Sentence(List<Word> words) {
        for (Word w : words) {
            this.add(w);
        }
    }

    @Override
    protected void printThisAfter() {
        System.out.print(".");
    }
}
