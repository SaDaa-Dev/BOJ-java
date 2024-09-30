package programmers.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem4 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };

        int[] result = solution(arr, commands);
        for (int data : result) {
            System.out.println("data = " + data);
        }
    }

    private static int[] solution(int[] arr, int[][] commands) {
        int[] result = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int k = commands[i][2] - 1;

            int[] subArray = Arrays.copyOfRange(arr, start, end);
            Arrays.sort(subArray);

            // k번째 값을 결과 배열에 저장
            result[i] = subArray[k];
        }

        return result;
    }
}
