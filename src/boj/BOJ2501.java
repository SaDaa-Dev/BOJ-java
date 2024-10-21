package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int num = numbers[0];
        int k = numbers[1];

        int target = 0;

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                target++;

                if (target == k) {
                    System.out.println(i);
                }
            }
        }

        if (target < k) {
            System.out.println("0");
        }

    }
}
