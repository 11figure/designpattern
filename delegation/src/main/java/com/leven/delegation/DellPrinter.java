package com.leven.delegation;

//import com.leven.delegation.Printer2;
/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:46 2018/8/12
 * @Modified By:
 */
public class DellPrinter implements Printer2 {

    @Override
    public void print() {
        System.out.println("DellPrinter print");
    }
}
