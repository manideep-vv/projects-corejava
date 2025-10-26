package org.example.compFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Employee;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RunAsyncDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        Runnable runnable = () -> {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                File file = new File("sampleJsonDataEmployees.json");
                List<Employee> employees =
                        objectMapper.readValue(file, new TypeReference<List<Employee>>() {
                        });
                employees.stream().forEach(System.out::println);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(runnable);
        voidCompletableFuture.get();
        System.out.println("compl future done");

    }
}
