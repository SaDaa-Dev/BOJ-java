package programmers.level2.prac;

import java.util.ArrayList;
import java.util.Arrays;

public class CutArray {
    public int[] solution(int n, long left, long right) {
        ArrayList<Integer> result = new ArrayList<>();
        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;

            result.add((int) Math.max(row + 1, col + 1));
        }


        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
    public static void main(String[] args) {
        CutArray prom = new CutArray();
        System.out.println(Arrays.toString(prom.solution(3, 2, 5)));
    }
}
