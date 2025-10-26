package org.example.dateapi;

import java.time.LocalDate;
import java.time.temporal.*;

public class Java8DateDemo {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate tomm = today.plus(1, ChronoUnit.DAYS);
        System.out.println("today date is "+LocalDate.now());
        sop("day of the month is "+today.get(ChronoField.DAY_OF_MONTH));
        sop("day of the year is "+today.get(ChronoField.DAY_OF_YEAR));

        sop("add 2 day from today"+today.plus(2, ChronoUnit.DAYS));
        sop("Add 2 days from today -->"+today.plusDays(2));
        sop("minus 2 days from today-->"+today.minusDays(2));
        sop("today with 12 month-->"+today.withMonth(12));
        sop("today with 11th month-->"+today.with(ChronoField.MONTH_OF_YEAR,11));
        sop("today with 22nd day of month-->"+today.with(ChronoField.DAY_OF_MONTH,22));
        sop(today.with(TemporalAdjusters.lastDayOfYear()));

        sop("is Equal"+today.isEqual(tomm));
        sop("is today before tomm -->"+today.isBefore(tomm));
        sop("is today after tomm -->"+today.isAfter(tomm));

    }
    public static void sop(Object o){
        System.out.println(o);
    }
}
