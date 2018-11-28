package com.leven.adapter;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:12 2018/7/11
 * @Modified By:
 */
public class Captain {

    RowingBoat rowingBoat;

    public Captain() {
    }

    public Captain(RowingBoat rowingBoat) {
        this.rowingBoat = rowingBoat;
    }

    public void setRowingBoat(RowingBoat rowingBoat) {
        this.rowingBoat = rowingBoat;
    }

    public void row() {
        rowingBoat.row();
        System.out.println("com.leven.adapter.Captain ");
    }
}
