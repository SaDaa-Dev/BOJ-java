package boj.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2178_dfs {
    public class Solution {
        private int[][] maps;
        private boolean[][] visited;
        private int n;
        private int m;
        private int minDis = Integer.MAX_VALUE;
        public int solution(int[][] maps) {
            this.maps = maps;
            this.n = maps.length;
            this.m = maps[0].length;
            visited = new boolean[n][m];

            dfs(0, 0, 1);

            return minDis == Integer.MAX_VALUE ? -1 : minDis;
        }

        public void dfs(int x, int y, int dis) {
            if (x == m - 1 && y == n - 1) {
                minDis = Math.min(minDis, dis);
            }
            int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            for (int[] dir : direction) {
                int newX = dir[0] + x;
                int newY = dir[1] + y;

                if (newX >= 0 && newX < m && newY >= 0 && newY < n
                        && !visited[newY][newX] && maps[newY][newX] == 1) {
                    visited[newY][newX] = true;
                    dfs(newX, newY, dis + 1);
                    visited[newY][newX] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] input = new int[n][m];

            for (int i = 0; i < n; i++) {
                input[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }

            BOJ2178_dfs tmp = new BOJ2178_dfs();
            Solution solution = tmp.new Solution();

            System.out.println(solution.solution(input));
        } catch (IOException e) {}

    }
}
