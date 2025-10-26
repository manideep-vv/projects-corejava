package org.example.dateapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDate.of(1994,06,12).atTime(LocalTime.now());
        LocalDate myBday = LocalDate.of(1994,06,12);
        LocalDate wifeBday = LocalDate.of(1996, 10, 29);
        int days = Period.between( myBday,wifeBday).getDays();
        sop("Days b/n 2 dates is"+days);// 17
        long days2 = ChronoUnit.DAYS.between( wifeBday,myBday);
        sop("Days b/n 2 dates is"+days2);// -870

        LocalDateTime myBdayWithTime=LocalDateTime.of(1994,06,12,9,36,00);
        LocalDateTime myWifeBdayWithTime=LocalDateTime.of(1996,10,29,21,36,00);

        long hours = ChronoUnit.HOURS.between(myBdayWithTime, myWifeBdayWithTime); //20892
        System.out.println("hours b/n 2 bdays"+hours);

        sop(localDateTime);
        sop("localDateTime --> localDate"+localDateTime.toLocalDate());
        LocalDateTime ldt = LocalTime.now().atDate(LocalDate.of(1996, 10, 29));
        sop("ldt ->localTime  "+ldt.toLocalTime());
    }
    public static void sop(Object o){
        System.out.println(o);
    }
}
