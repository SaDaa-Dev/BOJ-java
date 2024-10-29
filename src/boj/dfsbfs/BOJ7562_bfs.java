package boj.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ7562_bfs {

    public class Solution {

        private int[][] board;
        private boolean[][] visited;
        private final int[][] direction = {
                {2, 1}, {1, 2},
                {2, -1}, {1, -2},
                {-1, -2}, {-2, -1},
                {-2, 1}, {-1, 2}
        };

        public int solution(int boardSize, int[] pos, int[] targetPos) {
            board = new int[boardSize][boardSize];
            visited = new boolean[boardSize][boardSize];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{pos[0], pos[1]});
            visited[pos[0]][pos[1]] = true;
            int count = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] current = queue.poll();
                    if (current[0] == targetPos[0] && current[1] == targetPos[1]) {
                        return count;
                    }

                    for (int[] move : direction) {
                        int newX = move[0] + current[0];
                        int newY = move[1] + current[1];

                        if (newX >= 0 && newX < boardSize && newY >= 0 && newY < boardSize
                                && !visited[newX][newY]) {
                            queue.add(new int[]{newX, newY});
                            visited[newX][newY] = true;
                        }
                    }
                }
                count++;
            }

            return count;
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ7562_bfs boj = new BOJ7562_bfs();
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
