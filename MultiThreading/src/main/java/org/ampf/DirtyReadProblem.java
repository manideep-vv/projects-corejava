package org.ampf;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DirtyReadProblem {
     int x = 0;

    Lock lock =new ReentrantLock(true);

    public synchronized void increment() {
        System.out.println("increment method exec started by "+Thread.currentThread().getName());
        lock.tryLock();
        try {
            for (int i = 0; i < 10000; i++) {
                ++x;
            }
        } finally {
            lock.unlock();
        }
        System.out.println("increment method exec ended by --> "+Thread.currentThread().getName());
    }

    public synchronized static void main(String[] args) throws InterruptedException {
        DirtyReadProblem syncDemo = new DirtyReadProblem();
        Thread t1 = new Thread(() -> {
            syncDemo.increment();
        });
        Thread t2 = new Thread(() -> {
            syncDemo.increment();
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.printf("Final global variable val is %d", syncDemo.x);
    }
}
