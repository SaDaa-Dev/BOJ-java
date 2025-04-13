package programmers.level2.prac;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberBlock {
    public int[] solution(long begin, long end) {
        ArrayList<Integer> results = new ArrayList<>();
        for (long b = begin; b <= end; b++) {
            results.add(findBlockValue(b));
        }
        return results.stream().mapToInt(Integer::valueOf).toArray();
    }

    private int findBlockValue(long num) {
        if (num == 1) return 0;

        int maxValue = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (num / i <= 10_000_000) return (int)(num / i);
                maxValue = i;
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        NumberBlock problem = new NumberBlock();
        System.out.println(Arrays.toString(problem.solution(1, 10)));
    }
}
