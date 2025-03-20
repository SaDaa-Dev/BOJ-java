package programmers.level3.prac;

public class LongestPalindrome {
    public int solution(String s) {
        int answer = 1;

        for (int i = 0; i < s.length(); i++) {
            // 홀수 길이 팰린드롬
            answer = Math.max(answer, expandPalindrome(s, i, i));

            // 짝수 길이 팰린드롬
            answer = Math.max(answer, expandPalindrome(s, i, i + 1));
        }

        return answer;
    }

    private int expandPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindrome problem = new LongestPalindrome();
        System.out.println(problem.solution("abcdcba"));
        System.out.println(problem.solution("abacde"));
    }
}
