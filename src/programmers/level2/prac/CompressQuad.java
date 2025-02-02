package programmers.level2.prac;

import java.util.Arrays;

public class CompressQuad {
    private int answer[] = new int[2];
    public int[] solution(int[][] arr) {
        int rStart = 0, rEnd = arr.length;
        int cStart = 0, cEnd = arr[0].length;

        compress(arr, rStart, rEnd, cStart, cEnd);
        return answer;
    }

    public void compress(int[][] arr, int rStart, int rEnd, int cStart, int cEnd) {
        int targetValue = arr[rStart][cStart];
        boolean isSame = true;
        for (int i = rStart; i < rEnd; i++) {
            for (int j = cStart; j < cEnd; j++) {
                if (arr[i][j] != targetValue) {
                    isSame = false;
                    break;
                }
            }
        }

        if (isSame) { // 같은 값을 가지고 있으면 누적
            answer[targetValue]++;
            return;
        }

        int rMid = (rStart + rEnd) / 2;
        int cMid = (cStart + cEnd) / 2;

        compress(arr, rStart, rMid, cStart, cMid); // 좌상
        compress(arr, rMid, rEnd, cStart, cMid); // 우상
        compress(arr, rStart, rMid, cMid, cEnd); // 좌하
        compress(arr, rMid, rEnd, cMid, cEnd); // 우하

    }
    public static void main(String[] args) {
        CompressQuad problem = new CompressQuad();
        int[][] input = {
                {1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}
        };
        System.out.println("problem.solution(input) = " + Arrays.toString(problem.solution(input)));
    }
}
