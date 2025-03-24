package programmers.level2.prac;

import java.util.Arrays;

public class EatLand {

    public int solution(int[][] land) {
        int row = land.length;
        int[][] prefixLand = new int[row][4];

        for (int i = 0; i < 4; i++) {
            prefixLand[0][i] = land[0][i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (j == k) {
                        continue;
                    }

                    prefixLand[i][j] = Math.max(prefixLand[i][j], prefixLand[i - 1][k] + land[i][j]);
                }
            }
        }

        return Arrays.stream(prefixLand[row - 1]).max().getAsInt();
    }
    public static void main(String[] args) {
        EatLand problem = new EatLand();
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        problem.solution(land);
    }
}
