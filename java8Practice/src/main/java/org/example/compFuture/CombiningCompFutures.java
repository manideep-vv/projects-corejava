package org.example.compFuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CombiningCompFutures {
    public void run2TasksParallelOnceBothcompThenRun3rdTask(){
            Supplier<String> supplier1= ()->{
                System.out.println("executing 1st task");
                delay(5);
                System.out.println("completed 1st task");
                return "Web svc1 output--";
            };
            Supplier<String> supplier2= ()->{
                System.out.println("executing 2nd task");
                delay(5);
                System.out.println("completed 2nd task");
                return "Web svc2 output--";
            };
            CompletableFuture<String> webSvc1=CompletableFuture.supplyAsync(supplier1);
            CompletableFuture<String> webSvc2=CompletableFuture.supplyAsync(supplier2);
            BiFunction<String, String, String> biFunction = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
            String join = webSvc1.thenCombine(webSvc2, biFunction).join();
            System.out.println("final output is "+join);
        }

        public static void main(String[] args) {
            CombiningCompFutures c=new CombiningCompFutures();
//            c.run2TasksParallelOnceBothcompThenRun3rdTask();
            c.run4TasksParallellyOnceBothCompThenRun5thTask();
    }

    public void run4TasksParallellyOnceBothCompThenRun5thTask() {
        Supplier<String> supplier1 = () -> {
            System.out.println("executing 1st task");
            delay(5);
            System.out.println("completed 1st task");
            return "Web svc1 output--";
        };
        Supplier<String> supplier2 = () -> {
            System.out.println("executing 2nd task");
            delay(5);
            System.out.println("completed 2nd task");
            return "Web svc2 output--";
        };
        Supplier<String> supplier3 = () -> {
            System.out.println("executing 3rd task");
            delay(5);
            System.out.println("completed 3rd task");
            return "Web svc3 output--";
        };
        Supplier<String> supplier4 = () -> {
            System.out.println("executing 4th task");
            delay(5);
            System.out.println("completed 4th task");
            return "Web svc4 output--";
        };
        CompletableFuture<String> webSvc1 = CompletableFuture.supplyAsync(supplier1);
        CompletableFuture<String> webSvc2 = CompletableFuture.supplyAsync(supplier2);
        CompletableFuture<String> webSvc3 = CompletableFuture.supplyAsync(supplier3);
        CompletableFuture<String> webSvc4 = CompletableFuture.supplyAsync(supplier4);

        BiFunction<String, String, String> biFunction = (e1, e2) -> e1.toUpperCase() + e2.toUpperCase();
        Consumer<String> consumeAndInsertIntoDb=(e)-> System.out.println("final combined output of all 4 futures is"+e);
       webSvc1.thenCombine(webSvc2, biFunction)
                .thenCombine(webSvc3, biFunction)
                .thenCombine(webSvc4, biFunction)
               .thenAccept(consumeAndInsertIntoDb).join();
    }
    public void run3TasksParallellyOnceBothCompThenRun4thTask(){

    }

    public static void delay(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
