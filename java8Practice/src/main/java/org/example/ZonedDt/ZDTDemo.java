package org.example.ZonedDt;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class ZDTDemo {

    public static void main(String[] args) {

        ZoneId usZone=ZoneId.of(ZoneId.SHORT_IDS.get("CST"));
        ZonedDateTime nowInChicago=ZonedDateTime.now(usZone);
        System.out.println("CST time now is "+nowInChicago);

        ZoneId ESTZone=ZoneId.of(ZoneId.SHORT_IDS.get("EST"));
        sop("time in EST is "+ZonedDateTime.now(ESTZone));

        sop("india time now -->"+LocalDateTime.now(ZoneId.of("Asia/Kolkata")));
        sop("America/Los_Angeles time now -->"+LocalDateTime.now(ZoneId.of("America/Los_Angeles")));
        //Getting paris time using instant
        ZonedDateTime getParisTimeUsingInstant = Instant.now().atZone(ZoneId.of("Europe/Paris"));
        System.out.println("getParisTimeUsingInstant"+getParisTimeUsingInstant);

        LocalDateTime currentTime=LocalDateTime.now();
        //This will just add the zone info to the provided time
        ZonedDateTime asiaZonedDateTime = currentTime.atZone(ZoneId.of("Asia/Kolkata"));
        System.out.println("asiaZonedDateTime"+asiaZonedDateTime);

        ZonedDateTime addLosAngelesZone = currentTime.atZone(ZoneId.of("America/Los_Angeles"));
        //Now for current time we will add america/Los_ang time zone
        System.out.println("addLosAngelesZone"+addLosAngelesZone);


        LocalDateTime australiaTime= LocalDateTime.now(ZoneId.of("Australia/Sydney"));
        sop("now time in Australia/Sydney is "+australiaTime);
        ZonedDateTime addedAfricaTimeZone = australiaTime.atZone(ZoneId.of("Africa/Cairo"));
        sop("just added the zone to australia time"+addedAfricaTimeZone);

        LocalDate expiryDate=LocalDate.of(2025,03,17);
        sop("days for expiry is "+ChronoUnit.DAYS.between(expiryDate,LocalDate.now()));
    }

    public static void sop(Object o){
        System.out.println(o);
    }

}
