package programmers.level2.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Friends4Block {

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        String[][] tBoard = new String[m][n];
        for (int i = 0; i < board.length; i++) {
            String[] split = board[i].split("");
            for (int j = 0; j < split.length; j++) {
                tBoard[i][j] = split[j];
            }
        }

        for (String[] strings : tBoard) {
            System.out.println(Arrays.toString(strings));
        }

        while (true) {
            // 제거 블록 후보
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

            for (String[] strings : tBoard) {
                System.out.println(Arrays.toString(strings));
            }
            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (tBoard[i][j].equals("")) {
                        for (int k = i - 1; k >= 0; k--) {
                            if (!tBoard[k][j].equals("")) {
                                tBoard[i][j] = tBoard[k][j];
                                tBoard[k][j] = "";
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println("=========Cycle========");
            for (String[] strings : tBoard) {
                System.out.println(Arrays.toString(strings));
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tBoard[i][j].equals("")) {
                    answer++;
                }
            }
        }

        return answer;
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
