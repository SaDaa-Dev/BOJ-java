package programmers.stack;

public class Problem3 {
    public static void main(String[] args) {
        System.out.println("solution = " + solution(")()("));
    }

    // 내 풀이
    private static Boolean solution(String s) {
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (start == 0 && (s.charAt(i) == ')')) {
                return false;
            }

            if (s.charAt(i) == '(') {
                start += 1;
            } else if (s.charAt(i) == ')') {
                start -= 1;
            }
        }

        if (start == 0) {
            return true;
        } else {
            return false;
        }
    }

    // 최적화
    private static Boolean solutionOpt(String s) {
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                balance++;
            } else if (s.charAt(i) == ')') {
                balance--;
            }

            // If balance goes negative, there are more closing than opening brackets
            if (balance < 0) {
                return false;
            }
        }

        // Return true if balance is zero, false otherwise
        return balance == 0;
    }
}
