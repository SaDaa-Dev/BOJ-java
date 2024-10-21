package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int firstN = numbers[0], secondN = numbers[1];

            if (firstN == 0 && secondN == 0) {
                break;
            }

            if (firstN % secondN == 0) {
                System.out.println("multiple");
            } else if (secondN % firstN == 0) {
                System.out.println("factor");
            } else {
                System.out.println("neither");
            }
        }
    }
}
