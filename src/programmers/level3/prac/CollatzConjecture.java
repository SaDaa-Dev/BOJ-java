package programmers.level3.prac;

import java.util.ArrayList;
import java.util.Arrays;

public class CollatzConjecture {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        ArrayList<Double> results = new ArrayList<>();
        double prefixSum = 0;
        results.add(prefixSum);
        while (k != 1) {
            int originalK = k;
            if (k % 2 == 0) { // 짝수
                k /= 2;
            } else { // 홀수
                k = (k * 3) + 1;
            }
            prefixSum += (originalK + k) / (double) 2;

            results.add(prefixSum);
        }

        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = (results.size() - 1) + ranges[i][1];

            if (start > end) { // 시작점이 끝점보다 크다면 유효하지 않음
                answer[i] = -1;
            } else {
                answer[i] = results.get(end) - results.get(start);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        CollatzConjecture problem = new CollatzConjecture();
        int[][] ranges = {{0, 0}, {0, -1}, {2, -3}, {3, -3}};
        System.out.println(Arrays.toString(problem.solution(5, ranges)));
    }
}
