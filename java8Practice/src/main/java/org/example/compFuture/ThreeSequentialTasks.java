package org.example.compFuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ThreeSequentialTasks {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Manideep";
        Function<String, String> f = (str) -> {
            System.out.println("in 2nd stage function");
            delay(3);
            return str.toUpperCase();
        };
        Consumer<String> consumer = (str) -> {
            delay(2);
            System.out.println(str);
        };

   CompletableFuture.supplyAsync(supplier)
                .thenApply(f)
                .thenAccept(consumer)
                .join();


    }

    public static void delay(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
