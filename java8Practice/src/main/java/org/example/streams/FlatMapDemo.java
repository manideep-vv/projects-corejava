package org.example.streams;

import org.example.pojo.Employee;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapDemo {
    public static void main(String[] args) {
        Stream<Employee> emps = StreamsPrac.getEmpAsStream();
        List<String> collect = emps
                .map(Employee::getHobbies)//map takes 1 ele and returns 1 ele
                .flatMap(e -> e.stream()) // flatmap takes 1 ele returns only stream
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
