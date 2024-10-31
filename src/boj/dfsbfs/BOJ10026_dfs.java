package boj.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10026_dfs {

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

        int countNormal = 0;
        int countColorBlind = 0;

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (!visitedNormal[y][x]) {
                    // 정상
                    dfs(x, y, visitedNormal, board[y][x], false);
                    countNormal++;
                }

                if (!visitedBlind[y][x]) {
                    // 색약
                    dfs(x, y, visitedBlind, board[y][x], true);
                    countColorBlind++;
                }
            }
        }
    }

    private static void dfs(int x, int y, boolean[][] visited, char currentColor, boolean isColorBlind) {
        visited[y][x] = true;

        for (int[] dir : DIRECTIONS) {
            int newY = y + dir[0];
            int newX = x + dir[1];

            if (newY >= 0 && newY < n && newX >= 0 && newX < n && !visited[newY][newX]) {
                char nextColor = board[newY][newX];
                if (isColorBlind) {
                    if (isSameColorForColorBlind(currentColor, nextColor)) {
                        dfs(newY, newX, visited, currentColor, true);
                    }
                } else {
                    if (currentColor == nextColor) {
                        dfs(newY, newX, visited, currentColor, false);
                    }
                }
            }
        }
    }

    private static boolean isSameColorForColorBlind(char a, char b) {
        if (a == 'B' || b == 'B') {
            return a == b;
        }
        // 'R'과 'G'는 색약인 경우 동일하게 취급
        return (a == 'R' || a == 'G') && (b == 'R' || b == 'G');
    }
}
