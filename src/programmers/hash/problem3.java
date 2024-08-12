package programmers.hash;

import java.util.Arrays;
import java.util.Comparator;

public class problem3 {
    public static void main(String[] args) {
        String[] data = {"119", "97674223", "1195524421"};
        String[] data1 = {"123","456","789"};

        System.out.println(solution(data1));
    }


    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }

    // startsWith를 몰랐던 풀이
    public static boolean mySolution(String[] phone_book) {
        boolean answer = true;

        String[] sortedPhoneBook = Arrays.stream(phone_book)
                .sorted(Comparator.comparingInt(String::length))
                .toArray(String[]::new);

        for (int i = 0; i < sortedPhoneBook.length - 1; i++) {
            for (int j = i + 1; j < sortedPhoneBook.length; j++) {
                int flag = 0;
                for (int k = 0; k < sortedPhoneBook[i].length(); k++) {
                    if (sortedPhoneBook[i].charAt(k) == sortedPhoneBook[j].charAt(k)) {
                        flag++;
                    }
                }
                if (flag == sortedPhoneBook[i].length()) {
                    // 접두어 존재
                    return false;
                } else {
                    flag = 0;
                }
            }
        }

        return answer;
    }




}
