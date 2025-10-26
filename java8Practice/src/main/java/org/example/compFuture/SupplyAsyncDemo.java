package org.example.compFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Employee;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class SupplyAsyncDemo {
    public static void main(String[] args) {

        Supplier<List<Employee>> supplier=()->{
            ObjectMapper mapper=new ObjectMapper();
            File file = Paths.get("src/main/resources/employeesData.json").toFile();
            try {
                return mapper.readValue(file, new TypeReference<List<Employee>>() {});
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        CompletableFuture<List<Employee>> listCompletableFuture = CompletableFuture.supplyAsync(supplier);
        List<Employee> empList = listCompletableFuture.join();
        empList.stream().forEach(System.out::println);

    }
}
