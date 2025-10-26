package org.example.compFuture;

import java.util.concurrent.CompletableFuture;

@Service
public class MyService {

    @Async
    public CompletableFuture<String> doTask() {
        // This runs in a separate thread (from the executor pool)
        try {
//            return CompletableFuture.completedFuture("Task done!");
            return new AsyncResult<>("Success");
        } catch (Exception e) {
        }
    }
}