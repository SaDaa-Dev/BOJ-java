package programmers.level2.prac;

import java.util.Stack;

public class SpinParentheses {
    public int solution(String s) {
        int n = s.length();
        int result = 0;

        // n번 회전
        for (int i = 0; i < n; i++) {
            // 왼쪽으로 i칸 회전한 문자열
            String rotated = s.substring(i) + s.substring(0, i);

            // 올바른 괄호인지 검사
            if (isValid(rotated)) {
                result++;
            }
        }

        return result;
    }

    private boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // c가 닫힌 괄호인 경우
                if (stack.isEmpty()) return false;

                char top = stack.peek();
                if ((c == ')' && top == '(') ||
                        (c == ']' && top == '[') ||
                        (c == '}' && top == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        // 스택이 비어야 완벽히 짝이 맞음
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        SpinParentheses prom = new SpinParentheses();
        System.out.println(prom.solution("[](){}"));
    }
}
