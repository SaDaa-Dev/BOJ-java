package programmers.level3.prac;

import java.util.Arrays;

public class EntryAudit {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        int len = times.length;
        long left = 1;
        long right = (long) times[len - 1] * n;
        while (left <= right) {
            long mid = (left + right) / 2;

            long people = 0;
            for (int auditor : times) {
                people += mid / auditor;
            }

            if (people >= n) { // 가능할 때!
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        EntryAudit problem = new EntryAudit();
        System.out.println(problem.solution(6, new int[]{7, 10}));
    }
}
