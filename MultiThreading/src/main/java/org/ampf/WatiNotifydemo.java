package org.ampf;

public class WatiNotifydemo {

    public void produce() throws InterruptedException {
        System.out.println("produce method is being executed by" + Thread.currentThread().getName());
        synchronized (this) {
            System.err.println("in producer method s-1");
            wait();
            System.err.println("in producer method s-2");
            System.err.println("in producer method s-3");
            System.err.println("in producer method s-4");
        }
    }

    public void consume() throws InterruptedException {
        System.out.println("consume method is being executed by" + Thread.currentThread().getName());
        Thread.sleep(1000);
        synchronized (this) {
            System.out.println("in consumer method s-1");
            System.out.println("in consumer method s-2");
            notify();
            System.out.println("in consumer method s-3");
            Thread.sleep(8000);
            System.out.println("in consumer method s-4");

        }
    }

    public static void main(String[] args) throws InterruptedException {
        WatiNotifydemo notifydemo = new WatiNotifydemo();
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
