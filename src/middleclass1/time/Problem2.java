package middleclass1.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Problem2 {
    public static void main(String[] args) {
        LocalDate dt = LocalDate.of(2024, 1, 1);
        for (int i = 0; i < 5; i++) {
            LocalDate nextDate = dt.plus(2 * i, ChronoUnit.WEEKS);
            System.out.println(nextDate);
        }
    }
}
