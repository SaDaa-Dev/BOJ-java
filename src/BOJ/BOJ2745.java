package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        String number = input[0];
        int base = Integer.parseInt(input[1]);

        int sum = 0;
        int length = number.length();

        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(number.charAt(i));
            sum += digit * Math.pow(base, length - 1 - i);
        }

        System.out.println(sum);
    }
}
