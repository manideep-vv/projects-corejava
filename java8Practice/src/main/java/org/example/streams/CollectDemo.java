package org.example.streams;

import org.example.pojo.Employee;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectDemo {
    public static void main(String[] args) {

        StringBuilder collect = getNamesAsStream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(collect);// flow
        print(getNamesAsStream().collect(Collectors.joining()));// omsairam
        print(getNamesAsStream().collect(Collectors.joining("-")));// om-sai-ram
        print(getNamesAsStream().collect(Collectors.joining("-","(",")"))); //(om-sai-ram)
        mapingByDemo();
        maxByDemo();
        minByDemo();
        summingInt();
        averagingInt();
    }
    public void toCollectionDemo(){
        LinkedList<Integer> collect = Stream.iterate(1, e -> e + 1).limit(50)
                .collect(Collectors.toCollection(LinkedList::new));


    }

    private static Stream<String> getNamesAsStream() {
        return Stream.of("om", "sai", "ram");
    }
    public static void  print(Object o){
        System.out.println(o);
    }
    public static void mapingByDemo(){
        print(StreamsPrac.getEmpAsStream().map(Employee::getEmpName).collect(Collectors.toList())); //[Mani, Sai, Santu]
        print(StreamsPrac.getEmpAsStream().collect(Collectors.mapping(Employee::getEmpName,Collectors.toList()))); //[Mani, Sai, Santu]
    }

    public static void maxByDemo() {
        //Both below returns same whereas max(Comparator c) is best
        print("min value is " + StreamsPrac.getEmpAsStream().collect(Collectors.minBy(Comparator.comparing(Employee::getSalary))));
        print("min value is " + StreamsPrac.getEmpAsStream().min(Comparator.comparing(Employee::getSalary)));
    }

    public static void minByDemo() {
        //Both below returns same whereas min(Comparator c) is best
        print("min value is " + StreamsPrac.getEmpAsStream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        print("min value is " + StreamsPrac.getEmpAsStream().max(Comparator.comparing(Employee::getSalary)));
    }
  public static void summingInt() {
        //Both below returns same whereas min(Comparator c) is best
        print("sum value is " + StreamsPrac.getEmpAsStream().collect(Collectors.summingInt(Employee::getSalary))); //sum value is 2800
        print("sum value is " + StreamsPrac.getEmpAsStream().mapToInt(Employee::getSalary).sum()); //sum value is 2800
    }
 public static void averagingInt() {
        //Both below returns same whereas min(Comparator c) is best
        print("avg value is " + StreamsPrac.getEmpAsStream().collect(Collectors.averagingInt(Employee::getSalary)).doubleValue()); //700
        print("avg value is " + StreamsPrac.getEmpAsStream().mapToInt(Employee::getSalary).average()); //700
    }


}
