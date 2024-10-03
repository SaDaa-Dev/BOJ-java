package programmers.sort;

import java.util.Arrays;

public class Problem3 {
    public static void main(String[] args) {
        int[] data = {3, 0, 6, 1, 5};
        int result = solution(data);
        System.out.println("result = " + result);
    }

    private static int solution(int[] citations) {
        int re = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                re = h;
                break;
            }
        }

        return re;
    }
}
