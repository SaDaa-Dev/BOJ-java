package programmers.level3.kakao;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTrack {
    public int solution(int[][] board) {
        return bfs(board);
    }

    private int bfs(int[][] board) {
        int n = board.length;
        int[][][] cost = new int[n][n][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    cost[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        int[] directionX = {-1, 1, 0, 0};
        int[] directionY = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, -1});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int c = curr[2];
            int dir = curr[3];

            for (int i = 0; i < 4; i++) {
                int nx = x + directionX[i];
                int ny = y + directionY[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) continue;

                // 직선 도로, 코너 구분
                int newCost = c;
                if (dir == -1 || dir == i) { // 직선 도로
                    newCost += 100;
                } else {
                    newCost += 600;
                }

                if (cost[nx][ny][i] > newCost) {
                    cost[nx][ny][i] = newCost;
                    queue.offer(new int[]{nx, ny, newCost, i});
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            result = Math.min(result, cost[n - 1][n - 1][i]);
        }
        return result;
    }

    public static void main(String[] args) {
        BuildTrack problem = new BuildTrack();
        int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
        System.out.println(problem.solution(board));
    }
}
