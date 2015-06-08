package com.academy.utils.bit;

/**
 * Created by keos on 05.06.15.
 */
public class BitUtils {

    /**
     * Return bit on position
     * @param num
     * @param position
     * @return
     */
    public static boolean getByte(int num, int position) {
        return ((num & (1 << position)) != 0);
    }

    /**
     * Sets bit on position to 1
     * @param num
     * @param position
     * @return
     */
    public static int setBit(int num, int position) {
        return num | (1 << position);
    }

    /**
     * Sets bit on position to 0
     * @param num
     * @param position
     * @return
     */
    public static int clearBit(int num, int position) {
        return num & (~(1 << position));
    }

    /**
     * If num = 5(101) and position = 1, then we have a result: 1
     * @param num
     * @param position
     * @return
     */
    public static int clearLefterBits(int num, int position) {
        return num & ((1 << position) - 1);
    }

    /**
     * If num = 5(101) and position = 3, then we have a result: 100
     * @param num
     * @param position
     * @return
     */
    public static int clearRighterBits(int num, int position) {
        return num & (~((1 << (position+1)) - 1));
    }

    /**
     * Sets bit on position to specified value
     * @param num
     * @param position
     * @param value
     * @return
     */
    public static int updateBit(int num, int position, int value) {
        return (num & (~(1 << position))) | (value << position);
    }
}
