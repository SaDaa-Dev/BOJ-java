package programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

// 게임 맵 최단거리
public class Problem3 {
    public class Solution {
        private int[][] maps;
        private int targetX;
        private int targetY;
        private boolean[][] visited;
        public int solution(int[][] maps) {
            this.maps = maps;
            targetY = maps.length - 1;
            targetX = maps[0].length - 1;
            visited = new boolean[maps.length][maps[0].length];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0, 1});
            visited[0][0] = true;

            // 동, 서, 남, 북
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

                    if (newX >= 0 && newX < maps[0].length && newY >= 0 && newY < maps.length && maps[newY][newX] == 1 && !visited[newY][newX]) {
                        visited[newY][newX] = true;
                        queue.offer(new int[] {newX, newY, distance + 1});
                    }
                }
            }

            return -1;
        }
    }
    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        Solution logic = problem3.new Solution();
        int[][] input = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        System.out.println("result = " + logic.solution(input));
    }
}
