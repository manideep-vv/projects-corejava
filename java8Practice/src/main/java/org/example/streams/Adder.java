package org.example.streams;

import java.util.stream.IntStream;

public class Adder {
    int sum;

    public Adder() {
    }


    public  void update(Integer e){

        sum+=e.intValue();
    }

    public static void main(String[] args) {
        Adder adder=new Adder();
//        IntStream.rangeClosed(1,1000).forEach(adder::update);
//        System.out.println(adder.sum);

        IntStream.rangeClosed(1,20).forEach((e)->{

        IntStream.rangeClosed(1,1000).parallel().forEach(adder::update);
        System.out.println(adder.sum);
        adder.sum=0;
        });

    }
}
