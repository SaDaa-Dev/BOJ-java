package programmers.level2.prac;

import java.util.Arrays;
import java.util.Stack;

public class FindBigNumberBack {
    /*// 첫번째 솔루션 : 시간 초과
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int max = numbers[i];
            for (int j = i + 1; j < n; j++) {
                // 가장 끝 idx : -1 Or 큰 수가 없을 경우
                if (numbers[j] > max) {
                    max = numbers[j];
                    break;
                }
            }

            if (max == numbers[i]) {
                answer[i] = -1;
            } else {
                answer[i] = max;
            }
        }

        return answer;
    }*/

    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int current = numbers[i];
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = stack.peek();
            }

            stack.push(current);
        }


        return answer;
    }
    public static void main(String[] args) {
        FindBigNumberBack prom = new FindBigNumberBack();
        int[] input = {2, 3, 3, 5};
        System.out.println(Arrays.toString(prom.solution(input)));
    }
}
