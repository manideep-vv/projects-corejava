package org.ampf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Task {

//    Logger logger = (Logger) LoggerFactory.getLogger(Task.class);

    public static void ioIntensiveTask(Integer taskNum) {
        System.out.println("Executing task-->" + taskNum +"by --> "+Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
            System.out.println("completed task-->" + taskNum +"by --> "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

//    public static void main(String[] args) {
//        new Task().ioIntensiveTask(2);
//    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Map<String, Integer> map1 = Map.of("Rama", 7500, "Saleema", 7000, "Kabir", 6000,"Martin",7500);
        Map<String, Integer> map2 = Map.of("Sita", 8000, "Jabbar", 3000, "Karteena", 7500,"Dayana",1500);
        Map<String,Integer> finalMap=new HashMap<>();
        finalMap.putAll(map1);
        finalMap.putAll(map2);
        System.out.println(finalMap.size());
        Comparator<Map.Entry<String,Integer>> comparator=(e2,e3)->{
            return e2.getValue()-e3.getValue();
        };
        Map<String,Integer> finalMap2=new HashMap<>();
        List<Map.Entry<String, Integer>> collect = finalMap.entrySet().stream().sorted(comparator).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(collect.get(1));


    }
}
