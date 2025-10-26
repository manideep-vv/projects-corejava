package org.example.streams;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreams {
    public static void main(String[] args) {



        System.out.println(IntStream
                .rangeClosed(1,100) // returns a stream of values

                .sum());//performs sum operation
        IntStream.rangeClosed(1,20).asDoubleStream().forEach(System.out::println);
//        DoubleStream.
//        intAutoBoxingStreamDemo();
        intStreamAutoUnBoxingDemo();
    }

    public static void intAutoBoxingStreamDemo(){
        List<Integer> collect = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        System.out.println("boxed output is "+collect.toString());

    }
    public static void intStreamAutoUnBoxingDemo(){
        List<Integer> collect = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        int sum = collect.stream().mapToInt(Integer::intValue).sum();//Here we are doing unboxing from integer to int
        System.out.println("unboxed value sum is "+sum);
    }
}
