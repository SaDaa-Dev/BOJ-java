package programmers.level3.prac;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OverWork {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int work : works) {
            pq.add(work);
        }
        System.out.println("pq = " + pq);

        for (int i = 0; i < n; i++) {
            if (pq.peek() > 0) {
                Integer firstWork = pq.poll();
                pq.add(--firstWork);
            }
        }

        if (pq.peek() == 0) {
            return 0;
        }

        for (Integer q : pq) {
            answer += (int) Math.pow(q, 2);
        }
        return answer;
    }
    public static void main(String[] args) {
        OverWork problem = new OverWork();
        int[] works = {4, 3, 3};
        System.out.println(problem.solution(4, works));
        int[] works1 = {2, 1, 2};
        System.out.println(problem.solution(1, works1));
        int[] works2 = {1, 1};
        System.out.println(problem.solution(3, works2));
    }
}
