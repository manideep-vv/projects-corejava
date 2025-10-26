package org.ampf;

public class JoinMethodDemo {

    public static void main(String[] args) throws InterruptedException {
         // untill i called start() method thread is in new state
        System.out.println("main thread started ");
        Thread t=new Thread(new Runner1());
        Thread t1=new Thread(new Runner2());
        Thread t2=new Thread(new Runner3());
        t2.setDaemon(true);
        t.start();
        t1.start();
        t2.start();

        t1.join();
        System.out.println("main thread finished");

    }
}

class Runner1 implements Runnable{
    @Override
    public void run() {
        for (int j = 0; j < 20 ; j++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("\n Running %s : %d ",Thread.currentThread().getName(),j);
        }
    }
}
class Runner2 implements Runnable{
    @Override
    public void run() {
        for (int j = 0; j < 100 ; j++) {
            System.out.printf("\n Running %s : %d ",Thread.currentThread().getName(),j);
        }
    }
}

class Runner3 implements Runnable{
    @Override
    public void run() {
        for (int j = 0; j < 100 ; j++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("\n Running %s : %d ",Thread.currentThread().getName(),j);
        }
    }
}
