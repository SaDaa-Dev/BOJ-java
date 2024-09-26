package programmers.stack;

import java.util.LinkedList;
import java.util.Stack;

public class Problem6 {
    public static void main(String[] args) {
        int[] re = solution(new int[]{1, 2, 3, 2, 3});
        for (int i : re) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(int[] prices) {
        int len = prices.length;
        int[] result = new int[len];
        Stack<Integer> indexs = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!indexs.isEmpty() && prices[i] < prices[indexs.peek()]) {
                int idx = indexs.pop();
                result[idx] = i - idx;
            }
            indexs.push(i);
        }

        while (!indexs.isEmpty()) {
            int idx = indexs.pop();
            result[idx] = len - idx - 1;
        }

        return result;
    }
}
