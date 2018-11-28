package com.leven;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:33 2018/8/28
 * @Modified By:
 */
public class DataBus {

    public static final DataBus INSTANCE = new DataBus();
    private final Set<Member> listeners = new HashSet<>();

    public static DataBus getInstance() {
        return INSTANCE;
    }

    public void subscribe(final Member member) {
        this.listeners.add(member);
    }

    public void unscribe(final Member member){
        this.listeners.remove(member);
    }


    public void publish(DataType event) {
        event.setDataBus(this);
        listeners.forEach(listener -> listener.accept(event));
    }
}


