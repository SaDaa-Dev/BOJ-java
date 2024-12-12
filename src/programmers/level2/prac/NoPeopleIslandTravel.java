package programmers.level2.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoPeopleIslandTravel {
    private class Solution {
        private final int[][] DIRECTION = {
                {0, 1},
                {0, -1},
                {-1, 0},
                {1, 0}
        };

        private class Pos {
            int x;
            int y;

            public Pos(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public int[] solution(String[] maps) {
            int row = maps.length;
            int col = maps[0].length();

            int[][] board = new int[row][col];
            for (int i = 0; i < row; i++) {
                String[] splitStr = maps[i].split("");
                for (int j = 0; j < splitStr.length; j++) {
                    if (splitStr[j].equals("X")) {
                        board[i][j] = 0;
                    } else {
                        board[i][j] = Integer.parseInt(splitStr[j]);
                    }
                }
            }

            boolean[][] visited = new boolean[row][col];
            List<Integer> results = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 0) {
                        visited[i][j] = true;
                    }

                    if (!visited[i][j]) {
                        results.add(dfs(board, visited, i, j, 0));
                    }
                }
            }

            if (results.isEmpty()) {
                return new int[]{-1};
            } else {
                return results.stream().mapToInt(Integer::valueOf).sorted().toArray();
            }
        }

        private int dfs(int[][] board, boolean[][] visited, int i, int j, int currentSum) {
            currentSum += board[i][j];
            visited[i][j] = true;

            for (int[] dir : DIRECTION) {
                int nx = i + dir[0];
                int ny = j + dir[1];

                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length
                    && !visited[nx][ny] && board[nx][ny] != 0) {
                    currentSum = dfs(board, visited, nx, ny, currentSum);
                }
            }

            return currentSum;
        }
    }
    public static void main(String[] args) {
        NoPeopleIslandTravel prom = new NoPeopleIslandTravel();
        Solution sol = prom.new Solution();
        String[] info = new String[]{
                new String("X591X"),
                new String("X1X5X"),
                new String("X231X"),
                new String("1XXX1")
        };

        int[] re = sol.solution(info);
        for (int r : re) {
            System.out.print(r + " ");
        }
    }
}
