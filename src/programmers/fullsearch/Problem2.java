package programmers.fullsearch;

import java.util.Arrays;
import java.util.LinkedList;

public class Problem2 {
    public static void main(String[] args) {
        int[] input = {1,3,2,4,2};
        int[] re = solution(input);
        for (int i : re) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(int[] answers) {
        LinkedList<Integer> re = new LinkedList<>();
        int[] correctArr = new int[3];
        int[] firstPreset = {1, 2, 3, 4, 5};
        int[] secondPreset = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdPreset = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            int firstIdx = i % 5;
            int secondIdx = i % 8;
            int thirdIdx = i % 10;

            if (answers[i] == firstPreset[firstIdx]) {
                correctArr[0]++;
            }

            if (answers[i] == secondPreset[secondIdx]) {
                correctArr[1]++;
            }

            if (answers[i] == thirdPreset[thirdIdx]) {
                correctArr[2]++;
            }
        }

        int maxValue = Arrays.stream(correctArr)
                .max()
                .getAsInt();

        for (int i = 0; i < correctArr.length; i++) {
            if (maxValue <= correctArr[i]) {
                re.add(i + 1);
            }
        }

        return re.stream().mapToInt(Integer::intValue).toArray();
    }
}
