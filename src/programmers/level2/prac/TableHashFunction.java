package programmers.level2.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TableHashFunction {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.asList(data).sort(
                Comparator.comparingInt((int[] o) -> o[col - 1])
                        .thenComparing(Comparator.comparingInt((int[] o) -> o[0]).reversed())
        );

        ArrayList<Integer> hashTable = new ArrayList<>();
        for (int i = row_begin - 1; i < row_end; i++) {
            int hashSum = 0;
            for (int targetData : data[i]) {
                int remainder = targetData % (i + 1);
                hashSum += remainder;
            }

            hashTable.add(hashSum);
        }

        for (int value : hashTable) {
            answer ^= value;
        }

        return answer;
    }
    public static void main(String[] args) {
        TableHashFunction problem = new TableHashFunction();
        int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
        System.out.println(problem.solution(data, 2, 2, 3));
    }
}
