package programmers.stack;

import java.util.LinkedList;
import java.util.Queue;

public class Problem4 {
    public static void main(String[] args) {
        int solution = solution(new int[]{2, 1, 3, 2}, 2);
        System.out.println("solution = " + solution);
    }

    private static int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[] {priorities[i], i});
        }
        int answer = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            boolean hasHigherPrior = false;
            for (int[] process : queue) {
                if (process[0] > current[0]) {
                    hasHigherPrior = true;
                    break;
                }
            }

            if (hasHigherPrior) {
                queue.add(current);
            } else {
                answer++;

                if (current[1] == location) {
                    return answer;
                }
            }
        }

        return answer;
    }
}
