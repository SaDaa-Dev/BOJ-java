package middleclass1.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Problem4 {
    public static void main(String[] args) {
        int year = 2024;
        int month = 1;

        LocalDate dt = LocalDate.of(year, month, 1);
        DayOfWeek firstDayOfWeek = dt.getDayOfWeek();
        DayOfWeek lastDay = dt.with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek();
        System.out.println("firstDayOfWeek = " + firstDayOfWeek);
        System.out.println("lastDay = " + lastDay);
    }
}
