package org.example.dateapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class TimeDemo {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        sop("time is "+now);
        sop("hour is "+now.get(ChronoField.HOUR_OF_DAY));
        sop("minute of hour is  -->"+now.getMinute());
        sop("2 mins added"+now.plusMinutes(2));
        sop("minute of day is -->"+now.get(ChronoField.MINUTE_OF_DAY) );
        sop("current time with eve 8pm  "+now.with(ChronoField.HOUR_OF_DAY,20));
        sop("Current time with last minute"+now.with(ChronoField.SECOND_OF_DAY,0));//00:00:00.775


        LocalDateTime localDateTime = LocalDate.now().atTime(LocalTime.now());
        sop(localDateTime);
    }
    public static void sop(Object o){
        System.out.println(o);
    }
}

