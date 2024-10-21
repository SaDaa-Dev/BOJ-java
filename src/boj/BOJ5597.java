package boj;

import java.util.Scanner;
import java.util.stream.IntStream;

public class BOJ5597 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[30];

        for (int i = 0; i < 28; i++) {
            int targetN = sc.nextInt();
            numbers[targetN - 1] = 1;
        }

        IntStream.range(0, numbers.length)
                .filter(i -> numbers[i] == 0)
                .forEach(i -> System.out.println(i + 1));

    }
}
