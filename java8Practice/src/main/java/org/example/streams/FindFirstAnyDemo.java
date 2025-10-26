package org.example.streams;

import org.example.pojo.Employee;

import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindFirstAnyDemo {
    public static void main(String[] args) {
        Optional<Employee> any = StreamsPrac.getEmpAsStream()
                .filter(e -> e.getSalary() > 150)
                .findAny();
        Optional<Employee> first = StreamsPrac.getEmpAsStream()
                .filter(e -> e.getSalary() > 150)
                .findFirst();
        System.out.printf("findAny output -->%s , findFirst output %s -->",any,first);

        Stream.iterate(2,e->e+2).limit(20).forEach(System.out::println);
        Random r=new Random();
        Stream.generate(()->r.nextInt()).limit(200).forEach(System.out::println);
        System.out.println("sum is "+IntStream.rangeClosed(1,10).sum());

    }
}
