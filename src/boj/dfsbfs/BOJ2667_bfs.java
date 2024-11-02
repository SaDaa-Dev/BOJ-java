package boj.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2667_bfs {
    private static class Solution {
        private int[][] board;
        private boolean[][] visited;
        private final int[][] DIRECTION = {
                {1, 0},
                {-1, 0},
                {0, -1},
                {0, 1}
        };
        private List<Integer> houseCnt = new LinkedList<>();

        public void solution(int[][] board, int n) {
            this.board = board;
            this.visited = new boolean[n][n];


            for (int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++){
                    if (!visited[i][j] && board[i][j] != 0) {
                        bfs(board, i, j, n);
                    }
                }
            }

            Collections.sort(houseCnt);
            System.out.println(houseCnt.size());
            for (Integer houseCnt : houseCnt) {
                System.out.println(houseCnt);
            }
        }

        private void bfs(int[][] board, int x, int y, int n) {
            visited[x][y] = true;
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{x, y});
            int currentSum = 1;
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int cx = current[0];
                int cy = current[1];

                for(int[] dir : DIRECTION){
                    int newX = cx + dir[0];
                    int newY = cy + dir[1];

                    if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY] && board[newX][newY] != 0) {
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                        currentSum++;
                    }
                }
            }

            houseCnt.add(currentSum);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for(int i = 0; i < n; i++){
            int[] houses = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            board[i] = houses;
        }

        Solution solution = new Solution();
        solution.solution(board, n);
    }
}
