package org.example.streams;

import org.example.dto.Employee;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GroupBy {
    public static void main(String[] args) {
        Map<String, List<Employee>> collect = Employee.getData().stream().collect(Collectors.groupingBy((e) -> e.getName()));
        System.out.println(collect);
        Employee.getData().stream().collect(Collectors.groupingBy(e->e.getCityName(), TreeMap::new,Collectors.toSet()));
        List<Employee> distinct = Employee.getData().stream().distinct().collect(Collectors.toList());
        System.out.println("distinct ele are "+distinct);
    }
}
