package programmers.level2.prac;

import java.util.Arrays;

// 행렬의 곱셈
public class MultipleProcession {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;            // arr1의 행 크기
        int p = arr1[0].length;         // arr1의 열 크기 == arr2의 행 크기
        int m = arr2[0].length;         // arr2의 열 크기

        // 결과 배열: n x m
        int[][] result = new int[n][m];

        // 행렬 곱셈
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                int sum = 0;
                for (int j = 0; j < p; j++) {
                    sum += arr1[i][j] * arr2[j][k];
                }
                result[i][k] = sum;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MultipleProcession prom = new MultipleProcession();
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};
        System.out.println(Arrays.toString(Arrays.stream(prom.solution(arr1, arr2)).toArray()));
    }
}
