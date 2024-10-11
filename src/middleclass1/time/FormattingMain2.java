package middleclass1.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormattingMain2 {
    public static void main(String[] args) {
        // 포맷팅 : 날짜와 시간을 문자로
        LocalDateTime now = LocalDateTime.of(2024, 12, 31, 13, 30, 59);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        System.out.println("formattedDateTime = " + formattedDateTime);
        System.out.println("now = " + now);


        // 파싱 : 문자를 날짜와 시간으로
        String dateTimeStr = "2030-01-01 11:30:00";
        LocalDateTime parsedDate = LocalDateTime.parse(dateTimeStr, formatter);
        System.out.println("parsedDate = " + parsedDate);
    }
}
