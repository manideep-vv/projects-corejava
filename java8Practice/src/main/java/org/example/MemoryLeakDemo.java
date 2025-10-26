package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MemoryLeakDemo {

  static  List<Double> list =new ArrayList<>();
  Runnable r= ()->{

    };
    public static void main(String[] args) {
        IntStream.rangeClosed(1,100000).forEach(e->{
            list.add(Math.random());
        });
        System.out.println("current list size is "+list.size());
    }

}
