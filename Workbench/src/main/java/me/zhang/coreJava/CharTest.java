package me.zhang.coreJava;

/**
 * Created by Zhang on 9/30/2017 10:17 AM.
 */
public class CharTest {

    public static void main(String[] args) {
        // Print out CJK Radicals Supplement characters
        for (int i = '\u2E80'; i <= '\u2EFF'; i++) {
            System.out.print((char) i);
            if (i % 10 == 0) {
                System.out.println();
            }
        }

        // *
        System.out.println();
        for (int i = 0; i < 20; i++) {
            System.out.print('\u002A');
        }
        System.out.println();

        // 张
        char zhang = '\u5F20';
        // 祥
        char xiang = '\u7965';
        // 东
        char dong = '\u4E1C';
        System.out.println(String.format("%c%c%c", zhang, xiang, dong));
    }

}
