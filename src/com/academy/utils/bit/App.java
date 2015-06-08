package com.academy.utils.bit;

/**
 * Created by keos on 05.06.15.
 */
public class App {

    public static void main(String[] args) {

        // array = {0,0,1} means bit sequence 100 or number 4.

        int i = 2;
        // array = {0,1} a[1] = 1;
        System.out.println(BitUtils.getByte(i, 1));

        // i[0] = 1; i = 3
        i = BitUtils.setBit(i, 0);
        System.out.println(i);

        // i[1] = 1; i = 1
        i = BitUtils.clearBit(i, 1);
        System.out.println(i);

        i = 5;
        // i = {1,0,1} -> i = {1,0,0}
        i = BitUtils.clearLefterBits(i, 1);
        System.out.println(i);

        i = 5;
        // i = {1,0,1} -> i = {0,0,1}
        i = BitUtils.clearRighterBits(i, 1);
        System.out.println(i);

        i = 5;
        // i = {1,0,1} -> i = {1,1,1}
        i = BitUtils.updateBit(i, 1, 1);
        System.out.println(i);

    }
}
