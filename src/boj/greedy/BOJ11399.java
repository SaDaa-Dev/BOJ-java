package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11399 {
    private static int solution(int[] times) {
        int result = times[0];
        int beforeT = times[0];
        for (int i = 1; i < times.length; i++) {
            int currTime = beforeT + times[i];
            result += currTime;
            beforeT = currTime;
        }

        return result;
    }
    public static void main(String[] args) throws IOException {
        BOJ11399 problem = new BOJ11399();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] times = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(times);
        System.out.println(problem.solution(times));
    }
}
