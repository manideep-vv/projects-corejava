package org.example.compFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Employee;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SupplyAsynThenAplycDemo {
    public static void main(String[] args) throws IOException {
        SupplyAsynThenAplycDemo supplyAsyncDemo = new SupplyAsynThenAplycDemo();
//        supplyAsyncDemo.thenRunDemo();
        supplyAsyncDemo.supply_thenApply_thenAcceptDemoV1();
    }

    public void thenApplyDemo(){
        Supplier<List<Employee>> supplier =()->{
            File file=new File("src/main/resources/employeesData.json");
            try {
                List<Employee> employees = new ObjectMapper().readValue(file, new TypeReference<List<Employee>>() {
                });
                return employees;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        Consumer<List<Employee>> consumer=(employees -> System.out.println(employees));
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(supplier).thenAccept(consumer);
        voidCompletableFuture.join();
    }

    /**
     * first execute task A, if that completes then run task B
     */
    public void thenRunDemo(){
        Runnable r1=()->{
            IntStream.range(1,10).forEach(e->{
                try {
                    System.err.println(String.format("Preparing dish --> %d by %s",e,Thread.currentThread().getName()));
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

            });
        };
        Runnable r2=()->{
            IntStream.range(1,5).forEach(e->{
                try {
                    System.out.println(String.format("packing dish --> %d by %s",e,Thread.currentThread().getName()));
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

            });
        };
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(r1).thenRun(r2);
        voidCompletableFuture.join();
    }


    public void supply_thenApply_thenAcceptDemo() throws IOException {

        Supplier<List<Employee>> supplier=()->{
            File file=new File("src/main/resources/employeesData.json");
            try {
                List<Employee> employees = new ObjectMapper().readValue(file, new TypeReference<List<Employee>>() {});
                System.out.println(String.format("Completely fetched all emp by %s",Thread.currentThread().getName()));
                return employees;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        Function<List<Employee>,List<Employee>> filterFunction=(list)->{
            List<Employee> existingEmployees = list.stream().filter(e -> {
                return "FALSE".equalsIgnoreCase(e.getNewJoiner()) ? true : false;
            }).collect(Collectors.toList());
            System.out.println(String.format("Completely filtered all emp by %s",Thread.currentThread().getName()));
            return existingEmployees;
        };

        List<Employee> allEmpls = CompletableFuture.supplyAsync(supplier).thenApply(filterFunction).join();
        System.out.println(allEmpls);

    }

    //we want mail ids of who is new joiner and who didnt complete training
    public void supply_thenApply_thenAcceptDemoV1() throws IOException {
        Supplier<List<Employee>> listSupplier = () -> {
            try {
                System.out.println(String.format("Completely fetched all emp by %s",Thread.currentThread().getName()));
                File file = new File("src/main/resources/employeesData.json");
                List<Employee> employees = new ObjectMapper().readValue(file, new TypeReference<List<Employee>>() {
                });
                return employees;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture
                .supplyAsync(listSupplier)
                .thenApplyAsync(list -> {
                    System.out.println(String.format("applyAsync() method running by %s", Thread.currentThread().getName()));
                    return list.stream().filter(emp -> {
                        return "TRUE".equalsIgnoreCase(emp.getNewJoiner()) && "TRUE".equalsIgnoreCase(emp.getLearningPending()) ? true : false;
                    }).collect(Collectors.toList());
                })
                .thenApplyAsync(list -> {
                    System.out.println(String.format("applyAsync() method running by %s", Thread.currentThread().getName()));
                    return list.stream().map(emp -> emp.getEmail()).collect(Collectors.toList());
                })
                .thenAccept(list -> {
                    System.out.println(String.format("thenAccept() method running by %s", Thread.currentThread().getName()));
                    System.out.println(list);
                });
        voidCompletableFuture.join();
        System.out.println("main thread waited for all tasks completion, now its resumed");

    }

    }
