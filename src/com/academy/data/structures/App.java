package com.academy.data.structures;

/**
 * Created by keos on 15.06.15.
 */
public class App {
    public static void main(String[] args) {

        // Binary heap test
        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>();
        binaryHeap.insert(1);
        binaryHeap.insert(100);
        binaryHeap.insert(1000);
        System.out.println(binaryHeap.poll());
        System.out.println(binaryHeap.poll());
        System.out.println(binaryHeap.poll());
    }
}
