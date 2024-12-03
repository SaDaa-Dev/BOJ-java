package programmers.dfsbfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Problem5 {

    private class Solution {
        int answer = 0;
        final int SIZE = 101;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] map = new int[SIZE][SIZE];
        boolean[][] visited = new boolean[SIZE][SIZE];
        Queue<Pair> q = new LinkedList<>();

        class Pair {
            int x, y, cnt;

            public Pair(int x, int y, int cnt) {
                this.x = x;
                this.y = y;
                this.cnt = cnt;
            }
        }

        public boolean inRange(int x, int y) {
            return 0 <= x && x < SIZE && 0 <= y && y < SIZE;
        }

        public boolean canGo(int x, int y) {
            if (!inRange(x, y)) return false;
            if (map[x][y] != 1 || visited[x][y]) return false;
            return true;
        }

        public void bfs(int startX, int startY, int itemX, int itemY) {
            visited[startX][startY] = true;
            q.add(new Pair(startX, startY, 0));

            while (!q.isEmpty()) {
                Pair cur = q.poll();

                if (cur.x == itemX && cur.y == itemY) {
                    answer = cur.cnt / 2;
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (canGo(nx, ny)) {
                        q.add(new Pair(nx, ny, cur.cnt + 1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            int n = rectangle.length;

            for (int i = 0; i < n; i++) {
                int x1 = rectangle[i][0] * 2;
                int y1 = rectangle[i][1] * 2;
                int x2 = rectangle[i][2] * 2;
                int y2 = rectangle[i][3] * 2;
                for (int p = x1; p <= x2; p++) {
                    for (int q = y1; q <= y2; q++) {
                        if (p == x1 || p == x2 || q == y1 || q == y2) {
                            if (map[p][q] == 0) {
                                map[p][q] = 1;
                            }
                        } else {
                            map[p][q] = 2;
                        }
                    }
                }
            }

            bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);

            return answer;
        }
    }
    public static void main(String[] args) {
        Problem5 prom = new Problem5();
        Solution sol = prom.new Solution();

        // 테스트 케이스 1
        int[][] rectangle1 = {
                {1, 1, 7, 4},
                {3, 2, 5, 5},
                {4, 3, 6, 9},
                {2, 6, 8, 8}
        };
        int characterX1 = 1;
        int characterY1 = 3;
        int itemX1 = 7;
        int itemY1 = 8;

        int result1 = sol.solution(rectangle1, characterX1, characterY1, itemX1, itemY1);
        System.out.println(result1); // 기대 출력: 17
    }
}