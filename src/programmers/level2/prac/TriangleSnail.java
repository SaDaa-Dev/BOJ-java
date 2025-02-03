package programmers.level2.prac;

import java.util.ArrayList;
import java.util.Arrays;

// 삼각 달팽이
// 전략 : 외각 삼각형부터 -> 내부삼각형까지 완성시키기 To maxNum까지
public class TriangleSnail {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        ArrayList<Integer> result = new ArrayList<>();
        int number = 1;
        int x = -1, y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else if (i % 3 == 2) {
                    x--;
                    y--;
                }
                triangle[x][y] = number++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (triangle[i][j] != 0) {
                    result.add(triangle[i][j]);
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        TriangleSnail problem = new TriangleSnail();
        System.out.println("problem.solution(5) = " + Arrays.toString(problem.solution(5)));
    }
}
