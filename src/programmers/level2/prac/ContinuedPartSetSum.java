package programmers.level2.prac;

import java.util.ArrayList;

public class ContinuedPartSetSum {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int seqLen = sequence.length;
        int left = 0, right = 0;
        int sum = 0;
        ArrayList<int[]> candidates = new ArrayList<>();

        while (right < seqLen) {
            sum += sequence[right];

            while (sum > k && left <= right) {
                sum -= sequence[left];
                left++;
            }

            if (sum == k) {
                candidates.add(new int[]{left, right});
            }

            right++;
        }


        int minDistance = Integer.MAX_VALUE;
        for (int[] candidate : candidates) {
            int distance = candidate[1] - candidate[0];
            if (distance < minDistance) {
                answer[0] = candidate[0];
                answer[1] = candidate[1];
                minDistance = distance;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        ContinuedPartSetSum problem = new ContinuedPartSetSum();
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        System.out.println(problem.solution(sequence, 5));
    }
}
