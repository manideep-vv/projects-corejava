package org.example.ZonedDt;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class MyDTFormatter {

    public static void main(String[] args) {

        parseAndFormatLocalDate();
        parseAndFormatLocalTime();
        parseAndFormatLocalDateAndTime();

    }

    private static void parseAndFormatLocalDateAndTime() {
        ZonedDateTime canadaZDT=ZonedDateTime.now(ZoneId.of("Canada/Atlantic"));
        sop(canadaZDT);
        String canadaTimeAsString = canadaZDT.format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
        sop("formatted from date to str -->"+canadaTimeAsString);
        //Here we have to tell the format of the string which u are passing
        LocalDateTime parsedFromString = LocalDateTime.parse(canadaTimeAsString, DateTimeFormatter.ISO_ZONED_DATE_TIME);
        sop("parsedFromString to Date--> "+parsedFromString);
    }

    private static void parseAndFormatLocalTime() {
        LocalTime canadaCurrentTime=LocalTime.now(ZoneId.of("Asia/Calcutta"));
        sop(canadaCurrentTime);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH@@mm@@ss");
        String timeAsString = canadaCurrentTime.format(formatter);
        sop(timeAsString);
        LocalTime parsedDateFromString = LocalTime.parse(timeAsString, formatter);
        sop("parsedDateFromString"+parsedDateFromString);
    }

    private static void parseAndFormatLocalDate() {
        LocalDate parsedDate = LocalDate.parse("2024-04-08", DateTimeFormatter.ISO_DATE);
        sop("parsedDate is "+parsedDate);
        String formattedDate = parsedDate.format(DateTimeFormatter.ofPattern("dd==MM==yyyy"));
        sop("formatted as String -->"+formattedDate);
    }

    public static void sop(Object o){
        System.out.println(o);
    }
}
