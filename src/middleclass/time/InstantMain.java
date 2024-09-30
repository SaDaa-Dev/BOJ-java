package middleclass.time;

import java.time.Instant;
import java.time.ZonedDateTime;

public class InstantMain {
    public static void main(String[] args) {
        Instant now = Instant.now(); // UTC 기준
        System.out.println("now = " + now);

        ZonedDateTime zdt = ZonedDateTime.now();
        Instant from = Instant.from(zdt);
        System.out.println("from = " + from);

        Instant epochSecond = Instant.ofEpochSecond(0);
        System.out.println("epochSecond = " + epochSecond);

        Instant instant = epochSecond.plusSeconds(3600);
        System.out.println("instant = " + instant);

        long laterEpochSecond = instant.getEpochSecond();
        System.out.println("laterEpochSecond = " + laterEpochSecond);
    }
}
