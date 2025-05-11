package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BOJ1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int n = Integer.parseInt(br.readLine());

        List<int[]> meetingList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] se = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            meetingList.add(se);
        }

        meetingList.sort(Comparator.comparingInt((int[] o) -> o[1]).thenComparingInt(o -> o[0]));
        
        int endTime = 0;
        for (int[] m : meetingList) {
            if (m[0] >= endTime) {
                endTime = m[1];
                result++;
            }
        }

        System.out.println(result);
    }
}
