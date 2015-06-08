package com.academy.patterns.objectpool;

/**
 * Created by Kelheor on 07.06.2015.
 */
public class App {

    public static void main(String[] args) {

        // Пул объектов позволяет переиспользовать уже созданные объекты, вместо создания новых

        WorkerPool workerPool = new WorkerPool();
        Worker worker = workerPool.checkout();
        Worker worker2 = workerPool.checkout();
        System.out.println(workerPool);
        workerPool.checkin(worker2);
        System.out.println(workerPool);
        workerPool.checkin(worker);
        System.out.println(workerPool);
    }
}
