package programmers.level2.prac;

import java.util.ArrayList;
import java.util.Arrays;

public class LineUpWay {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> ary = new ArrayList<>();

        long total = 1;
        for (int i = 1; i <= n; i++) {
            ary.add(i);
            total *= i;
        }

        k--;
        int idx = 0;
        while(idx < n) {
            total /= n - idx;
            answer[idx++] = ary.remove((int) (k/total));
            k %= total;
        }
        return answer;
    }

    public static void main(String[] args) {
        LineUpWay problem = new LineUpWay();
        System.out.println(Arrays.toString(problem.solution(3, 5)));
    }
}
