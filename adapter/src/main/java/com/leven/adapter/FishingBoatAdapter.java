package com.leven.adapter;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:08 2018/7/11
 * @Modified By:
 */
public class FishingBoatAdapter implements RowingBoat{

    private FisingBoat fisingBoat;

    public FishingBoatAdapter() {
        this.fisingBoat = new FisingBoat();
    }


    public void row() {
        fisingBoat.sail();
        System.out.println("com.leven.adapter.FishingBoatAdapter row");
    }
}
