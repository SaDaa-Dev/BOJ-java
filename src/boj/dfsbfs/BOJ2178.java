package boj.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    public class Solution {
        private int[][] maps;
        private boolean[][] visited;
        private int targetX;
        private int targetY;
        private int minDis = Integer.MAX_VALUE;
        public int solution(int[][] maps) {
            this.maps = maps;
            visited = new boolean[maps.length][maps[0].length];
            targetX = maps[0].length - 1;
            targetY = maps.length - 1;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0, 1});
            visited[0][0] = true;
            // 동 서 남 북
            int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                int distance = current[2];

                if (x == targetX && y == targetY) {
                    return distance;
                }

                for (int[] dir : direction) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < maps[0].length && newY >= 0 && newY < maps.length
                            && maps[newY][newX] == 1 && !visited[newY][newX]) {
                        visited[newY][newX] = true;
                        queue.offer(new int[]{newX, newY, distance + 1});
                    }

                }
            }

            return -1;
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

            BOJ2178 tmp = new BOJ2178();
            Solution solution = tmp.new Solution();

            System.out.println(solution.solution(input));
        } catch (IOException e) {}

    }
}
