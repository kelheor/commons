package com.academy.algorithms.sort;

import java.util.Random;

public class App {

    private static Random random = new Random();
    private static int arraySize = 10000;

    public static Integer[] getRandomIntArray(int arraySize) {
        Integer array[] = new Integer[arraySize];
        for(int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(arraySize);
        }
        return array;
    }

    public static void main(String[] args) throws Exception {

        for(SortService sortService : SortService.values()) {
            sortService.sort(getRandomIntArray(arraySize));
        }
    }

}
