package com.academy.concurrency.cookbook.examples.executors;

public class App {

    public static void main(String[] args) {

        // CHAPTER 4

        /*Server server = new Server();
        for (int i = 0; i < 100; i++) {
            Task task = new Task("Task " + i);
            server.executeTask(task);
        }
        server.endServer();*/

       /* ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.
                newFixedThreadPool(2);
        List<Future<Integer>> resultList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Integer number = random.nextInt(10);
            FactorialCalculator calculator = new
                    FactorialCalculator(number);
            Future<Integer> result = executor.submit(calculator);
            resultList.add(result);
        }

        do {
            System.out.printf("App: Number of Completed Tasks: %d\n", executor.getCompletedTaskCount());
            for (int i = 0; i < resultList.size(); i++) {
                Future<Integer> result = resultList.get(i);
                System.out.printf("App: Task %d: %s\n", i, result.
                        isDone());
            }
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (executor.getCompletedTaskCount() < resultList.size());

        System.out.printf("App: Results\n");
        for (int i = 0; i < resultList.size(); i++) {
            Future<Integer> result = resultList.get(i);
            Integer number = null;
            try {
                number = result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.printf("App: Task %d: %d\n", i, number);
        }
        executor.shutdown();*/

        /*String username="test";
        String password="test";
        UserValidator ldapValidator=new UserValidator("LDAP");
        UserValidator dbValidator=new UserValidator("DataBase");

        TaskValidator ldapTask=new TaskValidator(ldapValidator,
                username, password);
        TaskValidator dbTask=new TaskValidator(dbValidator,username,password);

        List<TaskValidator> taskList=new ArrayList<>();
        taskList.add(ldapTask);
        taskList.add(dbTask);

        ExecutorService executor=(ExecutorService) Executors.
                newCachedThreadPool();
        String result;

        try {
            result = executor.invokeAny(taskList);
            System.out.printf("App: Result: %s\n",result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        System.out.printf("App: End of the Execution\n");*/

    }
}
