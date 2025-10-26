package org.example.optional;

import java.util.Optional;

public class OptionalMapFlatMapEx {
    public static void main(String[] args) {
        String s = Optional.ofNullable("2").map(e ->{
            System.out.println("function is executed");
            return "value is " + e;
        } ).orElse("2");
//        System.out.println(s);
        ifpresentOrElse();
    }

    public static void ifpresentOrElse() {
        Optional.empty().ifPresent((e)-> System.out.println("yes value is present"));
        Object aDefault = Optional.empty().orElse("default");
        Optional.ofNullable("2")
                .map(e->"orayya").ifPresent((c)-> System.out.println("value is there "));

    }
}
