package com.academy.concurrency.cookbook.examples.forkjoin;

public class App {

    public static void main(String[] args) {

        // CHAPTER 5

        /*Document mock=new Document();
        String[][] document= mock.generateDocument(100, 1000, "the");

        DocumentTask task=new DocumentTask(document, 0, 100, "the");
        ForkJoinPool pool=new ForkJoinPool();
        pool.execute(task);
        do {
            System.out.printf("******************************************\n");
                    System.out.printf("App: Parallelism: %d\n",pool.
                            getParallelism());
            System.out.printf("App: Active Threads: %d\n",pool.
                    getActiveThreadCount());
            System.out.printf("App: Task Count: %d\n",pool.
                    getQueuedTaskCount());
            System.out.printf("App: Steal Count: %d\n",pool.
                    getStealCount());
            System.out.printf("******************************************\n");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!task.isDone());
        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.printf("App: The word appears %d in the document",task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }*/

        /*ForkJoinPool pool = new ForkJoinPool();
        FolderProcessor system = new FolderProcessor("C:\\Windows",
                "log");
        FolderProcessor apps = new
                FolderProcessor("C:\\Program Files", "log");
        FolderProcessor documents = new FolderProcessor("C:\\Documents And Settings", "log");
        pool.execute(system);
        pool.execute(apps);
        pool.execute(documents);

        do {
            System.out.printf("******************************************\n");
            System.out.printf("App: Parallelism: %d\n", pool.
                    getParallelism());
            System.out.printf("App: Active Threads: %d\n", pool.
                    getActiveThreadCount());
            System.out.printf("App: Task Count: %d\n", pool.
                    getQueuedTaskCount());
            System.out.printf("App: Steal Count: %d\n", pool.
                    getStealCount());
            System.out.printf("******************************************\n");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while ((!system.isDone()) || (!apps.isDone()) || (!documents.
                isDone()));

        pool.shutdown();
        List<String> results;
        results=system.join();
        System.out.printf("System: %d files found.\n",results.size());
        results=apps.join();
        System.out.printf("Apps: %d files found.\n",results.size());
        results=documents.join();
        System.out.printf("Documents: %d files found.\n",results.
                size());*/


    }

}
