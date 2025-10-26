package org.example;

import java.util.concurrent.Callable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
interface A{
    public default String m1(){
        return "P1";
    }
}
interface B{
    public default String m1(){
        return "P1";
    }
}
class C implements A,B {
    @Override
    public  String m1(){
        return "P1";
    }
}
