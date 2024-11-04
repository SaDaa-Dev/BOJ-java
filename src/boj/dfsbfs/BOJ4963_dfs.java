package boj.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ4963_dfs {
    private static class Solution {
        private int[][] board;
        private boolean[][] visited;
        private final int[][] DIRECTIONS = { // 동~서~남~북
                {1, 0},
                {1, -1},
                {0, -1},
                {-1, -1},
                {-1, 0},
                {-1, 1},
                {0, 1},
                {1, 1}
        };
        private int maxH;
        private int maxW;
        public void solution(int[][] board, int w, int h) {
            this.board = board;
            this.visited = new boolean[h][w];
            this.maxH = h;
            this.maxW = w;

            int result = 0;
            for (int i = 0; i < maxH; i++) {
                for (int j = 0; j < maxW; j++) {
                    if (!visited[i][j] && board[i][j] != 0) {
                        dfs(board, i, j);
                        result++;
                    }
                }
            }

            System.out.println(result);
        }

        private void dfs(int[][] board, int h, int w) {
            visited[h][w] = true;

            for (int[] dir : DIRECTIONS) {
                int nw = dir[0] + w;
                int nh = dir[1] + h;

                if (nw >= 0 && nw < maxW && nh >= 0 && nh < maxH && !visited[nh][nw] && board[nh][nw] != 0) {
                    dfs(board, nh, nw);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] wh = br.readLine().split(" ");
            if (wh[0].equals("0") && wh[1].equals("0")) {
                break;
            }

            int w = Integer.parseInt(wh[0]);
            int h = Integer.parseInt(wh[1]);

            int[][] board = new int[h][w];

            for (int i = 0; i < h; i++) {
                int[] rows = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                board[i] = rows;
            }

            Solution boj = new Solution();
            boj.solution(board, w, h);
        }
    }
}
