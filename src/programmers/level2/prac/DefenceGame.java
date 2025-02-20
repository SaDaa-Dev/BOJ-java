package programmers.level2.prac;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class DefenceGame {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            int currEnemy = enemy[i];

            if (n >= currEnemy) {
                queue.offer(currEnemy);
                n -= currEnemy;
                answer++;
            } else if (k > 0) {
                if (!queue.isEmpty() && queue.peek() > currEnemy) {
                    n += queue.poll();
                    k--;
                    if (n >= currEnemy) {
                        queue.offer(currEnemy);
                        n -= currEnemy;
                        answer++;
                    }
                } else {
                    k--;
                    answer++;
                }
            } else {
                break;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        DefenceGame problem = new DefenceGame();
        System.out.println(problem.solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
    }
}
