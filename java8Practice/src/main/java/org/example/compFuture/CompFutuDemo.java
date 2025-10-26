package org.example.compFuture;

import java.util.concurrent.CompletableFuture;

public class CompFutuDemo {
    public static Integer invokeDb(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("db interaction completed and got result , current thread is "+Thread.currentThread().getName());
        return 5;
    }

    public static Integer invokeRestAPI(){
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("RESTful api interaction completed and got result , current thread is "+Thread.currentThread().getName());
        return 5;
    }

    public static void main(String[] args) {
        CompletableFuture<Integer> cfDbAPI = CompletableFuture.supplyAsync(CompFutuDemo::invokeDb);
        CompletableFuture<Integer> cfRestAPI = CompletableFuture.supplyAsync(CompFutuDemo::invokeRestAPI);
//        cfRestAPI.thenCombine(cfDbAPI,(e1,e2)->{return e1+e2});

    }
}
