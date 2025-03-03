package programmers.level3.prac;

import java.util.Arrays;

public class BestSet {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if (s < n) {
            return new int[]{-1};
        }

        int quot = s / n;
        int remainder = s % n;
        for (int i = 0; i < n; i++) {
            answer[i] = (i < n - remainder) ? quot : quot + 1;
        }

        return answer;
    }
    public static void main(String[] args) {
        BestSet problem = new BestSet();
        problem.solution(2, 1);
    }
}
