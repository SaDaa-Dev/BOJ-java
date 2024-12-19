package programmers.dynamic;

public class Problem2 {
    private class Sol {
        public int solution(int[][] triangle) {
            int n = triangle.length;
            int[][] dp = new int[n][n];
            dp[0][0] = triangle[0][0];

            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][j] + triangle[i][j];
                    } else if (j == i) {
                        dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                    }
                }
            }

            int answer = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, dp[n - 1][j]);
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        Problem2 prom = new Problem2();
        Sol sol = prom.new Sol();
        int[][] input = new int[][]{
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };

        System.out.println(sol.solution(input));
    }
}