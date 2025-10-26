package org.example.streams;

import org.example.pojo.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsPrac {

    public static void main(String[] args) {
//        System.out.println(getEmpAsStream().map(Employee::getEmpName).collect(Collectors.joining("-")));
        createAStream();
     /*   Stream<String> s = Stream.of("one", "two");
        s.count();
        Stream<String> randomVal = Stream.generate(()->{
            System.out.println("invoked supplier");
           return  UUID.randomUUID().toString();
        }).limit(10000);
        randomVal.forEach(e-> System.out.println(e));

        IntStream.range(1,100).forEach(e-> System.out.println(e));*/

//        System.out.println( IntStream.range(1,100).min());
//        System.out.println(Stream.of("mani","santu").min((e1,e2)->e1.length()-e2.length()));
//        minMax();
//        findFirstVsFindAny();
//        matches();
//        reduceDemo();
//        collectDemo();
//        skipDemo();
    }
    public static void createAStream(){
        Stream<String> namesStream = Stream.of("mohan", "rama", "mohith", "sai", "santu", "ramesh", "cat", "america", "germany");
        Stream.generate(()-> UUID.randomUUID().toString()).limit(10).forEach(System.out::println);
        System.out.println("generated");

    }

    public static Stream<String> getAStream(){
        return Stream.of("mohan","rama","mohith","sai","santu","ramesh","cat","america","germany");
    }
    public static void minMax() {
        Stream<String> s =getAStream();
        Optional<String> min = s.min((e1, e2) -> e1.compareTo(e2));
        System.out.println("min value is -->"+min.orElse("no value "));
    }
    public static void findFirstVsFindAny() {
        Stream<String> s = getAStream().filter(s2->s2.length()>6);
        Stream<String> s1 = getAStream().filter(s2->s2.length()>6);
        System.out.printf("findany -->%s , findFirst --> %s",s.findAny(),s1.findFirst());
    }
    public static void matches() {
        Stream<String> s = getAStream();
        Stream<String> s1 = getAStream();
        Stream<String> s2 = getAStream();
        System.out.printf("\n allMatch -->%s ",s.allMatch(e->e.length()>5));
        System.out.printf("\n anyMatch -->%s ",s1.anyMatch(e->e.length()>5));
        System.out.printf("\n noneMatch -->%s ",s2.noneMatch(e->e.length()>5));
    }
    public static void reduceDemo() {
        BinaryOperator<String> binaryOperator=(s1,s2)->s1.concat(s2);
        Stream<String> aStream = getAStream();
        System.out.println("\n output of reduce() method is " + aStream.reduce(binaryOperator));

        Stream<Integer> intStream = Stream.of(2, 3, 4, 5);
        BinaryOperator<Integer> integerBinaryOperator=(e1,e2)->e1+e2;
        System.out.println(" reduce operation sum o/p is"+intStream.reduce(integerBinaryOperator));

        Stream<String> stream = Stream.of("w", "o", "l", "f").sorted();
       BinaryOperator<String>binaryOperator1=(e1,e2)->e1.concat(e2);
        System.out.println("reduce demo -->2"+stream.reduce(binaryOperator1));

        Stream<Employee> empAsStream = getEmpAsStream();
        // now our aim is to reduce this stream into single obj whose name is so much big
        Optional<Employee> reduce = empAsStream.reduce((s1, s2) -> s1.getEmpName().length()> s2.getEmpName().length()?s1:s2);
        System.out.println("reduced emp is "+reduce.get());

        Stream<Employee> empSal = getEmpAsStream();
        BinaryOperator<Integer> bop=(e1,e2)->e1.intValue()+e2.intValue();
        System.out.println("sum of all salaries is "+empSal.mapToInt(e->e.getSalary()).sum());
//        System.out.println("reduced salary is -->"+empSal.map(e->e.getSalary()).reduce(bop));


    }
    public static void collectDemo() {

        Stream<String> aStream = getAStream();
        StringBuilder collect = aStream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println("collect demo -->"+collect);

        Stream<String> stream = Stream.of("w", "o", "l", "f");
        System.out.println("collectors.toset()->"+ stream.collect(Collectors.toSet()));

    }

    public static Stream<Employee> getEmpAsStream(){

        Employee e1=new Employee(1,"Mani", 800, Arrays.asList("eating","sleeping"));
        Employee e2=new Employee(2,"Sai", 700, Arrays.asList("reading","surfing"));
        Employee e3=new Employee(2,"Santu", 900, Arrays.asList("dancing","singing"));
        Employee e4=new Employee(2,"roopa", 400, Arrays.asList("dancing","singing"));
        Stream.of(e1,e2).mapToInt(Employee::getSalary).sum();
        return Stream.of(e1,e2,e3,e4);
    }

    public static IntStream getIntStream(int maxValue){
        return IntStream.rangeClosed(0,maxValue);
    }
    public static void skipDemo() {
    getIntStream(100).skip(10).limit(5).forEach(System.out::println);
    }

}
