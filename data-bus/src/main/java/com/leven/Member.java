package com.leven;

import java.util.function.Consumer;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:35 2018/8/28
 * @Modified By:
 */
public interface Member extends Consumer<DataType>{
    public void accept(DataType event);
}
