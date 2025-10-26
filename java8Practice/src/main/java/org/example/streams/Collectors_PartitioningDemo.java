package org.example.streams;

import org.example.pojo.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Collectors_PartitioningDemo {
    public static void main(String[] args) {
//        partitioningWith1Param();
//        partitioningWith2Param();
//        partitioningWith2ParamAndCouting();
//        partitioningWithSummingInt();
        partitioningWithMapping();

    }
    public static void partitioningWith1Param() {
        Predicate<Student> predicate=(p)->"male".equalsIgnoreCase(p.getGender());
        Map<Boolean, List<Student>> collect = StudentDataBase.getAllStudentsAsStream().collect(Collectors.partitioningBy(predicate));
        System.out.println(collect);
    }
    public static void partitioningWith2Param(){
        Predicate<Student> predicate=(p)->"male".equalsIgnoreCase(p.getGender());
        Map<Boolean, Optional<Student>> collect = StudentDataBase.getAllStudentsAsStream().collect(Collectors.partitioningBy(
                predicate, Collectors.maxBy(Comparator.comparing(Student::getGpa))
        ));
        System.out.println(collect);
    }  public static void partitioningWith2ParamAndCouting(){
        Predicate<Student> predicate=p-> p.getGender().equalsIgnoreCase("male");

        Map<Boolean, Long> collect = StudentDataBase.getAllStudents().stream().collect(Collectors.partitioningBy(
                predicate, Collectors.counting()
        ));
        System.out.println(collect);
    }

    public static void partitioningWithSummingInt(){
        Predicate<Student> predicate = p-> p.getGender().equalsIgnoreCase("male");
        ToIntFunction<Student> function= s->s.getNoteBooks();
        Map<Boolean, Integer> genderWiseNoteBooks = StudentDataBase.getAllStudents().stream().collect(
                Collectors.partitioningBy(predicate, Collectors.summingInt(function))
        );
        System.out.println(genderWiseNoteBooks);
    }
    public static void partitioningWithMapping(){
        Predicate<Student> predicate = p-> p.getGender().equalsIgnoreCase("male");

        Map<Boolean, List<String>> genderWiseNames = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.partitioningBy(predicate,
                        Collectors.mapping(e -> e.getName(), Collectors.toList())));
        System.out.println(genderWiseNames);
    }

}
