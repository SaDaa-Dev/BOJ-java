package programmers.retry;

import java.util.ArrayList;
import java.util.List;

// 재귀 공부로 적합
// https://shoark7.github.io/programming/algorithm/tower-of-hanoi
public class TowerOfHanoi {
    private List<int[]> result = new ArrayList<>();
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        return result.toArray(new int[result.size()][]);
    }

    private void hanoi(int n, int startT, int targetT, int assistT) {
        if (n == 1) {
            result.add(new int[]{startT, targetT});
            return;
        }

        hanoi(n - 1, startT, assistT, targetT);
        result.add(new int[]{startT, targetT});
        hanoi(n - 1, assistT, targetT, startT);
    }

    public static void main(String[] args) {
        TowerOfHanoi problem = new TowerOfHanoi();
        problem.solution(3);
    }
}
