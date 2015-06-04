package com.academy.concurrency.cookbook.examples.collections;

import com.academy.concurrency.cookbook.examples.collections.logTest.AddElementTask;
import com.academy.concurrency.cookbook.examples.collections.logTest.PollElementsTask;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class App {

    static class A  {

        static final  B b = new B();
    }

    static class B {
        static final A a = new A();
    }

    public static void main(String[] args) throws Exception {

        /*Random random = new Random();

        int size = 10;

        int array[] = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }

        long startTime = System.nanoTime();
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length; j++) {
                if(array[j] > array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime);
        System.out.println("BUBBLE SORT: " + executionTime);

        int array2[] = new int[size];
        for(int i = 0; i < size; i++) {
            array2[i] = random.nextInt(size);
        }
        startTime = System.nanoTime();
        Arrays.sort(array2);
        endTime = System.nanoTime();
        executionTime = (endTime - startTime);
        System.out.println("ARRAYS.SORT: " + executionTime);
        int array3[] = new int[size];
        for(int i = 0; i < size; i++) {
            array3[i] = random.nextInt(size);
        }
        startTime = System.nanoTime();
        int left = 0;
        int right = array3.length - 1;
        for(int i = 0; i < array3.length; i++) {

            for (int j = left+1; j < right; j++) {
                if (array3[j] > array3[left]) {
                    int temp = array3[left];
                    array3[left] = array3[j];
                    array3[j] = temp;
                }
                if (array3[j] < array3[right]) {
                    int temp = array3[right];
                    array3[right] = array3[j];
                    array3[j] = temp;
                }
            }

            left++;
            right--;
        }
        endTime = System.nanoTime();
        executionTime = (endTime - startTime);
        System.out.println("DOUBLE BUBBLE: " + executionTime);
*/
        /*startTime = System.nanoTime();
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length; j++) {
                if(array[j] > array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        endTime = System.nanoTime();
        executionTime = (endTime - startTime);
        System.out.println("BUBBLE: " + executionTime);*/

       /* for(int i : array) {
            System.out.println(i);
        }

        for(int i : array2) {
            System.out.println(i);
        }
*/
        /*for(int i : array3) {
            System.out.println(i);
        }*/

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                new A();
            }
        }).start();
        new B();
        System.out.println("ASD");*/

        // CHAPTER 6

        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
        final Object monitor = new Object();
        AtomicBoolean storing = new AtomicBoolean(false);
        Thread threads[] = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            AddElementTask task = new AddElementTask(list, storing, monitor);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        PollElementsTask task = new PollElementsTask(list, storing, monitor);
        Thread thread = new Thread(task);
        thread.start();

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();

        Thread threads[] = new Thread[5000];
        for (int i = 0; i < threads.length; i++) {
            AddElementWithSizeTask task = new AddElementWithSizeTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        PollElementsWithSizeTask task = new PollElementsWithSizeTask(list);
        Thread thread = new Thread(task);
        thread.start();

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        /*List<String> list = new LinkedList<String>();
        final Object monitor = new Object();

        Thread threads[] = new Thread[5000];
        for (int i = 0; i < threads.length; i++) {
            SynchronizedAddElementTask task = new SynchronizedAddElementTask(list, monitor);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        SynchronizedPollElementsTask task = new SynchronizedPollElementsTask(list, monitor);
        Thread thread = new Thread(task);
        thread.start();

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        /*ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();

        Thread threads[]=new Thread[100];

        for (int i=0; i<threads.length ; i++){
            AddTask task=new AddTask(list);
            threads[i]=new Thread(task);
            threads[i].start();
        }
        System.out.printf("App: %d AddTask threads have been launched\n",threads.length);

        for (int i=0; i<threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("App: Size of the List: %d\n",list.size());

        for (int i=0; i< threads.length; i++){
            PollTask task=new PollTask(list);
            threads[i]=new Thread(task);
            threads[i].start();
        }
        System.out.printf("App: %d PollTask threads have been launched\n",threads.length);

        for (int i=0; i<threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("App: Size of the List: %d\n",list.size());*/

        /*LinkedBlockingDeque<String> list=new LinkedBlockingDeque<>(3);

        Client client=new Client(list);
        Thread thread=new Thread(client);
        thread.start();

        for (int i=0; i<5 ; i++) {
            for (int j=0; j<3; j++) {
                String request=list.take();
                System.out.printf("App: Request: %s at %s. Size: %d\n",request,new Date(),list.size());
            }
            TimeUnit.MILLISECONDS.sleep(300);
        }

        System.out.printf("App: End of the program.\n");*/

        /*PriorityBlockingQueue<Event> queue=new PriorityBlockingQueue<>();
        Thread taskThreads[]=new Thread[5];
        for (int i=0; i<taskThreads.length; i++){
            Task task=new Task(i,queue);
            taskThreads[i]=new Thread(task);
        }
        for (int i=0; i<taskThreads.length ; i++) {
            taskThreads[i].start();
        }
        for (int i=0; i<taskThreads.length ; i++) {
            try {
                taskThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("App: Queue Size: %d\n",queue.size());
        for (int i=0; i<taskThreads.length*1000; i++){
            Event event=queue.poll();
            System.out.printf("Thread %s: Priority %d\n",event.
                    getThread(),event.getPriority());
        }

        System.out.printf("App: Queue Size: %d\n",queue.size());
        System.out.printf("App: End of the program\n");*/

        /*DelayQueue<Event> queue=new DelayQueue<>();
        Thread threads[]=new Thread[5];
        for (int i=0; i<threads.length; i++){
            Task task=new Task(i+1, queue);
            threads[i]=new Thread(task);
        }
        for (int i=0; i<threads.length; i++) {
            threads[i].start();
        }
        for (int i=0; i<threads.length; i++) {
            threads[i].join();
        }
        do {
            int counter=0;
            Event event;
            do {
                event=queue.poll();
                if (event!=null) counter++;
            } while (event!=null);
            System.out.printf("At %s you have read %d events\n",new
                    Date(),counter);
            TimeUnit.MILLISECONDS.sleep(500);
        } while (queue.size()>0);*/

        /*ConcurrentSkipListMap<String, Contact> map;
        map = new ConcurrentSkipListMap<>();

        Thread threads[] = new Thread[25];
        int counter = 0;

        for (char i = 'A'; i < 'Z'; i++) {
            Task task = new Task(map, String.valueOf(i));
            threads[counter] = new Thread(task);
            threads[counter].start();
            counter++;
        }

        for (int i = 0; i < 25; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("App: Size of the map: %d\n", map.size());
        Map.Entry<String, Contact> element;
        Contact contact;
        element = map.firstEntry();
        contact = element.getValue();
        System.out.printf("App: First Entry: %s: %s\n", contact.
                getName(), contact.getPhone());

        element = map.lastEntry();
        contact = element.getValue();
        System.out.printf("App: Last Entry: %s: %s\n", contact.
                getName(), contact.getPhone());

        System.out.printf("App: Submap from A1996 to B1002: \n");
        ConcurrentNavigableMap<String, Contact> submap = map.
                subMap("A1996", "B1002");
        do {
            element = submap.pollFirstEntry();
            if (element != null) {
                contact = element.getValue();
                System.out.printf("%s: %s\n", contact.getName(), contact.
                        getPhone());
            }
        } while (element != null);*/

        /*Thread threads[]=new Thread[3];
        for (int i=0; i<3; i++) {
            TaskLocalRandom task=new TaskLocalRandom();
            threads[i]=new Thread(task);
            threads[i].start();
        }*/

        /*Account account=new Account();
        account.setBalance(1000);

        Company company=new Company(account);
        Thread companyThread=new Thread(company);
        Bank bank=new Bank(account);
        Thread bankThread=new Thread(bank);

        System.out.printf("Account : Initial Balance: %d\n",account.
                getBalance());

        companyThread.start();
        bankThread.start();

        try {
            companyThread.join();
            bankThread.join();
            System.out.printf("Account : Final Balance: %d\n",account.
                    getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }

}
