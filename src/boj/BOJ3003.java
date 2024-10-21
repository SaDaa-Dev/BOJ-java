package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] origin = new int[] {1, 1, 2, 2, 2, 8};

        String str = br.readLine();
        int[] target = Arrays.stream(str.split(" ")).mapToInt(Integer::valueOf).toArray();
        for (int i = 0; i < origin.length; i++) {
            origin[i] = origin[i] - target[i] != 0 ? origin[i] - target[i] : 0;
        }

        Arrays.stream(origin).forEach(value -> System.out.print(value + " "));
    }
}
