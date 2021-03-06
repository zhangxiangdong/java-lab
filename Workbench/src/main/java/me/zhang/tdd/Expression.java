package me.zhang.tdd;

/**
 * Created by zhangxiangdong on 2017/3/1.
 */
public interface Expression {

    Money reduce(Bank bank, String to);

    Expression plus(Expression addend);

    Expression times(int multiplier);

}
