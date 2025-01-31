package programmers.level2.prac;

import java.util.*;
import java.util.stream.Collectors;

public class MakeSameQueue {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> queued1 = new LinkedList<>(Arrays.stream(queue1).boxed().collect(Collectors.toList()));
        Queue<Integer> queued2 = new LinkedList<>(Arrays.stream(queue2).boxed().collect(Collectors.toList()));
        long sumQueue1 = Arrays.stream(queue1).sum();
        long sumQueue2 = Arrays.stream(queue2).sum();

        if ((sumQueue1 + sumQueue2) % 2 != 0) {
            return -1;
        }
        long targetAvg = (sumQueue1 + sumQueue2) / 2;
        while (true) {
            if (sumQueue1 == targetAvg && sumQueue2 == targetAvg){
                return answer;
            }
            if (answer > (queue1.length + queue2.length) * 3) {
                return -1;
            }

            if (sumQueue1 > sumQueue2) {
                Integer polled = queued1.poll();
                queued2.offer(polled);
                sumQueue1 -= (long) polled;
                sumQueue2 += (long) polled;
                answer++;
            } else {
                Integer polled = queued2.poll();
                queued1.offer(polled);
                sumQueue2 -= (long) polled;
                sumQueue1 += (long) polled;
                answer++;
            }
        }
    }
    public static void main(String[] args) {
        MakeSameQueue problem = new MakeSameQueue();
        System.out.println(problem.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
        System.out.println(problem.solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
    }
}
