package middleclass1.time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Problem1 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.of(2024, 1, 1, 0, 0, 0);
        LocalDateTime plusedDate = now
                .plus(1, ChronoUnit.YEARS)
                .plus(2, ChronoUnit.MONTHS)
                .plus(3, ChronoUnit.DAYS)
                .plus(4, ChronoUnit.HOURS);
        System.out.println("now = " + now);
        System.out.println("plusedDate = " + plusedDate);
    }
}
