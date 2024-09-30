package middleclass.time;

import java.time.LocalDate;
import java.util.Locale;

public class LocalDateMain {
    public static void main(String[] args) {
        LocalDate nowDate = LocalDate.now();
        LocalDate ofDate = LocalDate.of(2013, 11, 21);
        System.out.println("nowDate = " + nowDate);
        System.out.println("ofDate = " + ofDate);

    }
}
