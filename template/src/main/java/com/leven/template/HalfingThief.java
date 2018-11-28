package com.leven.template;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 22:52 2018/8/10
 * @Modified By:
 */
public class HalfingThief {

    private StealingMethod thiefMethod;

    public HalfingThief(StealingMethod thiefMethod) {
        this.thiefMethod = thiefMethod;
    }

    public void steal() {
        thiefMethod.steal();
        String target = thiefMethod.pickTarget();
        thiefMethod.confuseTarget(target);
        thiefMethod.stealTheItem("gold");
    }

    public void changeMethod(StealingMethod thiefMethod) {
        this.thiefMethod = thiefMethod;
    }
}
