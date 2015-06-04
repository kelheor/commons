package com.academy.concurrency.cookbook.examples.synchronization;

public class App {

    public static void main(String[] args) {

        // CHAPTER 3

        /*PrintQueue printQueue = new PrintQueue();
        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread" + i);
        }
        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }*/

        /*VideoConference videoConference = new VideoConference(10);
        Thread threadConference = new Thread(videoConference);
        threadConference.start();
        for (int i = 0; i < 10; i++) {
            Participant p = new Participant(videoConference, "Participant " + i);
            Thread t = new Thread(p);
            t.start();
        }*/

        /*final int ROWS = 10000;
        final int NUMBERS = 1000;
        final int SEARCH = 5;
        final int PARTICIPANTS = 5;
        final int LINES_PARTICIPANT = 2000;

        MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);
        Results results = new Results(ROWS);
        Grouper grouper = new Grouper(results);
        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);

        Searcher searchers[] = new Searcher[PARTICIPANTS];
        for (int i = 0; i < PARTICIPANTS; i++) {
            searchers[i] = new Searcher(i * LINES_PARTICIPANT, (i * LINES_PARTICIPANT) + LINES_PARTICIPANT, mock, results, 5, barrier);
            Thread thread = new Thread(searchers[i]);
            thread.start();
        }
        System.out.printf("App: The main thread has finished.\n");*/

        /*Phaser phaser = new Phaser(3);
        FileSearch system = new FileSearch("C:\\Windows", "log",
                phaser);
        FileSearch apps =
                new FileSearch("C:\\Program Files", "log", phaser);
        FileSearch documents =
                new FileSearch("C:\\Documents And Settings", "log", phaser);

        Thread systemThread = new Thread(system, "System");
        systemThread.start();

        Thread appsThread = new Thread(apps, "Apps");
        appsThread.start();

        Thread documentsThread = new Thread(documents, "Documents");
        documentsThread.start();

        try {
            systemThread.join();
            appsThread.join();
            documentsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Terminated: " + phaser.isTerminated());*/

        /*MyPhaser phaser = new MyPhaser();
        Student students[] = new Student[5];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(phaser);
            phaser.register();
        }
        Thread threads[] = new Thread[students.length];
        for (int i = 0; i < students.length; i++) {
            threads[i] = new Thread(students[i], "Student " + i);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("App: The phaser has finished: %s.\n",phaser.isTerminated());*/

        /*List<String> buffer1 = new ArrayList<>();
        List<String> buffer2 = new ArrayList<>();

        Exchanger<List<String>> exchanger = new Exchanger<>();

        Producer producer = new Producer(buffer1, exchanger);
        Consumer consumer = new Consumer(buffer2, exchanger);

        Thread threadProducer = new Thread(producer);
        Thread threadConsumer = new Thread(consumer);
        threadProducer.start();
        threadConsumer.start();*/

    }
}
