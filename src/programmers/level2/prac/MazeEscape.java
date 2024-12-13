package programmers.level2.prac;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class MazeEscape {
    private class Solution {
        private class Point {
            int x;
            int y;
            int currentSum;

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Point point)) return false;
                return x == point.x && y == point.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }

            public Point(int x, int y, int currentSum) {
                this.x = x;
                this.y = y;
                this.currentSum = currentSum;
            }
        }
        private Point leverP;
        private Point exitP;
        private Point startP;
        private boolean findLever;
        private final int[][] DIRECTION = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };
        public int solution(String[] maps) {
            int row = maps.length;
            int col = maps[0].length();

            int[][] parsedMaps = parseMaps(maps, row, col);

            // 레버까지 BFS
            boolean[][] leverVisited = new boolean[row][col];
            int toLever = bfs(parsedMaps, leverVisited, startP, leverP);

            // 출구까지 BFS
            boolean[][] exitVisited = new boolean[row][col];
            int toExit = bfs(parsedMaps, exitVisited, leverP, exitP);

            if (toLever == 0 || toExit == 0) {
                return -1;
            } else {
                return toLever + toExit;
            }
        }

        private int bfs(int[][] parsedMaps, boolean[][] visited, Point startPoint, Point targetPoint) {
            int r = parsedMaps.length;
            int c = parsedMaps[0].length;
            Queue<Point> queue = new LinkedList<>();
            queue.add(startPoint);
            visited[startPoint.x][startPoint.y] = true;

            // BFS
            while (!queue.isEmpty()) {
                Point currP = queue.poll();

                if (currP.equals(targetPoint)) {
                    return currP.currentSum;
                }

                for (int[] dir : DIRECTION) {
                    int nx = dir[0] + currP.x;
                    int ny = dir[1] + currP.y;

                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny] && parsedMaps[nx][ny] != 0) {
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny, currP.currentSum + 1));
                    }
                }
            }

            return 0;
        }

        private int[][] parseMaps(String[] maps, int row, int col) {
            // 벽 0, 통로 1, 레버 2, 출구 3
            int[][] intMaps = new int[row][col];
            for (int i = 0; i < row; i++) {
                char[] chars = maps[i].toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    if (chars[j] == 'X') {
                        intMaps[i][j] = 0;
                    } else {
                        if (chars[j] == 'S') {
                            startP = new Point(i, j, 0);
                        }
                        if (chars[j] == 'L') {
                            leverP = new Point(i, j, 0);
                        }
                        if (chars[j] == 'E') {
                            exitP = new Point(i, j, 0);
                        }
                        intMaps[i][j] = 1;
                    }
                }
            }

            return intMaps;
        }
    }
    public static void main(String[] args) {
        MazeEscape prom = new MazeEscape();
        Solution sol = prom.new Solution();
        String[] maps = new String[]{
                "SOOOL",
                "XXXXO",
                "OOOOO",
                "OXXXX",
                "OOOOE"
        };
        System.out.println(sol.solution(maps));
    }
}
