package programmers.level2.prac;

import java.util.LinkedList;
import java.util.Queue;

public class IncreaseServer {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int currentTime = 0;
        Queue<Integer> serverExpire = new LinkedList<>();

        while (currentTime < players.length) {
            while (!serverExpire.isEmpty() && serverExpire.peek() < currentTime) {
                serverExpire.poll();
            }
            int player = players[currentTime];
            int currentServerCnt = serverExpire.size();
            int availableCapacity = (currentServerCnt + 1) * m;
            if (player >= availableCapacity) {
                int addServerCnt = ((player - availableCapacity) / m) + 1;
                answer += addServerCnt;
                for (int i = 0; i < addServerCnt; i++) {
                    serverExpire.offer(currentTime + k - 1);
                }
            }

            currentTime++;
        }

        return answer;
    }

    public static void main(String[] args) {
        IncreaseServer problem = new IncreaseServer();
        int[] players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        System.out.println(problem.solution(players, 3, 5));
    }
}

