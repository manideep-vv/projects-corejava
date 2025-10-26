package org.example.compFuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;



public class HandlingExceptionsUsingHandle {
    public static void main(String[] args) {
        cfgExceptionForEveryStage();

    }

    private static void cfgExceptionForEveryStage() {
        Supplier<String> s1 = () -> {
            delay(5);
            System.out.println("executing t1 after 5 sec");
            System.out.println(10 / 0);
            System.out.println("line after exception arrival");
            return "s1";
        };
        Function<String, String> s2 = (e) -> {
            delay(5);
            System.out.println("executing t2 after 5 sec and prev task output is  -->" + e);
//            System.out.println(10 / 0);
            System.out.println("line after exception arrival");
            return "successful task-2";
        };


        Consumer<String> runnable = (data) -> {
            System.out.println(" completed task 3 and prev task output is-->" + data);
        };
        CompletableFuture<Void> cfLast = CompletableFuture.supplyAsync(s1)
                //here this exceptionally block is only for 1st stage
                .exceptionally(e -> {
                    System.out.println("exception arrived in 1st task" + e);
                    return "Failed Task -t1";
                })
                .thenApply(s2)
                //all exceptionally blocks are only stage specific
                .handle((originalData,exception) -> {
                    if(exception!=null){
                    System.out.println("got exception in 2nd tasks ");
                        return "Task-2 failed";
                    }else {
                        return originalData.toUpperCase();
                    }
                })
                .thenAccept(runnable);

        System.out.println("main method over , just waiting for 10 sec");
        delay(10);
        System.out.println("Cf output is " + cfLast.join());
    }

    public static void delay(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
