package boj.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2667_dfs {

    private static class Solution {
        private int[][] board;
        private boolean[][] visited;
        private final int[][] DIRECTIONS = {
                {1, 0},
                {-1, 0},
                {0, -1},
                {0, 1}
        };
        private List<Integer> result = new ArrayList<>();
        public void solution(int[][] board, int n) {
            this.board = board;
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && board[i][j] != 0) {
                        int currentSum = dfs(board, n, i, j);
                        result.add(currentSum);
                    }
                }
            }

            Collections.sort(result);
            System.out.println(result.size());
            for (Integer re : result) {
                System.out.println(re);
            }
        }

        private int dfs(int[][] board, int n, int i, int j) {
            visited[i][j] = true;
            int count = 1;

            for (int[] dir : DIRECTIONS) {
                int newX = i + dir[0];
                int newY = j + dir[1];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY] && board[newX][newY] != 0) {
                    count += dfs(board, n, newX, newY);
                }
            }

            return count;
        }
    }

    public static void main(String[] args) throws Exception{
        Solution boj = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            board[i] = row;
        }

        boj.solution(board, n);
    }
}
