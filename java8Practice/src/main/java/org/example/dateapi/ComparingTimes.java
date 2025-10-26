package org.example.dateapi;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;

public class ComparingTimes {
    public static void main(String[] args) {
        LocalTime start = LocalTime.now();
        Instant startInstance = Instant.now();
        LocalTime indiaTime=LocalTime.of(17,30);
        LocalTime usTime=LocalTime.of(6,30);
        sop("Minutes between 2 times is "+ChronoUnit.MINUTES.between(indiaTime,usTime));

        LocalDateTime myBdayWithTime=LocalDateTime.of(1994,06,12,9,36,00);
        LocalDateTime myWifeBdayWithTime=LocalDateTime.of(1996,10,29,21,36,00);

        Duration between = Duration.between(myWifeBdayWithTime, myBdayWithTime);
        sop("duration between 2 bdays"+ between.toHours());

        Duration hours_3 = Duration.ofHours(3);
        sop("duration is "+hours_3.toMinutes());
        sop("seconds between 2 bdays is "+ChronoUnit.SECONDS.between(myBdayWithTime,myWifeBdayWithTime));
        LocalTime end = LocalTime.now();
        Instant endInstance = Instant.now();
        System.out.println("Seconds elapsed -->"+Duration.between(start,end).toMillis());
        System.out.println("Seconds elapsed -->"+Duration.between(startInstance,endInstance).toMillis());
        System.out.println(ZonedDateTime.now());
    }
    public static void sop(Object o){
        System.out.println(o);
    }

}
