package com.leven.strategyenum;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 22:51 2018/7/1
 * @Modified By:
 */
public class Calculator {

    public StrategyEnum stategy;

    public int caculate(int x, int y) {
        return stategy.caculate(x,y);
    }

    public void setStategy(StrategyEnum stategy) {
        this.stategy = stategy;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setStategy(StrategyEnum.A);
        System.out.println(calculator.caculate(1, 2));
        calculator.setStategy(StrategyEnum.B);
        System.out.println(calculator.caculate(1, 2));

    }
}
