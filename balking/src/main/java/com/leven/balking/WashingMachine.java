package com.leven.balking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 22:47 2018/7/3
 * @Modified By:
 */
public class WashingMachine {

    public static final Logger LOGGER = LoggerFactory.getLogger(WashingMachine.class);
    private WashingMachineState washingMachineState;

    public WashingMachine() {
        this.washingMachineState = WashingMachineState.ENABLE;
    }

    public WashingMachineState getWashingMachineState() {
        return washingMachineState;
    }

    /**
     * Method responsible for washing
     * if the obj is in appropriate state
     */
    public void wash() {
        synchronized (this) {
            LOGGER.info("{}:Actual machine state:{}", Thread.currentThread().getName(),
                getWashingMachineState());
            if (WashingMachineState.WASHING.equals(washingMachineState)) {
                LOGGER.error("ERROR:Cannot wash if the machine has already been washing");
                return;
            }
            washingMachineState = WashingMachineState.WASHING;
        }
        LOGGER.info("{}:Doing the washing", Thread.currentThread().getName());
        try {
            Thread.sleep(50);
        } catch (Exception e) {
            e.printStackTrace();
        }
        endWashing();
    }

    /**
     * Method responsible of ending the washing
     * by changing machine state
     */
    private synchronized void  endWashing() {
        washingMachineState = WashingMachineState.ENABLE;
        LOGGER.info("{}:Washing complete.", Thread.currentThread().getId());
    }


}
