package org.example.streams;

import org.example.pojo.CollegeStudent;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SortingDemo {
    public static void main(String[] args) {
        //sort using streams
        Comparator<CollegeStudent> comparator = Comparator.comparing(CollegeStudent::getName);
        List<CollegeStudent> collect = CollegeStudent.getCollegeStudents()
                .filter(e -> Objects.nonNull(e))
                .sorted(comparator).collect(Collectors.toList());
        System.out.println(collect);
        sortingWithNullsFirst();
    }

    public static void sortingWithNullsFirst() {
        Comparator<CollegeStudent> c1 = Comparator.comparing(CollegeStudent::getName);
        Comparator<CollegeStudent> compWithNullsFirst = Comparator.nullsFirst(c1);
        List<CollegeStudent> sortedWithNUllsFirst = CollegeStudent.getCollegeStudents().sorted(compWithNullsFirst).collect(Collectors.toList());
        System.out.println("sorting with nulls first"+sortedWithNUllsFirst);
    }
    public static void sortingWithoutNulls() {
        //sorting on list
        Comparator<CollegeStudent> comparator = Comparator.comparing(CollegeStudent::getName);

        List<CollegeStudent> collect1 = CollegeStudent.getCollegeStudents().collect(Collectors.toList());
        collect1.sort(comparator);
        System.out.println("sorted using list.sort-->" + collect1);
    }
}
