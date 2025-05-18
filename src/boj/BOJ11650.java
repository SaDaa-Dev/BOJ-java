package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> coordinates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] pos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            coordinates.add(pos);
        }

        coordinates.sort(Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));
        for (int[] coordinate : coordinates) {
            System.out.println(coordinate[0] + " " + coordinate[1]);
        }
    }
}
