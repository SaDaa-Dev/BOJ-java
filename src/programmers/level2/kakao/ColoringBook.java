package programmers.level2.kakao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {
    private final int[][] DIRECTION = {
            {1, 0}, // 하
            {-1, 0}, // 상
            {0, 1}, // 우
            {0, -1} // 좌
    };

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    int areaSize = bfs(picture, visited, i, j, picture[i][j]);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, areaSize);
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private int bfs(int[][] picture, boolean[][] visited, int startM, int startN, int targetNum) {
        Queue<int[]> q = new LinkedList<>();
        int size = 1;
        q.offer(new int[]{startM, startN});
        visited[startM][startN] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] dir : DIRECTION) {
                int nm = curr[0] + dir[0];
                int nn = curr[1] + dir[1];

                if (isInside(picture.length, picture[0].length, nm, nn)
                        && picture[nm][nn] == targetNum
                        && !visited[nm][nn]
                ) {

                    q.offer(new int[]{nm, nn});
                    visited[nm][nn] = true;
                    size++;
                }
            }
        }

        return size;
    }

    private boolean isInside(int maxM, int maxN, int currM, int currN) {
        if (currM < 0 || currM > maxM - 1 || currN < 0 || currN > maxN - 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ColoringBook problem = new ColoringBook();
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        System.out.println(Arrays.toString(problem.solution(6, 4, picture)));
    }
}
