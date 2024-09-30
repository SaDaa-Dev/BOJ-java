package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int up = input[0], down = input[1], target = input[2];
        int day = 0, upSum = 0;

        int netHeightPerDay = up - down;

        int days = (int) Math.ceil((double) (target - down) / netHeightPerDay);

        System.out.println(days);
    }
}
