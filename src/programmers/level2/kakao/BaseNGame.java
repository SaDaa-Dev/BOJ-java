package programmers.level2.kakao;

// N진수 게임
public class BaseNGame {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; sb.length() < t * m; i++) {
            sb.append(Integer.toString(i, n));
        }

        for (int i = p - 1; answer.length() < t; i = i + m) {
            answer.append(sb.charAt(i));
        }

        return answer.toString().toUpperCase();
    }

    public static void main(String[] args) {
        BaseNGame problem = new BaseNGame();
        System.out.println(problem.solution(2, 4, 2, 1));
    }
}
