package org.example.streams;

import org.example.pojo.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortDemo {
    public static void main(String[] args) {
        List<Employee> collect = StreamsPrac.getEmpAsStream()
                .sorted(Comparator.comparing(e->e.getSalary()))
//                .sorted(Comparator.comparing(Employee::getSalary))
//                .sorted((e1,e2)->e1.getSalary()-e2.getSalary())
//                .sorted(Comparator.comparingInt(Employee::getSalary))

                .collect(Collectors.toList());

        System.out.println(collect);
    }
}
