package programmers.level2.prac;

import java.util.ArrayDeque;

public class ConvertParentheses {
    public String solution(String p) {
        if (p.isBlank()) return "";
        String answer = "";
        answer = recursion(p);
        return answer;
    }

    private String recursion(String p) {
        if (p.isEmpty()) return "";
        String[] uv = separateStr(p);
        String u = uv[0];
        String v = uv[1];
        if (isRightStr(u)) { // u가 올바른 문자열
            return u + recursion(v);
        } else { // u가 올바르지 않은 문자열
            return "(" + recursion(v) + ")" + reverseInsideParentheses(u.substring(1, u.length() - 1));
        }
    }

    private String reverseInsideParentheses(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i) == '(' ? ')' : "(");
        }

        return sb.toString();
    }

    private String[] separateStr(String p) {
        int open = 0, close = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') open++;
            else close++;

            if (open == close) {
                return new String[]{p.substring(0, i + 1), p.substring(i + 1)};
            }
        }
        return new String[]{p, ""}; // 만약 모든 문자열이 균형잡힌 경우
    }

    private boolean isRightStr(String str) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else { // ')' 일 때
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ConvertParentheses problem = new ConvertParentheses();
        problem.solution("()))((()");
    }
}
