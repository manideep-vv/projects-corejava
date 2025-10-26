package org.ampf;

public class ProducerConsumerUsingWait {
    int x = 0;

    public void produce() throws InterruptedException {
        System.out.println("produce method is being executed by --> " + Thread.currentThread().getName());
        for (int i = 0; i < 5; i++) {
            synchronized (this) {
//                System.err.println("executing producer start ");
                ++x;
                System.err.println("produced new value");
                wait();
//                System.err.println("executing producer start");
            }

        }
    }

    public void consume() throws InterruptedException {
        System.out.println("consume method is being executed by --> " + Thread.currentThread().getName());
        Thread.sleep(2000);
        for (int i = 0; i < 5; i++) {

            synchronized (this) {
                System.out.println("consumed value as --> "+x);
                notify();
            }
            Thread.sleep(1000);

        }
    }
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerUsingWait notifydemo = new ProducerConsumerUsingWait();
        Thread t1 = new Thread(() -> {
            try {
                notifydemo.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        Thread t2 = new Thread(() -> {
            try {
                notifydemo.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        t1.start();
        t2.start();
    }
}
