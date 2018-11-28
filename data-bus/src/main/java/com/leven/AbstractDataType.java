package com.leven;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:30 2018/8/28
 * @Modified By:
 */
public abstract class AbstractDataType implements DataType {

    private DataBus dataBus;

    public DataBus getDataBus() {
        return dataBus;
    }

    public void setDataBus(DataBus dataBus) {
        this.dataBus = dataBus;
    }
}
