package programmers.dynamic;

public class Problem3 {
    private class Solution {

        public int solution(int m, int n, int[][] puddles) {
            int MOD = 1_000_000_007;

            int[][] dp = new int[n][m];
            boolean[][] puddleMap = new boolean[n][m];
            for (int[] puddle : puddles) {
                puddleMap[puddle[1] - 1][puddle[0] - 1] = true;
            }

            dp[0][0] = 1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (puddleMap[i][j]) {
                        dp[i][j] = 0;
                        continue;
                    }

                    if (i > 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                    }
                    if (j > 0) {
                        dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                    }
                }
            }

            return dp[n - 1][m - 1];
        }
    }
    public static void main(String[] args) {
        Problem3 prom = new Problem3();
        Solution solution = prom.new Solution();
        System.out.println(solution.solution(4, 3, new int[][]{{2, 2}}));
    }
}
