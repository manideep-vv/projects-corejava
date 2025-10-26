package org.example.compFuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class WaitForAllParallelTasksComplThenRunLastTask {
    public static void main(String[] args) {
        RunLastTaskOnceAll4TasksAreCompleted();


    }

    private static void RunLastTaskOnceAll4TasksAreCompleted() {
        Supplier<String> supplier1 = () -> {
            System.out.println("executing 1st task");
            System.out.println(10/0);
            delay(5);
            System.out.println("completed 1st task");
            return "Web svc1 output--";
        };
        Supplier<String> supplier2 = () -> {
           System.out.println("executing 2nd task");
           delay(5);
           System.out.println("completed 2nd task");
           return "Web svc 2 output--";
       };
        Supplier<String> supplier3 = () -> {
           System.out.println("executing 3rd task");
           delay(5);
           System.out.println("completed 3rd task");
           return "Web svc 3 output--";
       };

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(supplier1);
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(supplier2);
        CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(supplier3);

        Runnable r=()->{
            System.out.println("i am the last task -- the end --");
            System.out.println("ws1 output "+cf1.join());
            System.out.println("ws2 output "+cf2.join());
            System.out.println("ws3 output "+cf3.join());
        };

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(cf1,cf2,cf3);
        voidCompletableFuture.thenRun(r);

        voidCompletableFuture.join();
        System.out.println("now all cf are complete");
    }

    public static void delay(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
