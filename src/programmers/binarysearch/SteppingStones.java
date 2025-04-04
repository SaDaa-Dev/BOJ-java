package programmers.binarysearch;

import java.util.Arrays;

public class SteppingStones {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 1;
        int right = distance;
        Arrays.sort(rocks);

        while (left <= right) {
            int mid = (left + right) / 2;
            int removeRockCnt = 0;
            int curr = 0;

            for (int rock : rocks) {
                int diff = rock - curr;

                if (diff < mid) {
                    removeRockCnt += 1;
                } else {
                    curr = rock;
                }
            }

            if (distance - curr < mid) {
                removeRockCnt++;
            }

            if (removeRockCnt > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = mid;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        SteppingStones problem = new SteppingStones();
        int[] rocks = {2, 14, 11, 21, 17};
        System.out.println(problem.solution(25, rocks, 2));
    }
}
