package programmers.level3.prac;

public class ExchangeMoney {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int coin : money) {
            for (int amount = coin; amount <= n; amount++) {
                dp[amount] += dp[amount - coin];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        ExchangeMoney problem = new ExchangeMoney();
        System.out.println(problem.solution(5, new int[]{1, 2, 5}));
    }
}
