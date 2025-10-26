package org.ampf;

public class SyncDemo {
     int x=0;

    public void increment(){
        System.out.println(Thread.currentThread().getName()+" Entered ");
        ++x;
        System.out.println(Thread.currentThread().getName()+" Exited ");
    }

    public synchronized static void main(String[] args) throws InterruptedException {
        SyncDemo syncDemo = new SyncDemo();
        Thread t1=new Thread(()->{
            try {
                for (int i = 0; i <2000 ; i++) {
                Thread.sleep(10);
                    syncDemo.increment();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        Thread t2=new Thread(()->{
            try {
                for (int i = 0; i <2000 ; i++) {
                    Thread.sleep(90);
                    syncDemo.increment();
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.printf("Final global variable val is %d",syncDemo.x);
    }
}
