package boj.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ7562_dfs {

    public class Solution {

        private boolean[][] visited;
        private int result = Integer.MAX_VALUE;
        private final int[][] direction = {
                {2, 1}, {1, 2},
                {2, -1}, {1, -2},
                {-1, -2}, {-2, -1},
                {-2, 1}, {-1, 2}
        };
        private int boardSize;
        private int[] targetPos;

        public int solution(int boardSize, int[] pos, int[] targetPos) {
            // 시작 위치가 목표 위치와 같은 경우
            if (pos[0] == targetPos[0] && pos[1] == targetPos[1]) {
                return 0;
            }

            this.boardSize = boardSize;
            this.targetPos = targetPos;

            // 초기화
            visited = new boolean[boardSize][boardSize];
            result = Integer.MAX_VALUE;

            // 시작 위치를 방문한 것으로 표시
            visited[pos[0]][pos[1]] = true;

            // DFS 호출
            dfs(pos, 0);
            return result;
        }

        private void dfs(int[] pos, int currentSum) {
            // 현재 이동 횟수가 이미 최솟값보다 크거나 같다면 더 이상 탐색하지 않음
            if (currentSum >= result) {
                return;
            }

            // 모든 이동 방향을 탐색
            for (int[] dir : sortDirections(pos)) {
                int newX = dir[0] + pos[0];
                int newY = dir[1] + pos[1];

                // 목표 위치에 도달한 경우
                if (newX == targetPos[0] && newY == targetPos[1]) {
                    result = Math.min(currentSum + 1, result);
                    continue; // 더 짧은 경로가 있을 수 있으므로 탐색을 계속함
                }

                // 새로운 위치가 보드 내에 있고, 아직 방문하지 않은 경우
                if (isValid(newX, newY) && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    dfs(new int[]{newX, newY}, currentSum + 1);
                    visited[newX][newY] = false;
                }
            }
        }

        // 현재 위치에서 목표 위치로의 거리 기반으로 방향을 정렬
        private int[][] sortDirections(int[] pos) {
            return Arrays.stream(direction)
                    .sorted((a, b) -> {
                        int distA = distance(a[0] + pos[0], a[1] + pos[1]);
                        int distB = distance(b[0] + pos[0], b[1] + pos[1]);
                        return Integer.compare(distA, distB);
                    })
                    .toArray(int[][]::new);
        }

        // 현재 위치에서 목표 위치까지의 맨해튼 거리
        private int distance(int x, int y) {
            return Math.abs(x - targetPos[0]) + Math.abs(y - targetPos[1]);
        }

        // 새로운 위치가 보드 내에 있는지 확인
        private boolean isValid(int x, int y) {
            return x >= 0 && x < boardSize && y >= 0 && y < boardSize;
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ7562_dfs boj = new BOJ7562_dfs();
        Solution solution = boj.new Solution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int boardSize = Integer.parseInt(br.readLine());
            int[] pos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] targetPos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int re = solution.solution(boardSize, pos, targetPos);
            System.out.println(re);
        }
    }
}