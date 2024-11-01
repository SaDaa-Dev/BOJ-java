package boj.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10026_bfs {

    private static int n;
    private static boolean[][] visitedNormal;
    private static boolean[][] visitedBlind;
    private static char[][] board;
    private static final int[][] DIRECTIONS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] rgbs = br.readLine().toCharArray();
            board[i] = rgbs;
        }

        visitedNormal = new boolean[n][n];
        visitedBlind = new boolean[n][n];

        int normalCnt = 0;
        int blindCnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visitedNormal[i][j]) {
                    // 멀쩡
                    bfs(board, visitedNormal, i, j, n, false);
                    normalCnt++;
                }

                if (!visitedBlind[i][j]) {
                    // 색약
                    bfs(board, visitedBlind, i, j, n, true);
                    blindCnt++;
                }
            }
        }

        System.out.println(normalCnt + " " + blindCnt);
    }

    private static void bfs(char[][] board, boolean[][] visited, int x, int y, int n, boolean blindFlag) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        char currentColor = board[x][y];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int ox = current[0];
            int oy = current[1];

            for (int[] dir : DIRECTIONS) {
                int newX = ox + dir[0];
                int newY = oy + dir[1];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY]) {
                    char newColor = board[newX][newY];

                    if (blindFlag) {
                        if ((currentColor == 'R' || currentColor == 'G') &&
                            (newColor == 'R' || newColor == 'G')) {
                            queue.offer(new int[]{newX, newY});
                            visited[newX][newY] = true;
                        } else if (currentColor == 'B' && newColor == 'B') {
                            queue.offer(new int[]{newX, newY});
                            visited[newX][newY] = true;
                        }
                    }
                    else {
                        if (currentColor == newColor) {
                            queue.add(new int[]{newX, newY});
                            visited[newX][newY] = true;
                        }
                    }
                }
            }
            
        }
    }
}
