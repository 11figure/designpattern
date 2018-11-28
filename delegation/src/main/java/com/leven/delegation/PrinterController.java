package com.leven.delegation;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:40 2018/8/12
 * @Modified By:
 */
public class PrinterController implements Printer2 {

    Printer2 printer;

    public PrinterController(Printer2 printer) {
        this.printer = printer;
    }

    @Override
    public void print() {
        printer.print();
    }
}
