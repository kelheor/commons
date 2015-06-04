package com.academy.concurrency.batch;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by rnazirov on 22.05.2015.
 */
public enum BatchInserter {

    INSTANCE;

    private final Object monitor = new Object();

    private ArrayList<Message> batch = new ArrayList<Message>();
    private AtomicInteger count = new AtomicInteger(0);
    private volatile long firstTime;
    private final int waitInterval = 2500;
    private final int batchSize = 5000;

    private Map<String, Boolean> exceptionList = new HashMap<String, Boolean>();


    class Message {
        private Object object;
        private String objectId;

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }
    }

    public void batchInsert(Object object) throws Exception {
        try {
            if (count.incrementAndGet() != batchSize) {
                synchronized (monitor) {
                    // Создаем
                    Message batchMessage = new Message();
                    batchMessage.setObject(object);
                    batchMessage.setObjectId(UUID.randomUUID().toString());
                    exceptionList.put(batchMessage.getObjectId(), false);
                    batch.add(batchMessage);

                    // Ждем
                    monitor.wait(waitInterval);

                    // Если превышен интервал ожидания, то обрабатываем
                    if (System.currentTimeMillis() - firstTime > waitInterval) {
                        try {
                            process();
                        } catch (Exception e) {
                            for (Message m : batch) {
                                exceptionList.put(m.getObjectId(), true);
                            }
                            monitor.notifyAll();
                            throw new Exception("[BATCH] ERROR " + batchMessage.getObjectId());
                        }
                        return;
                    }

                    // Если возникла ошибка
                    if (exceptionList.get(batchMessage.getObjectId())) {
                        exceptionList.remove(batchMessage.getObjectId());
                        throw new Exception("[BATCH] ERROR " + batchMessage.getObjectId());
                    }

                    return;
                }
            } else {
                synchronized (monitor) {
                    // Создаем
                    Message batchMessage = new Message();
                    batchMessage.setObject(object);
                    batchMessage.setObjectId(UUID.randomUUID().toString());
                    exceptionList.put(batchMessage.getObjectId(), false);
                    batch.add(batchMessage);

                    // Обрабатываем
                    try {
                        process();
                    } catch (Exception e) {
                        for (Message m : batch) {
                            exceptionList.put(m.getObjectId(), true);
                        }
                        monitor.notifyAll();
                        throw new Exception("[BATCH] ERROR " + batchMessage.getObjectId());
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void process() throws Exception {

        // TODO: PROCESS HERE

        System.out.println("SIZE: " + batch.size());
        batch.clear();
        count.set(0);
        firstTime = System.currentTimeMillis();
        monitor.notifyAll();


    }
}
