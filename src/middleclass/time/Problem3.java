package middleclass.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;

public class Problem3 {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 11, 21);

        Period period = Period.between(startDate, endDate);
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

        System.out.println("startDate = " + startDate);
        System.out.println("endDate = " + endDate);
        System.out.println("남은 기간 = " + period.getYears() + "년 " + period.getMonths() + "월 " + period.getDays() + "일");
        System.out.println("디데이 = " + daysBetween);
    }
}