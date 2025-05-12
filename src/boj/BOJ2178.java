package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2178 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];
        int[][] board = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            board[i] = row;
        }

        // 최소 경로 BFS
        int[][] DIRECTION = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            if (curr[0] == n - 1 && curr[1] == m - 1) {
                System.out.println(curr[2]);
                break;
            }
            
            for (int[] dir : DIRECTION) {
                int nx = curr[0] + dir[0];
                int ny = curr[1] + dir[1];

                if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1
                        || board[nx][ny] == 0
                        || visited[nx][ny]) continue;

                queue.offer(new int[]{nx, ny, curr[2] + 1});
                visited[nx][ny] = true;
            }
        }
    }
}
