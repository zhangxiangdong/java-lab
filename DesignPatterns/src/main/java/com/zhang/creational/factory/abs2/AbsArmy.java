package com.zhang.creational.factory.abs2;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public abstract class AbsArmy implements Army {
    protected int number;

    @Override
    public int getNumber() {
        return number;
    }
}