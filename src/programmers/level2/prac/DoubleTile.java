package programmers.level2.prac;

// 2*n 타일링
public class DoubleTile {
    public int solution(int n) {
        final int MOD = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            System.out.println("dp[i] = " + dp[i]);
        }

        return dp[n];
    }
    public static void main(String[] args) {
        DoubleTile problem = new DoubleTile();
        System.out.println(problem.solution(4));
    }
}
