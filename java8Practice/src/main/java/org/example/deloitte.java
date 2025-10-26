package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class deloitte {


    public static void main(String[] args) {
        int activeCount = Thread.activeCount();
        ExecutorService es = Executors.newFixedThreadPool(20);
        ScheduledExecutorService scheduledes = Executors.newScheduledThreadPool(2);
        Executors.newWorkStealingPool(3);
        System.out.println("current threads in app is "+activeCount);
    }
}
