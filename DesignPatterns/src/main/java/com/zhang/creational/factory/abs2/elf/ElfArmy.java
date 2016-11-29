package com.zhang.creational.factory.abs2.elf;

import com.zhang.creational.factory.abs2.AbsArmy;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class ElfArmy extends AbsArmy {

    public static final int NUMBER = 12000;

    public ElfArmy() {
        number = NUMBER;
    }

    @Override
    public String toString() {
        return "ElfArmy{" +
                "number=" + number +
                '}';
    }

}