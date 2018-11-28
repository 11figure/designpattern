package com.leven.delegation;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:40 2018/8/12
 * @Modified By:
 */
public class App {

    public static void main(String[] args) {
        PrinterController hpprinterController = new PrinterController(new HPPrinter());
        PrinterController dellprinterController = new PrinterController(new DellPrinter());
        hpprinterController.print();
        dellprinterController.print();
    }

}
