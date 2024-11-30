package programmers.greedy;

import java.util.Stack;

public class Problem2 {
    private class Sol {
        public String solution(String number, int k) {
            Stack<Character> stack = new Stack<>();
            int keep = number.length() - k;

            for (int i = 0; i < number.length(); i++) {
                char digit = number.charAt(i);
                while (!stack.isEmpty() && k > 0 && stack.peek() < digit) {
                    stack.pop();
                    k--;
                }
                stack.push(digit);
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.reverse().substring(0, keep);
        }
    }
    public static void main(String[] args) {
        Problem2 prom = new Problem2();
        Sol sol = prom.new Sol();
        System.out.println(sol.solution("1231234", 3));
    }
}
