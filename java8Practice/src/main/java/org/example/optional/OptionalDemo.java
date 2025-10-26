package org.example.optional;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.OptionalLong;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<Integer> value = Optional.empty();
        if(value.isPresent()){
            System.out.println("value is present");
        }else {
            System.out.println("value is absent so now updating");
            value=Optional.ofNullable(2);
            System.out.println(value);
        }

        System.out.println(Optional.empty().orElse("default")); //default
        System.out.println(Optional.empty().orElseGet(()-> "default value ")); //default value
//        System.out.println(Optional.empty().orElseThrow(()-> new RuntimeException("no value hence exception is throw")));
        Optional.ofNullable(2).ifPresent((e)-> System.out.println(e+" is consumed"));


    }


}
