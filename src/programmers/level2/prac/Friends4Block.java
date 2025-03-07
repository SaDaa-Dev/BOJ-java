package programmers.level2.prac;

import java.util.ArrayList;
import java.util.List;

public class Friends4Block {

    public int solution(int m, int n, String[] board) {
        String[][] tBoard = new String[m][n];

        for (int i = 0; i < board.length; i++) {
            String[] split = board[i].split("");
            System.arraycopy(split, 0, tBoard[i], 0, split.length);
        }

        while (true) {
            List<int[]> breakable = getBreakable(m, n, tBoard);
            if (breakable.isEmpty()) {
                break;
            }

            for (int[] pos : breakable) {
                int x = pos[0];
                int y = pos[1];
                tBoard[x][y] = "";
                tBoard[x - 1][y - 1] = "";
                tBoard[x - 1][y] = "";
                tBoard[x][y - 1] = "";
            }

            dropBlocks(m, n, tBoard);
        }

        return countRemovedBlocks(m, n, tBoard);
    }

    private void dropBlocks(int m, int n, String[][] board) {
        for (int col = 0; col < n; col++) {
            for (int row = m - 1; row > 0; row--) {
                if (board[row][col].equals("")) {
                    int upper = row - 1;
                    while (upper >= 0 && board[upper][col].equals("")) {
                        upper--;
                    }
                    if (upper >= 0) {
                        board[row][col] = board[upper][col];
                        board[upper][col] = "";
                    }
                }
            }
        }
    }

    private int countRemovedBlocks(int m, int n, String[][] board) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j].equals("")) {
                    count++;
                }
            }
        }
        return count;
    }

    private static List<int[]> getBreakable(int m, int n, String[][] tBoard) {
        List<int[]> breakable = new ArrayList<>();
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (!tBoard[i][j].equals("")
                        && tBoard[i - 1][j - 1].equals(tBoard[i][j]) // 좌상
                        && tBoard[i - 1][j].equals(tBoard[i][j]) // 좌
                        && tBoard[i][j - 1].equals(tBoard[i][j]) // 상
                ) {
                    breakable.add(new int[]{i, j});
                }
            }
        }
        return breakable;
    }

    public static void main(String[] args) {
        Friends4Block problem = new Friends4Block();
        String[] input = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        problem.solution(4, 5, input);
    }
}
