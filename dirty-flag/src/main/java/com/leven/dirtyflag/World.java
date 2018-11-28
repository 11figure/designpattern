package com.leven.dirtyflag;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:53 2018/9/3
 * @Modified By:
 */
public class World {

    private List<String> countries;
    private DataFetcher dataFetcher;

    public World() {
        this.countries = new ArrayList<>();
        this.dataFetcher = new DataFetcher();
    }


    public List<String> fetch() {
        List<String> data = dataFetcher.fetch();
        countries = data.isEmpty() ? countries : data;
        return countries;
    }
}
