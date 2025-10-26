package org.example.streams;

import org.example.pojo.Employee;

import java.util.OptionalInt;
import java.util.stream.Stream;

public class ReducePractice {

    public static void main(String[] args) {
//        maxEleWithReduce();
//        minEleWithReduce();
        addEleWithReduce();
    }
    public static void maxEleWithReduce() {
        Stream<Employee> emps = StreamsPrac.getEmpAsStream();
        System.out.println("max value is "+emps.mapToInt(e->e.getSalary())
                .reduce((e1,e2)->e1>e2?e1:e2).getAsInt());
    }
    public static void addEleWithReduce() {
        Stream<Employee> emps = StreamsPrac.getEmpAsStream();
        OptionalInt reduce = emps.mapToInt(Employee::getSalary).reduce((e1, e2) -> e1 + e2);
        System.out.println("add operation is performed with reduce() method"+reduce.getAsInt());

    }
    public static void minEleWithReduce() {
        Stream<Employee> emps = StreamsPrac.getEmpAsStream();
        OptionalInt min = emps.mapToInt(e -> e.getSalary()).reduce((e1, e2) -> {
            if (e1 < e2) {
                System.out.println("in if condition");
                return e1;
            } else {
                System.out.println("in else condition");
                return e2;
            }
        });
        System.out.println("min ele with reduce() is "+min.getAsInt());

    }
}
